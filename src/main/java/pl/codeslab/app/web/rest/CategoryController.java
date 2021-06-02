package pl.codeslab.app.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.codeslab.app.domain.dao.CategoryDao;
import pl.codeslab.app.domain.model.Article;
import pl.codeslab.app.domain.model.Author;
import pl.codeslab.app.domain.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryController {
    
    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/add")
    public String add() {

        Category modelObject = new Category(null, "sport", "description");
        categoryDao.save(modelObject);
        return "Zapisano pod id = " + modelObject.getId();
    }

    @GetMapping("/edit")
    public String edit() {
        Category modelObject = categoryDao.findById(1L);
        modelObject.setName("odpoczynek");
        return categoryDao.update(modelObject).toString();
    }

    @GetMapping("/delete")
    public String delete() {
        Category modelObject = categoryDao.findById(1L);
        categoryDao.remove(modelObject);
        return "Usunięto o id = " + modelObject.getId();
    }

    @GetMapping("/get")
    public String get() {
        Category modelObject = categoryDao.findById(1L);
        return modelObject.toString();
    }

    @GetMapping("/all")
    private String all(){
        return categoryDao.findAll().stream()
                .map(Category::toString)
                .collect(Collectors.joining());
    }
}
