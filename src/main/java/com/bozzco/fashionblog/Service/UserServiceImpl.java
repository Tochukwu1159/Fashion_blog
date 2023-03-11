package com.bozzco.fashionblog.Service;

import com.bozzco.fashionblog.DTO.UserDTO;
import com.bozzco.fashionblog.Model.Post;
import com.bozzco.fashionblog.Model.Users;
import com.bozzco.fashionblog.Repository.UserRepository;
import com.bozzco.fashionblog.exceptions.ResourceNotFoundException;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Users registerUser(UserDTO userDTO) {
        Users user = new Users();
        user.setEmail(userDTO.getEmail());
        user.setFirst_name(userDTO.getFirst_name());
        user.setLast_name(userDTO.getLast_name());
        user.setPassword(userDTO.getPassword());
        return userRepo.save(user);
    }

    @Override
    public Users findUserById(int id) {
        Users users = userRepo.findById(id).orElseThrow(() ->new ResourceNotFoundException("User","Id",id));

        return users;
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Users updateUserDetails(UserDTO userDTO,int id) {
        Users userToUpdate = userRepo.findById(id).orElseThrow(() ->new ResourceNotFoundException("User","Id",id));
        userToUpdate.setEmail(userDTO.getEmail());
        userToUpdate.setFirst_name(userDTO.getFirst_name());
        userToUpdate.setLast_name(userDTO.getLast_name());
        userToUpdate.setPassword(userDTO.getPassword());

        return userRepo.save(userToUpdate);
    }

    @Override
    public void deleteUser(int id) {
        Users userToDelete = userRepo.findById(id).orElseThrow(() ->new ResourceNotFoundException("User","Id",id));
        userRepo.delete(userToDelete);

    }
}
