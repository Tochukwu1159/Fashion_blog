package com.bozzco.fashionblog.Service;

import com.bozzco.fashionblog.DTO.PostDto;
import com.bozzco.fashionblog.DTO.UserDTO;
import com.bozzco.fashionblog.Model.Post;
import com.bozzco.fashionblog.Model.Users;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {
    public Users registerUser(UserDTO userDTO);
    Users findUserById(int id);

    List<Users> getAllUsers();

    Users updateUserDetails(UserDTO userDTO,int id);
    void deleteUser(int id);
}
