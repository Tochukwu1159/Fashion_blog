package com.bozzco.fashionblog.Service;

import com.bozzco.fashionblog.DTO.LikeDTO;

public interface LikeService {
    Object likePost(LikeDTO likeDTO);
    void unlikePost(Integer id);
}
