package com.bozzco.fashionblog.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDTO {
    private String comment_content;
    private Integer post_id;
    private Integer user_id;
}
