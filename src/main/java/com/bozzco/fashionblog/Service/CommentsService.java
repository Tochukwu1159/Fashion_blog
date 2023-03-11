package com.bozzco.fashionblog.Service;

import com.bozzco.fashionblog.DTO.CommentsDTO;
import com.bozzco.fashionblog.DTO.PostDto;
import com.bozzco.fashionblog.Model.Comments;
import com.bozzco.fashionblog.Model.Post;

import java.util.List;

public interface CommentsService {
    public Comments createComments(CommentsDTO commentsDTO);
    Comments findCommentsById(int id);

    List<Comments> getAllComments();

    Comments updateComment(CommentsDTO commentsDTO, int id);
    void deleteComment(int id);
}
