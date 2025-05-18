package ait.cohort55.forum.dto;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Getter

public class AddCommentResponseDto {
    private String id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime dateCreated;
    private List<String> tags;
    private Integer likes;
    private Map<String, String> comments;


}
