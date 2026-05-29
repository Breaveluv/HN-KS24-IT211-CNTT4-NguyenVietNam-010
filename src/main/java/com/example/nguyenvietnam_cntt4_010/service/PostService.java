package com.example.nguyenvietnam_cntt4_010.service;

import com.example.nguyenvietnam_cntt4_010.model.dto.PostRequestDTO;
import com.example.nguyenvietnam_cntt4_010.model.entity.Post;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    List<Post> getAllPosts(String username, String content);
    Post createPost(@Valid PostRequestDTO post);
    Post updatePost(Long id, PostRequestDTO post);
    Post partialUpdatePost(Long id, @Valid PostRequestDTO post);
    void deletePost(Long id);

}