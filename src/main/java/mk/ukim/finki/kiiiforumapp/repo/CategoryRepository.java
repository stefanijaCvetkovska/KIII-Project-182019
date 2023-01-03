package mk.ukim.finki.kiiiforumapp.repo;

import mk.ukim.finki.kiiiforumapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
