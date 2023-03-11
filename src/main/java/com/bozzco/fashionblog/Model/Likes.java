package com.bozzco.fashionblog.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer like_id;

    private boolean liked;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private Users users;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "post_id",referencedColumnName = "post_id")
    private Post post;

    public Likes(Users users, Post post) {
        this.users = users;
        this.post = post;
    }
}
