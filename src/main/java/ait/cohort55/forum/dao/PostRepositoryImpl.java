package ait.cohort55.forum.dao;

import ait.cohort55.forum.model.Post;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class PostRepositoryImpl implements PostRepository {

    private Map<String, Post> posts = new ConcurrentHashMap<>();

    @Override
    public Post save(Post post) {
        posts.put(post.getPostId(), post);
        return post;
    }

    @Override
    public Optional<Post> findById(String postId) {
        return Optional.ofNullable(posts.get(postId));
    }

    @Override
    public Optional<Post> findByAuthor(String author) {
        return Optional.ofNullable(posts.get(author));
    }

    @Override
    public Optional<Post> findByTags(List<String> tags) {
        return Optional.ofNullable(posts.get(tags.get(0)));
    }

    @Override
    public Optional<Post> findByPeriod(LocalDateTime from, LocalDateTime to) {
        return Optional.ofNullable(posts.get(from));
    }

    @Override
  public void deletePostById(String postId) {
//posts.remove(postId);
    }
}
