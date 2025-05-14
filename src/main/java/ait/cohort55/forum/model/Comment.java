package ait.cohort55.forum.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Comment {
    private String user;
    private String message;
    private LocalDateTime dateCreated;
    private Integer likes;


    public Comment(String user, String message, LocalDateTime dateCreated, Integer likes) {
        this.user = user;
        this.message = message;
        this.dateCreated = LocalDateTime.now();
        this.likes = 0;
    }

    public void addLike(Integer like) {
        this.likes += like;
    }
}
