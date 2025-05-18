package ait.cohort55.forum.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private String postId;
    private String title;
    private String content;
    private String author;
    private LocalDateTime dateCreated;
    private List<String> tags;
    private Integer likes;
    private List<String> comments;
}
