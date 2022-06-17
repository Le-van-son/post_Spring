package com.example.post_stringboot.repository;

import com.example.post_stringboot.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    Iterable<Post> findAllByTitleContaining(String name);

    Iterable<Post> findAllByOrderByLikes();

    @Query(value = "select * from post order by id desc LIMIT 4", nativeQuery = true)
    Iterable<Post> getTop4New();
    @Query(value = "select * from post where likes > 6",nativeQuery = true)
    Iterable<Post> getLikes();
}
