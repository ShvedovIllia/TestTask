package test.entity.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import test.enums.Colors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleRequest {

    private String text;
    private Colors color;
    private Long userId;
}
