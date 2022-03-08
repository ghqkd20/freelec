package com.freelec.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface postsRepository extends JpaRepository<posts,Long> {
    @Query("SELECT p FROM posts p ORDER BY p.id DESC")
    List<posts> findAllDesc();
}
