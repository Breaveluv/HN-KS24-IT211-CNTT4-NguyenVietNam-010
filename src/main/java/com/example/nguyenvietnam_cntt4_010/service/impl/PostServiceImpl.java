package com.example.nguyenvietnam_cntt4_010.service.impl;

import com.example.nguyenvietnam_cntt4_010.model.dto.PostRequestDTO;
import com.example.nguyenvietnam_cntt4_010.model.entity.Post;
import com.example.nguyenvietnam_cntt4_010.repository.PostRepository;
import com.example.nguyenvietnam_cntt4_010.service.PostService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts(String username, String content) {
        List<Post> posts = postRepository.findAll();

        if (username != null && !username.trim().isEmpty()) {
            posts = posts.stream()
                    .filter(post -> post.getUsername().toLowerCase().contains(username.toLowerCase()))
                    .collect(Collectors.toList());
        }

        if (content != null && !content.trim().isEmpty()) {
            posts = posts.stream()
                    .filter(post -> post.getContent().toLowerCase().contains(content.toLowerCase()))
                    .collect(Collectors.toList());
        }

        return posts;
    }

    @Override
    public Post createPost(@Valid @RequestBody PostRequestDTO post) {
        Post post1= new Post();
        post1.setUsername(post.getUsername());
        post1.setContent(post.getContent());
        post1.setLikes(1);
        post1.setStatus(post.getStatus());
        post1.setIs_deleted(false);
        post1 = postRepository.save(post1);
        return post1;
    }

    @Override
    public Post updatePost(Long id, PostRequestDTO post) {
        Post existingPost = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
        if(existingPost !=null){
            existingPost.setUsername(post.getUsername());
            existingPost.setContent(post.getContent());
            existingPost.setLikes(post.getLikes());
            existingPost.setStatus(post.getStatus()); 
            existingPost = postRepository.save(existingPost);
            return existingPost;
        }
        return null;
    }

    @Override
    public Post partialUpdatePost(Long id, @Valid PostRequestDTO post) {
        Post existingPost = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
        if(existingPost != null){
            if(post.getContent() != null){
                existingPost.setContent(post.getContent());
            }
            if(post.getStatus() != null){
                existingPost.setStatus(post.getStatus());
            }
            existingPost = postRepository.save(existingPost);
            return existingPost;
        }
        return null;
    }

    @Override
    public void deletePost(Long id) {
        Post deletePost = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
        if(deletePost != null){
            deletePost.setIs_deleted(true);
            postRepository.save(deletePost);
        }

    }
}