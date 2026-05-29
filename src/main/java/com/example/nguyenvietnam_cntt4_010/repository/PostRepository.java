package com.example.nguyenvietnam_cntt4_010.repository;

import com.example.nguyenvietnam_cntt4_010.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUsername(String username);
    Optional<Post> findById(Long id);

}
