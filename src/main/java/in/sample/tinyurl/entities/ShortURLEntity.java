package in.sample.tinyurl.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "short_url_details")
public class ShortURLEntity extends Auditable{

    @Column(nullable = false , unique = true ,length = 6)
    private String shortCode;
    @Column(nullable = false , columnDefinition = "Text")
    private String longURL;
    private LocalDateTime expiryDate;
    private int accessCount;
}
