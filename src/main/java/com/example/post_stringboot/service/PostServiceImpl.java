package com.example.post_stringboot.service;

import com.example.post_stringboot.model.Post;
import com.example.post_stringboot.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements IGeneralService<Post>{
    @Autowired
    PostRepository postRepository;
    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void remove(int id) {
    postRepository.deleteById(id);
    }

    @Override
    public Iterable<Post> findAllByTitleContaining(String name) {
        return postRepository.findAllByTitleContaining(name);
    }

    @Override
    public Iterable<Post> findAllByOrderByLikes() {
        return postRepository.findAllByOrderByLikes();
    }


    @Override
    public Iterable<Post> getTop4New() {
        return postRepository.getTop4New();
    }

    @Override
    public Iterable<Post> getLikes() {
        return postRepository.getLikes();
    }
}
