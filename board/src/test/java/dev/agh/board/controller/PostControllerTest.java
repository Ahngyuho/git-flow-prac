package dev.agh.board.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.agh.board.SpringSecurityConfigTest;
import dev.agh.board.config.SecurityConfig;
import dev.agh.board.request.PostCreate;
import dev.agh.board.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Import(SpringSecurityConfigTest.class)
@WebMvcTest(PostController.class)
class PostControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PostService postService;

    @Test
//    @WithMockUser
    @DisplayName("제목과 본문을 포함하는 글 작성 시 성공")
    public void given_when_then() throws Exception {
        //given
        PostCreate postCreate = PostCreate.builder()
                .content("test")
                .title("test")
                .build();

        String json = objectMapper.writeValueAsString(postCreate);
        //
        mvc.perform(post("/api/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andDo(print());

        BDDMockito.then(postService).should().create(any(PostCreate.class));
    }

}