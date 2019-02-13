package com.testTask.entity.models;

import com.testTask.enums.Colors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleRequest {

    private String text;
    private Colors color;
    private Long userId;
}
