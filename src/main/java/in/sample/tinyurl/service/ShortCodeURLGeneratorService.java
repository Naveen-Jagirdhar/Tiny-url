package in.sample.tinyurl.service;

import in.sample.tinyurl.components.ShortCodeGenerator;
import in.sample.tinyurl.entities.ShortURLEntity;
import in.sample.tinyurl.repository.ShortCodeEntityRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ShortCodeURLGeneratorService {

    private final ShortCodeGenerator shortCodeGenerator;
    private final ShortCodeEntityRepository shortCodeEntityRepository;

    public ShortCodeURLGeneratorService(ShortCodeGenerator shortCodeGenerator, ShortCodeEntityRepository shortCodeEntityRepository) {
        this.shortCodeGenerator = shortCodeGenerator;
        this.shortCodeEntityRepository = shortCodeEntityRepository;
    }

    public String shortCodeURLGenerator(String longURL) {
        String shortCode = shortCodeGenerator.generateShortCode();
        ShortURLEntity shortURLEntity = new ShortURLEntity();
        shortURLEntity.setShortCode(shortCode);
        shortURLEntity.setLongURL(longURL);
        shortURLEntity.setExpiryDate(LocalDateTime.now().plusDays(1));

        shortCodeEntityRepository.save(shortURLEntity);

        return shortCode;
    }

    public String fetchLongURL(String shortCode) {
        ShortURLEntity entity = shortCodeEntityRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));

        if (entity.getExpiryDate() != null && entity.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("This short URL has expired.");
        }
        entity.setAccessCount(entity.getAccessCount() + 1);
        shortCodeEntityRepository.save(entity);
        return entity.getLongURL();
    }
}
