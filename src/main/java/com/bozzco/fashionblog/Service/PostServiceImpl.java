package com.bozzco.fashionblog.Service;

import com.bozzco.fashionblog.DTO.PostDto;
import com.bozzco.fashionblog.Model.Post;

import com.bozzco.fashionblog.Model.Users;
import com.bozzco.fashionblog.Repository.PostRepository;
import com.bozzco.fashionblog.Repository.UserRepository;
import com.bozzco.fashionblog.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final UserRepository userRepo;
    private PostRepository postRepo;

    public PostServiceImpl(UserRepository userRepo, PostRepository postRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
    }

    public Post createPost(PostDto postDto){
        Users users = userRepo.findById(postDto.getUser_id()).orElseThrow(() -> new ResourceNotFoundException("User", "id", postDto.getUser_id()));
        Post post = new Post();
        post.setPost_content(postDto.getPost_content());
        post.setImage_links(postDto.getImage_links());
        post.setTitle(postDto.getTitle());
        post.setUsers(users);
        return postRepo.save(post);
    }

    @Override
    public Post findPostById(int id) {
//        Optional<Post> post = postRepo.findById(id);
//        if(post.isPresent()){
//            return post.get();
//        }
//        else {
//            throw new ResourceNotFoundException("Post","post_id",id);
//        }
        // Alternative method using lambda expression
        return postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post","post_id",id));
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    @Override
    public Post updatePost(PostDto postDto, int id) {
        Post expectedPost= postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        Users users = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        expectedPost.setPost_content(postDto.getPost_content());
        expectedPost.setTitle(postDto.getTitle());
        expectedPost.setImage_links(postDto.getImage_links());
        expectedPost.setUsers(users);

        return postRepo.save(expectedPost);

    }

    @Override
    public void deletePost(int id) {
        Post expectedPost= postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepo.delete(expectedPost);
    }


}
