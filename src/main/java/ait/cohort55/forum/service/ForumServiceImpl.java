package ait.cohort55.forum.service;

import ait.cohort55.forum.dao.PostRepository;
import ait.cohort55.forum.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Component
public class ForumServiceImpl implements ForumService {

    @Autowired
    private PostRepository postRepository;


    @Override
    public PostDto addPost(String user, PostAddDto postAddDto) {
        return null;
    }

    @Override
    public PostDto findPostById(String postId) {
        return null;
    }

    @Override
    public void addLike(String postId) {

    }

    @Override
    public List<PostDto> findAllPostsByAuthor(String user) {
        return List.of();
    }

    @Override
    public AddCommentResponseDto addComment(String postId, String commenter, AddCommentRequestDto addCommentRequestDto) {
        return null;
    }

    @Override
    public PostDto deletePost(String postId) {
        return null;
    }

    @Override
    public DeletePostDto deletePostError(String postId) {
        return null;
    }

    @Override
    public List<AddCommentResponseDto> findPostsByTags(Set<String> tags) {
        return List.of();
    }

    @Override
    public List<AddCommentResponseDto> findPostsByPeriod(LocalDateTime from, LocalDateTime to) {
        return List.of();
    }

    @Override
    public PostDto updatePost(String postId, PostAddDto postAddDto) {
        return null;
    }
}
