package com.bozzco.fashionblog.Repository;

import com.bozzco.fashionblog.Model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes,Integer> {
}
