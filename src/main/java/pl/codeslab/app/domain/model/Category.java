package pl.codeslab.app.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="categorys")
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100,nullable = false)
    private String name;
    @Column(length = 2000)
    private String description;
}
