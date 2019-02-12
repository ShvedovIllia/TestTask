package test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.enums.Colors;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "article/")
public class ArticleEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "text")
    private String text;
    @Column(name = "color")
    private Colors color;
}
