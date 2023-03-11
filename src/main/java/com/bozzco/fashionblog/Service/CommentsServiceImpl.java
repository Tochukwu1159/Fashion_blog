package com.bozzco.fashionblog.Service;

import com.bozzco.fashionblog.DTO.CommentsDTO;
import com.bozzco.fashionblog.Model.Comments;
import com.bozzco.fashionblog.Model.Post;
import com.bozzco.fashionblog.Model.Users;
import com.bozzco.fashionblog.Repository.CommentRepository;
import com.bozzco.fashionblog.Repository.PostRepository;
import com.bozzco.fashionblog.Repository.UserRepository;
import com.bozzco.fashionblog.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentsServiceImpl implements  CommentsService{

    private CommentRepository commentRepo;
    private UserRepository userRepo;
    private PostRepository postRepo;

    public CommentsServiceImpl(CommentRepository commentRepo, UserRepository userRepo,PostRepository postRepo) {
        this.commentRepo = commentRepo;
        this.userRepo = userRepo;
        this.postRepo= postRepo;
    }

    @Override
    public Comments createComments(CommentsDTO commentsDTO) {
        Users users = userRepo.findById(commentsDTO.getUser_id()).orElseThrow(() -> new ResourceNotFoundException("User", "id", commentsDTO.getUser_id()));
        Post post = postRepo.findById(commentsDTO.getUser_id()).orElseThrow(() -> new ResourceNotFoundException("Post", "id", commentsDTO.getUser_id()));
        Comments comments = new Comments();
        comments.setComment_content(commentsDTO.getComment_content());
        comments.setUsers(users);
        comments.setPost(post);
        return commentRepo.save(comments);
    }

    @Override
    public Comments findCommentsById(int id) {
        return commentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comments", "id", id));

    }

    @Override
    public List<Comments> getAllComments() {
        return commentRepo.findAll();
    }

    @Override
    public Comments updateComment(CommentsDTO commentsDTO, int id) {
        Comments comments = commentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comments", "id", id));
        Users users = userRepo.findById(commentsDTO.getUser_id()).orElseThrow(() -> new ResourceNotFoundException("User", "id", commentsDTO.getUser_id()));
        Post post = postRepo.findById(commentsDTO.getUser_id()).orElseThrow(() -> new ResourceNotFoundException("Post", "id", commentsDTO.getUser_id()));
        comments.setComment_content(commentsDTO.getComment_content());
        comments.setPost(post);
        comments.setUsers(users);
        return commentRepo.save(comments);
    }

    @Override
    public void deleteComment(int id) {
        Comments comments = commentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comments", "id", id));
        commentRepo.delete(comments);
    }
}
