package com.bozzco.fashionblog.Controller;

import com.bozzco.fashionblog.DTO.CommentsDTO;
import com.bozzco.fashionblog.DTO.LikeDTO;
import com.bozzco.fashionblog.Model.Comments;
import com.bozzco.fashionblog.Model.Likes;
import com.bozzco.fashionblog.Service.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LikesController {
    private LikeService likeService;

    public LikesController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/user/like")
    public ResponseEntity<Likes> createPost(@RequestBody LikeDTO likeDTO){
        return new ResponseEntity<Likes>(likeService.likePost(likeDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/user/unlike/{id}")
    public ResponseEntity<String> deletePost(@PathVariable int id){
        likeService.unlikePost(id);
        return new ResponseEntity<String>("Unliked Successfully", HttpStatus.OK);
    }
}
