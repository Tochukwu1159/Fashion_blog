package com.bozzco.fashionblog.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String first_name;
    private String last_name;
    private String email;
    private String password;

}
