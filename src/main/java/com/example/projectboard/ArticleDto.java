package com.example.projectboard;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.projectboard.domain.Article}
 */
@Value
public class ArticleDto implements Serializable {
    Long id;
    String title;
    String content;
    String hashtag;
    LocalDateTime createdAt;
    String createdBy;
    LocalDateTime modifiedAt;
    String modifiedBy;
}