package ait.cohort55.forum.dao;

import ait.cohort55.forum.model.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save(Post post);
    Optional<Post> findById(String postId);
    Optional<Post> findByAuthor(String author);
    Optional<Post> findByTags(List<String> tags);
    Optional<Post> findByPeriod(LocalDateTime from, LocalDateTime to);
    void deletePostById(String postId);

}
