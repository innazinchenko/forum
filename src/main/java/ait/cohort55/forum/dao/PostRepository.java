package ait.cohort55.forum.dao;

import ait.cohort55.forum.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public interface PostRepository extends CrudRepository<Post, Integer> {

    Stream<Post> findAllPostsByAuthor(String user);

    Stream<Post> findByPeriod(LocalDateTime from, LocalDateTime to);

    Stream<Post> findByTags(List<String> tags);

}
