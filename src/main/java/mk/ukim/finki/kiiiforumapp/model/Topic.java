package mk.ukim.finki.kiiiforumapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;
    private LocalDate dateCreated;
    private LocalDateTime edited;

    @ManyToOne
    private Category category;

    public Topic(String title, String text, Category category) {
        this.title = title;
        this.text = text;
        this.dateCreated = LocalDate.now();
        this.edited = LocalDateTime.now();
        this.category = category;
    }
}
