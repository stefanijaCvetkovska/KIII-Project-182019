package mk.ukim.finki.kiiiforumapp.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.kiiiforumapp.model.Category;
import mk.ukim.finki.kiiiforumapp.model.Topic;
import mk.ukim.finki.kiiiforumapp.model.exceptions.CategoryNotFoundException;
import mk.ukim.finki.kiiiforumapp.model.exceptions.TopicNotFoundException;
import mk.ukim.finki.kiiiforumapp.repo.CategoryRepository;
import mk.ukim.finki.kiiiforumapp.repo.TopicRepository;
import mk.ukim.finki.kiiiforumapp.service.TopicService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final CategoryRepository categoryRepository;
    private final TopicRepository topicRepository;

    @Override
    public List<Topic> findAll() {
        return this.topicRepository.findAll();
    }

    @Override
    public Topic findById(Long id) {
        Topic topic = this.topicRepository
                .findById(id)
                .orElseThrow(() -> new TopicNotFoundException());
        return topic;
    }

    @Override
    public List<Topic> findAllByCategory(Long categoryId) {
        Category category = this.categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException());
        return this.topicRepository.findAllByCategory(category);
    }

    @Override
    public Topic create(String title, String text, Long categoryId) {
        Category category = this.categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException());
        Topic topic = new Topic(title, text, category);
        return this.topicRepository.save(topic);
    }

    @Override
    public Topic update(Long id, String title, String text, Long categoryId) {
        Topic topic = this.topicRepository
                .findById(id)
                .orElseThrow(() -> new TopicNotFoundException());
        Category category = this.categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException());
        LocalDateTime edited = LocalDateTime.now();
        topic.setTitle(title);
        topic.setText(text);
        topic.setEdited(edited);
        topic.setCategory(category);
        return this.topicRepository.save(topic);
    }

    @Override
    public Topic delete(Long id) {
        Topic topic = this.topicRepository
                .findById(id)
                .orElseThrow(() -> new TopicNotFoundException());
        this.topicRepository.delete(topic);
        return topic;
    }
}
