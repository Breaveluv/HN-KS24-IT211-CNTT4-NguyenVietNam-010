package com.example.nguyenvietnam_cntt4_010.controller;


import com.example.nguyenvietnam_cntt4_010.model.dto.PostRequestDTO;
import com.example.nguyenvietnam_cntt4_010.model.entity.Post;
import com.example.nguyenvietnam_cntt4_010.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @GetMapping
    public List<Post> getAll(@RequestParam(required = false) String username,
                             @RequestParam(required = false) String content) {
        return postService.getAllPosts(username, content);
    }

    @PostMapping
    public Post create(@Valid @RequestBody PostRequestDTO postRequestDTO) {
        return postService.createPost(postRequestDTO);
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable Long id, @Valid @RequestBody PostRequestDTO postRequestDTO) {
        return postService.updatePost(id, postRequestDTO);

    }
    @PatchMapping("/{id}")
    public Post partialUpdate(
            @PathVariable Long id, @Valid @RequestBody PostRequestDTO postRequestDTO) {
        return postService.partialUpdatePost(id, postRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        postService.deletePost(id);
    }

}