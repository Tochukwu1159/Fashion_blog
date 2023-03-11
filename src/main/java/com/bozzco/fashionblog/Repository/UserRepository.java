package com.bozzco.fashionblog.Repository;

import com.bozzco.fashionblog.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {

}
