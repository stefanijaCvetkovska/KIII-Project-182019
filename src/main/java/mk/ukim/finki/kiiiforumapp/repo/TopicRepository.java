package mk.ukim.finki.kiiiforumapp.repo;

import mk.ukim.finki.kiiiforumapp.model.Category;
import mk.ukim.finki.kiiiforumapp.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findAllByCategory(Category category);
}
