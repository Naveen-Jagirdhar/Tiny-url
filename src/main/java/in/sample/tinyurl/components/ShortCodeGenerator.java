package in.sample.tinyurl.components;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class ShortCodeGenerator {

    private final static String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    private final static int LENGTH = 6;

    public String generateShortCode() {
        StringBuilder code = new StringBuilder();
        Random random = new SecureRandom();
        for (int i = 0; i < LENGTH; i++) {
            int index = random.nextInt(CHAR_SET.length());
            code.append(CHAR_SET.charAt(index));
        }
        return code.toString();
    }
}
