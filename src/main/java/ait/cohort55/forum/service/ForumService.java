package ait.cohort55.forum.service;

import ait.cohort55.forum.dto.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface ForumService {
PostDto addPost(String user,PostAddDto postAddDto);
PostDto findPostById(String postId);
void addLike(String postId);
List<PostDto> findAllPostsByAuthor(String user);
AddCommentResponseDto addComment(String postId, String commenter, AddCommentRequestDto addCommentRequestDto);
PostDto deletePost(String postId);
DeletePostDto deletePostError(String postId);
List<AddCommentResponseDto> findPostsByTags(Set<String> tags);
List<AddCommentResponseDto> findPostsByPeriod(LocalDateTime from, LocalDateTime to);
PostDto updatePost(String postId, PostAddDto postAddDto);
}
