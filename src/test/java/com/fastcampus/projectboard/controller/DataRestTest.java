package com.fastcampus.projectboard.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Data Rest -API Test")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {
  private final MockMvc mvc;

  public DataRestTest(@Autowired MockMvc mvc){
    this.mvc = mvc;
  }

  @DisplayName("[api] 게시글 리스트 조회")
  @Test
  void givenNothing_whenRequestingArticles_thenReturnArticlesJsonResponse() throws Exception {
    // Given

    //When & Then
    mvc.perform(get("/api/articles"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
  }

  @DisplayName("[api] 게시글 단건 조회")
  @Test
  void givenNothing_whenRequestingArticle_thenReturnArticlesJsonResponse() throws Exception {
    // Given

    //When & Then
    mvc.perform(get("/api/articles/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
  }

  @DisplayName("[api] 게시글 -> 댓글 리스트 조회")
  @Test
  void givenNothing_whenRequestingArticleCommentsFromArticle_thenReturnArticlesJsonResponse() throws Exception {
    // Given

    //When & Then
    mvc.perform(get("/api/articles/1/articleComments"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
  }

  @DisplayName("[api] 댓글 리스트 조회")
  @Test
  void givenNothing_whenRequestingArticleArticleComments_thenReturnArticlesJsonResponse() throws Exception {
    // Given

    //When & Then
    mvc.perform(get("/api/articleComments"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
  }

  @DisplayName("[api] 댓글 단건 조회")
  @Test
  void givenNothing_whenRequestingArticleComment_thenReturnArticlesJsonResponse() throws Exception {
    // Given

    //When & Then
    mvc.perform(get("/api/articleComments/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
  }
}
