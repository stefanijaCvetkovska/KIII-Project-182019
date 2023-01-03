package mk.ukim.finki.kiiiforumapp.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.kiiiforumapp.model.Category;
import mk.ukim.finki.kiiiforumapp.repo.CategoryRepository;
import mk.ukim.finki.kiiiforumapp.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }
}
