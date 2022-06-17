package com.example.post_stringboot.service;

import com.example.post_stringboot.model.Post;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(int id);

    Post save(T t);

    void remove(int id);

    Iterable<Post> findAllByTitleContaining(String name);

    Iterable<Post> findAllByOrderByLikes();

    @Query(value = "select * from post order by id desc LIMIT 4", nativeQuery = true)
    Iterable<Post> getTop4New();
    @Query(value = "select * from post where likes > 6",nativeQuery = true)
    Iterable<Post> getLikes();
}
