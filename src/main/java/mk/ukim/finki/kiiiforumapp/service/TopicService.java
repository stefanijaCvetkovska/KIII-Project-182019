package mk.ukim.finki.kiiiforumapp.service;

import mk.ukim.finki.kiiiforumapp.model.Topic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TopicService {
    List<Topic> findAll();

    Topic findById(Long id);

    List<Topic> findAllByCategory(Long categoryId);

    Topic create(String title, String text, Long categoryId);

    Topic update(Long id, String title, String text, Long categoryId);

    Topic delete(Long id);
}
