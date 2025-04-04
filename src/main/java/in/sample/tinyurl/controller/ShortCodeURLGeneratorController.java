package in.sample.tinyurl.controller;

import in.sample.tinyurl.service.ShortCodeURLGeneratorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1")
public class ShortCodeURLGeneratorController {

    @Value("${shortener.base-url}")
    private String baseUrl;

    private final ShortCodeURLGeneratorService shortCodeURLGeneratorService;

    public ShortCodeURLGeneratorController(ShortCodeURLGeneratorService shortCodeURLGeneratorService) {
        this.shortCodeURLGeneratorService = shortCodeURLGeneratorService;
    }

    @PostMapping(path = "/short-url" , produces = {"application/json"} , consumes = {"application/json"})
    public ResponseEntity<?> generateShortURL(@RequestBody Map<String,String> requestBody) {
        String longURL = requestBody.get("longURL");
        String shortCode = shortCodeURLGeneratorService.shortCodeURLGenerator(longURL);
        String shortURL = baseUrl+shortCode;
        return new ResponseEntity<>(Map.of("shortURL" ,shortURL), HttpStatus.OK);
    }

    @GetMapping(path = "/short-url/{shortCode}")
    public ResponseEntity<?> getLongURL(@PathVariable String shortCode) {
        String longURL = shortCodeURLGeneratorService.fetchLongURL(shortCode);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(longURL));
        return new ResponseEntity<>(headers,HttpStatus.FOUND);
    }
}
