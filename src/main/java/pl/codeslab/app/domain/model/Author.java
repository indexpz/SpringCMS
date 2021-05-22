package pl.codeslab.app.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="authors")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String firstName;
    @Column(length = 100, nullable = false)
    private String lastName;
}
