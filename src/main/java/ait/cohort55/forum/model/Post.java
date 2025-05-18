package ait.cohort55.forum.model;

import ait.cohort55.forum.dto.PostDto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Document(collection = "posts")
public class Post {
    @Id
    private String postId;
    private String title;
    private String content;
    private String author;
    private LocalDateTime dateCreated;
    private List<String> tags;
    private Integer likes;
    private List<Comment> comments;

    public Post(String postId, String title, String content, String author, LocalDateTime dateCreated, List<String> tags) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.author = author;
        this.dateCreated = LocalDateTime.now();
        this.tags = tags;
        this.likes = 0;
        this.comments = new ArrayList<>();
    }

    public Comment addComment(String user, String message) {
        Comment comment = new Comment(user, message, dateCreated, likes);
        comments.add(comment);
        return comment;
    }

    public void addLike() {
        this.likes++;
    }


    public PostDto inDto() {
        return new PostDto(
                this.postId,
                this.title,
                this.content,
                this.author,
                this.dateCreated,
                this.tags,
                this.likes,
                this.comments);
    }
}
