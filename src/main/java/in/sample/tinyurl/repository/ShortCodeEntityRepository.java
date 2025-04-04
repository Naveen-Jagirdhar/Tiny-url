package in.sample.tinyurl.repository;

import in.sample.tinyurl.entities.ShortURLEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortCodeEntityRepository extends JpaRepository<ShortURLEntity,Long> {
    Optional<ShortURLEntity> findByShortCode(String shortCode);
}
