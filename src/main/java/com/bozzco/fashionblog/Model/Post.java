package com.bozzco.fashionblog.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String post_content;

    @Column(nullable = false)
    private String image_links;

    @CreationTimestamp
    private @NotNull LocalDateTime creationTime;

    @UpdateTimestamp
    private @NotNull LocalDateTime updateTime;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "users_id",referencedColumnName = "user_id")
    private Users users;


}
