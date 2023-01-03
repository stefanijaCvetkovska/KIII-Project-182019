package mk.ukim.finki.kiiiforumapp.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.kiiiforumapp.model.Category;
import mk.ukim.finki.kiiiforumapp.model.Topic;
import mk.ukim.finki.kiiiforumapp.service.CategoryService;
import mk.ukim.finki.kiiiforumapp.service.TopicService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class HomeController {
    private final TopicService topicService;
    private final CategoryService categoryService;

    @GetMapping
    public String getHomePage(@RequestParam(required = false) String error,
                              @RequestParam(required = false) Long categoryId,
                              Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Topic> threads;

        if (categoryId != null) {
            threads = this.topicService.findAllByCategory(categoryId);
        } else {
            threads = this.topicService.findAll();
        }
        List<Category> categories = this.categoryService.findAll();
        model.addAttribute("threads", threads);
        model.addAttribute("categories", categories);
        model.addAttribute("bodyContent", "forum-page");
        return "master-template";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        this.topicService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String create(@RequestParam String title,
                         @RequestParam String text,
                         @RequestParam Long category) {
        this.topicService.create(title, text, category);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getEventsEditPage(@PathVariable Long id, Model model) {
        Topic event = this.topicService.findById(id);
        List<Category> categories = this.categoryService.findAll();
        model.addAttribute("topic", event);
        model.addAttribute("categories", categories);
        model.addAttribute("bodyContent", "forum-page");
        return "master-template";
    }

    @PostMapping("/add/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam String title,
                         @RequestParam String text,
                         @RequestParam Long category) {
        this.topicService.update(id, title, text, category);
        return "redirect:/";
    }

}
