package pl.codeslab.app.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articles")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String title;
    @Column(length = 2500)
    private String content;

    @OneToMany(mappedBy = "article")
    private List<Category> categories = new ArrayList<>();// - (powiązanie relacją do klasy Category) - artykuł może należeć do wielu kategorii



    @Column()
    private String created;// (wartość ma być automatycznie dodawana podczas zapisu)
    @Column()
    private String updated;//
}
