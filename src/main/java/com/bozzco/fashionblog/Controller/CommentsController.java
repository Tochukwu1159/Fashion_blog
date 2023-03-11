package com.bozzco.fashionblog.Controller;

import com.bozzco.fashionblog.DTO.CommentsDTO;
import com.bozzco.fashionblog.DTO.LikeDTO;
import com.bozzco.fashionblog.DTO.PostDto;
import com.bozzco.fashionblog.Model.Comments;
import com.bozzco.fashionblog.Model.Post;
import com.bozzco.fashionblog.Service.CommentsService;
import com.bozzco.fashionblog.Service.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.util.List;

@RequestMapping("/user/comments")
@RestController
public class CommentsController {
    private final CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping("")
    public ResponseEntity<Comments> createPost(@RequestBody CommentsDTO commentsDTO){
        return new ResponseEntity<Comments>(commentsService.createComments(commentsDTO), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Comments> findPostById(@PathVariable int id){
        return  new ResponseEntity<Comments>(commentsService.findCommentsById(id), HttpStatus.OK);
    }

    @GetMapping("/all_comments")
    public List<Comments> getAllPosts(){
        return commentsService.getAllComments();
    }

    @PutMapping("/update_comment/{id}")
    public ResponseEntity<Comments> updatePost(@PathVariable int id, @RequestBody CommentsDTO commentsDTO){
        return  new ResponseEntity<Comments>(commentsService.updateComment(commentsDTO,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete_comment/{id}")
    public ResponseEntity<String> deletePost(@PathVariable int id){
        commentsService.deleteComment(id);
        return new ResponseEntity<String>("User Comment Deleted Successfully", HttpStatus.OK);
    }
}
