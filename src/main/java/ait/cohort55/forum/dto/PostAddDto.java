package ait.cohort55.forum.dto;

import lombok.Getter;
import java.util.List;


@Getter
public class PostAddDto {
    private String title;
    private String content;
    private List<String> tags;

}
