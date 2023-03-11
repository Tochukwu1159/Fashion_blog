package com.bozzco.fashionblog.Service;

import com.bozzco.fashionblog.DTO.LikeDTO;
import com.bozzco.fashionblog.Model.Comments;
import com.bozzco.fashionblog.Model.Likes;
import com.bozzco.fashionblog.Model.Post;
import com.bozzco.fashionblog.Model.Users;
import com.bozzco.fashionblog.Repository.CommentRepository;
import com.bozzco.fashionblog.Repository.LikesRepository;
import com.bozzco.fashionblog.Repository.PostRepository;
import com.bozzco.fashionblog.Repository.UserRepository;
import com.bozzco.fashionblog.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService{

    private LikesRepository likesRepo;
    private UserRepository userRepo;
    private PostRepository postRepo;

    public LikeServiceImpl(LikesRepository likesRepo, UserRepository userRepo, PostRepository postRepo) {
        this.likesRepo = likesRepo;
        this.userRepo = userRepo;
        this.postRepo = postRepo;
    }

    @Override
    public Likes likePost(LikeDTO likeDTO) {
        Users users = userRepo.findById(likeDTO.getUser_id()).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", likeDTO.getUser_id()));
        Post post = postRepo.findById(likeDTO.getUser_id()).orElseThrow(() ->
                new ResourceNotFoundException("Post", "id", likeDTO.getUser_id()));
        Likes likes = new Likes();

        likes.setLiked(likeDTO.isLiked());
        likes.setUsers(users);
        likes.setPost(post);

        return likesRepo.save(likes);
    }

    @Override
    public void unlikePost(Integer id) {
        Likes likes = likesRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        likesRepo.delete(likes);
    }
}
