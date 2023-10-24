package com.example.projectboard.dto.request;

import com.example.projectboard.dto.ArticleCommentDto;
import com.example.projectboard.dto.UserAccountDto;

public record ArticleCommentRequest(Long articleId, String content) {

    public static ArticleCommentRequest of(Long articleId, String content) {
        return new ArticleCommentRequest(articleId, content);
    }

    //useraccount dto 를 통해서 dto를 만드는 부분.. 이게 왜 필요할까?
    public ArticleCommentDto toDto(UserAccountDto userAccountDto) {
        return ArticleCommentDto.of(
                articleId,
                userAccountDto,
                content
        );
    }

}