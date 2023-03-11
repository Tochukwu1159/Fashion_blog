package com.bozzco.fashionblog.Controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.bozzco.fashionblog.DTO.UserDTO;
import com.bozzco.fashionblog.Model.Users;
import com.bozzco.fashionblog.Repository.UserRepository;
import com.bozzco.fashionblog.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)

class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;
    Users users= new Users(1,"Tom","Jerry","tom&jerry@ymail.com","123");
    Users  usertoDelete= new Users(2,"Tom","Jerry","tom&jerry@ymail.com","123");
    @Test
    void registerUser() throws Exception {

        mockMvc.perform(post("/api/user/register").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(users)))
                .andExpect(status().isCreated())
                .andDo(print())
        ;

    }

    @Test
    void findUserById() throws Exception {
        Integer id = 1;
        Users user2= new Users();
        user2.setFirst_name("John");
        user2.setLast_name("baba");
        user2.setEmail("baba@2.com");
        user2.setPassword("123");
        user2.setUser_id(id);
        // mock the data return by service class
        when(userService.findUserById(anyInt())).thenReturn(user2);


        // create a mock http request to verify the result
         mockMvc.perform(MockMvcRequestBuilders.get("/api/user/find_user/1"))
                 .andDo(print())
                 .andExpect(MockMvcResultMatchers.jsonPath("$.last_name").value("baba"))
                 .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("baba@2.com"))
                 .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("123"))
                 .andExpect(MockMvcResultMatchers.jsonPath("$.first_name").value("John")
        );



    }

    @Test
    void getAllUsers() throws Exception {
        List<Users> usersList = new ArrayList<>(
                Arrays.asList(
                        new Users(1,"Tom","Jerry","tom&jerry@ymail.com","123"),
                        new Users(2,"Tommy","Jay","jay@ymail.com","123"),
                        new Users(3,"Tomiwa","Jesos","jeso@ymail.com","123")
                ));
        System.out.println(usersList.size());
        when(userService.getAllUsers()).thenReturn(usersList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/all_users/"))

                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(usersList.size()))
                .andDo(print());
    }

    @Test
    void updateUserDetails() throws Exception {
        int id  =1;
        Users user2= new Users(id,"John","baba","baba@2.com","123");

        UserDTO updatedUser = new UserDTO();
        updatedUser.setFirst_name("John");
        updatedUser.setLast_name("Ibrahim");
        updatedUser.setEmail("baba@gmail.com");
        updatedUser.setPassword("123");

        when(userService.findUserById(id)).thenReturn(user2);
        when(userService.updateUserDetails(any(UserDTO.class),id)).thenReturn(user2);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/user/update_user/id")
                .content(objectMapper.writeValueAsString(updatedUser)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.first_name").value(updatedUser.getFirst_name()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.last_name").value(updatedUser.getLast_name()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(updatedUser.getEmail()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.last_name").value(updatedUser.getPassword())

        );





    }

    @Test
    void deleteUser() throws Exception {
//        Users user2= new Users(1,"John","baba","baba@2.com","123");
        doNothing().when(userService).deleteUser(1);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/user/delete_user/1",1))
                .andExpect(status().isOk())
                .andDo(print());


    }
}