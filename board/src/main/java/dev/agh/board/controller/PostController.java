package dev.agh.board.controller;

import dev.agh.board.config.UserPrincipal;
import dev.agh.board.request.PostCreate;
import dev.agh.board.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/posts")
    public void postCreate(Authentication authentication, @RequestBody @Valid PostCreate postCreate) {
        postService.create(authentication.getName(), postCreate);
    }
}
