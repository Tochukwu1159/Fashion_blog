package com.bozzco.fashionblog.Service;

import com.bozzco.fashionblog.DTO.PostDto;
import com.bozzco.fashionblog.Model.Post;

import java.util.List;

public interface PostService {
    public Post createPost(PostDto postDto);
    Post findPostById(int id);

    List<Post> getAllPosts();

    Post updatePost(PostDto postDto, int id);
    void deletePost(int id);
}
