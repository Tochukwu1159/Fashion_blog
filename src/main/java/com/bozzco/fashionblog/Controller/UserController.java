package com.bozzco.fashionblog.Controller;


import com.bozzco.fashionblog.DTO.UserDTO;
import com.bozzco.fashionblog.Model.Post;
import com.bozzco.fashionblog.Model.Users;
import com.bozzco.fashionblog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private  UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Users> registerUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<Users>(userService.registerUser(userDTO), HttpStatus.CREATED);
    }

    @GetMapping("/find_user/{id}")
    public ResponseEntity<Users> findUserById(@PathVariable int id){
        return new ResponseEntity<Users>(userService.findUserById(id),HttpStatus.OK);
    }

    @GetMapping("/all_users/")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/update_user/{id}")
    public ResponseEntity<Users> updateUserDetails(@RequestBody UserDTO userDTO, @PathVariable int id){
        return new ResponseEntity<Users>(userService.updateUserDetails(userDTO,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete_user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return new ResponseEntity<String>("User Deleted Successfully",HttpStatus.OK);
    }
}
