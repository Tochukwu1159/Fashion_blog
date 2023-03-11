package com.bozzco.fashionblog.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private String post_content;
    private String title;
    private String image_links;
    private int user_id;
}
