package com.bozzco.fashionblog.Repository;

import com.bozzco.fashionblog.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
