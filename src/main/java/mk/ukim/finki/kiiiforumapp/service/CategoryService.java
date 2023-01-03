package mk.ukim.finki.kiiiforumapp.service;

import mk.ukim.finki.kiiiforumapp.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
}
