package ait.cohort55.forum.controller;

import ait.cohort55.forum.dto.*;
import ait.cohort55.forum.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@RestController
public class ForumController {
    @Autowired
    private ForumService forumService;

    @PostMapping("/forum/post/{user}")
    public PostDto addPost(@PathVariable String user, @RequestBody PostAddDto postAddDto) {
        return forumService.addPost(user, postAddDto);
    }

    @GetMapping("/forum/post/{postId}")
    public PostDto findPostById(@PathVariable String postId) {
        return forumService.findPostById(postId);
    }

    @PatchMapping("/forum/post/{postId}/like")
    public void addLike(@PathVariable String postId) {

    }

    @GetMapping("/forum/posts/author/{user}")
    public List<PostDto> findAllPostsByAuthor(@PathVariable String user) {
        return forumService.findAllPostsByAuthor(user);
    }

    @PatchMapping("/forum/post/{postId}/comment/{commenter}")
    public AddCommentResponseDto addComment(@PathVariable String postId, @PathVariable String commenter, @RequestBody AddCommentRequestDto addCommentRequestDto) {
        return forumService.addComment(postId, commenter, addCommentRequestDto);
    }

    @DeleteMapping("/forum/post/{postId}")
    public PostDto deletePost(@PathVariable String postId) {
        return forumService.deletePost(postId);
    }

    @DeleteMapping("/forum/post/{postId}")
    public DeletePostDto deletePostError(@PathVariable String postId) {
        return forumService.deletePostError(postId);
    }

    @GetMapping("/forum/posts/tags")
    public List<AddCommentResponseDto> findPostsByTags(@RequestParam Set<String> tags) {
        return forumService.findPostsByTags(tags);
    }

    @GetMapping("/forum/posts/period")
    public List<AddCommentResponseDto> findPostsByPeriod(@RequestParam LocalDateTime from, @RequestParam LocalDateTime to) {
        return forumService.findPostsByPeriod(from, to);
    }


    @PatchMapping("/forum/post/{postId}")
    public PostDto updatePost(@PathVariable String postId, @RequestBody PostAddDto postAddDto) {
        return forumService.updatePost(postId, postAddDto);
    }
}
