package com.example.projectboard.repository;

import com.example.projectboard.config.JpaConfig;
import com.example.projectboard.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Jpa 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {
    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;


    public JpaRepositoryTest(@Autowired ArticleRepository articleRepository,@Autowired ArticleCommentRepository articleCommentRepository){
        this.articleCommentRepository = articleCommentRepository;
        this.articleRepository = articleRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine(){
        //Given

        //When
        List<Article> articles = articleRepository.findAll();

        //Then
        assertThat(articles)
                .isNotNull()
                .hasSize(0);

    }

    @DisplayName("insert 테스트")
    @Test
    void givenTestData_whenInserting_thenWorksFine(){
        //Given
        long previousCount = articleRepository.count();


        //When
        Article savedArticle = articleRepository.save(Article.of("new article", "new content", "#spring"));

        //Then
        assertThat(articleRepository.count())
                .isEqualTo(previousCount +1);

    }

    @DisplayName("updating 테스트")
    @Test
    void givenTestData_whenUpdating_thenWorksFine(){
        //Given
        Article article = articleRepository.findById(1L).orElseThrow();
        String updateHashtag = "#springboot";
        article.setHashtag(updateHashtag);

        //When
        Article savedArticle = articleRepository.saveAndFlush(article);

        //Then
        assertThat(savedArticle)
                .hasFieldOrPropertyWithValue("hashtag", updateHashtag);

    }

    @DisplayName("updating 테스트")
    @Test
    void givenTestData_whenDeleting_thenWorksFine(){
        //Given
        Article article = articleRepository.findById(1L).orElseThrow();
        long previousArticleCount = articleRepository.count();
        long previousArticleCommentCount = articleRepository.count();
        int deletedCommnetsSize = article.getArticleComments().size(); //지워질 댓글의 사이즈

        String updateHashtag = "#springboot";
        article.setHashtag(updateHashtag);

        //When
        articleRepository.delete(article);

        //Then
        assertThat(articleRepository.count()).isEqualTo(previousArticleCount -1);


    }




}