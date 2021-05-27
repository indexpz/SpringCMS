package pl.codeslab.app.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="authors")
@Getter
@Setter
@ToString(exclude = "articles")
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @OneToMany
    @JoinColumn(name="author_id")
    private List<Article> articles = new ArrayList<>();

}
