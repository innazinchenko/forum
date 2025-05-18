package ait.cohort55.forum.service;

import ait.cohort55.forum.dao.PostRepository;
import ait.cohort55.forum.dto.*;
import ait.cohort55.forum.model.Comment;
import ait.cohort55.forum.model.Post;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class ForumServiceImpl implements ForumService {

    private  PostRepository postRepository;


    @Override
    public PostDto addPost(String user, PostAddDto postAddDto) {
        Post post = new Post();

        post.setAuthor(user);
        post.setTitle(postAddDto.getTitle());
        post.setContent(postAddDto.getContent());
        post.setTags(postAddDto.getTags());
        post.setLikes(0);
        post.setComments(new ArrayList<>());
        post.setDateCreated(LocalDateTime.now());

        postRepository.save(post);
        return post.inDto();

    }

    @Override
    public PostDto findPostById(String postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post with this ID not found"));
        return post.inDto();
    }

    @Override
    public void addLike(String postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post with this ID not found"));
        post.addLike();
        postRepository.save(post);
    }

    @Override
    public List<PostDto> findAllPostsByAuthor(String user) {
        return postRepository.findAllPostsByAuthor(user)
                .map(Post::inDto)
                .toList();
    }

    @Override
    public AddCommentResponseDto addComment(String postId, String commenter, AddCommentRequestDto addCommentRequestDto) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post with this id not found"));

        post.addComment(commenter, addCommentRequestDto.getContent());
        postRepository.save(post);
        return post.inDto();
    }

    @Override
    public PostDto deletePost(String postId) {

        Post post = postRepository.findById(postId);
        postRepository.delete(post);
        return post.inDto();
    }

    @Override
    public DeletePostDto deletePostError(String postId) {
        !postRepository.existsById(postId)
        return new DeletePostDto(//Text:"Post not found");
    }

    @Override
    public List<AddCommentResponseDto> findPostsByTags(Set<String> tags) {

        return postRepository.findByTags()
                .map(Post::inDto)
                .toList();
    }

    @Override
    public List<AddCommentResponseDto> findPostsByPeriod(LocalDateTime from, LocalDateTime to) {

        return postRepository.findByPeriod(from, to)
                .map(Post::inDto)
                .toList();
    }

    @Override
    public PostDto updatePost(String postId, PostAddDto postAddDto) {
        return null;
    }
}
