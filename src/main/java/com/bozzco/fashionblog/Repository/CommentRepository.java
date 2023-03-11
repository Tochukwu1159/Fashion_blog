package com.bozzco.fashionblog.Repository;

import com.bozzco.fashionblog.Model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comments,Integer> {
}
