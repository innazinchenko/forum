package ait.cohort55.forum.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
public class Post {
    private String postId;
    @Setter
    private String title;
    @Setter
    private String content;
    @Setter
    private String author;
    @Setter
    private LocalDateTime dateCreated;
    @Setter
    private List<String> tags;
    @Setter
    private Integer likes;
    private List<Comment> comments;

    public Post(String postId, String title, String content, String author, LocalDateTime dateCreated, List<String> tags) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.author = author;
        this.dateCreated = dateCreated;
        this.tags = tags;
        this.likes = 0;
        this.comments = new ArrayList<>();
    }

    public Comment addComment(String user, String message) {
        Comment comment = new Comment(user, message, dateCreated, likes);
        comments.add(comment);
        return comment;
    }
}
