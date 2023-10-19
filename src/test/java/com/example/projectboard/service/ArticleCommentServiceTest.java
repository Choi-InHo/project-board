package com.example.projectboard.service;

import com.example.projectboard.domain.Article;
import com.example.projectboard.domain.ArticleComment;
import com.example.projectboard.dto.ArticleCommentDto;
import com.example.projectboard.repository.ArticleCommentRepository;
import com.example.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;


@DisplayName("비즈니스 로직 - 댓글")
@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {

    @InjectMocks private ArticleCommentService sut;

    @Mock
    private ArticleCommentRepository articleCommentRepository;

    @Mock  private ArticleRepository articleRepository;

    @DisplayName("게시글 ID로 조회하면 , 해당하는 댓글 리스트를 뽑아온다")
    @Test
    void givenArticleId_whenSearchingArticleComments_thenReturnsArtilceComments(){
        //given
        Long articleId = 1L;
        given(articleRepository.findById(articleId)).willReturn(Optional.of
                (Article.of("title","content","#JAVA"))
        );
        //when
        List<ArticleCommentDto> articleComments =  sut.searchArticleComment(articleId);

        //then
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }

    @DisplayName("게시글 정보를 입력하면 , 댓글을 저장한다.")
    @Test
    void given_when_then(){
        //given
        Long articleId = 1L;
        given(articleRepository.findById(articleId)).willReturn(Optional.of
                (Article.of("title","content","#JAVA"))
        );
        //when
        List<ArticleCommentDto> articleComments =  sut.searchArticleComment(articleId);

        //then
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }
}