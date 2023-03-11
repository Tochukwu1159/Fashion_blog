package com.bozzco.fashionblog.DTO;

import com.bozzco.fashionblog.Model.Post;
import com.bozzco.fashionblog.Model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeDTO {
    private boolean liked;
    private Integer post_id;
    private Integer user_id;

}
