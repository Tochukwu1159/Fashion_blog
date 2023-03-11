package com.bozzco.fashionblog.Controller;

import com.bozzco.fashionblog.DTO.PostDto;
import com.bozzco.fashionblog.Model.Post;

import com.bozzco.fashionblog.Service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        super();
        this.postService = postService;
    }

    @PostMapping("")
    public ResponseEntity<Post> createPost(@RequestBody PostDto postDto){
        return new ResponseEntity<Post>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Post> findPostById(@PathVariable int id){
        return  new ResponseEntity<Post>(postService.findPostById(id), HttpStatus.OK);
    }

    @GetMapping("/all_post")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @PutMapping("/update_post/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestBody PostDto post){
        return  new ResponseEntity<Post>(postService.updatePost(post,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete_post/{id}")
    public ResponseEntity<String> deletePost(@PathVariable int id){
        postService.deletePost(id);
        return new ResponseEntity<String>("Post Deleted Successfully", HttpStatus.OK);
    }
}
