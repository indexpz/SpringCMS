package pl.codeslab.app.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.codeslab.app.domain.dao.ArticleDao;
import pl.codeslab.app.domain.model.Article;
import pl.codeslab.app.domain.model.Category;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleDao articleDao;

    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping("/add")
    public String add() {
        Article modelObject = new Article(null, "Tytuł", "daasd", List.of(new Category()), LocalDateTime.now(), null);
        articleDao.save(modelObject);
        return "Zapisano pod id = " + modelObject.getId();
    }

    @GetMapping("/edit")
    public String edit() {
        Article modelObject = articleDao.findById(1L);
        modelObject.setTitle("Ala");
        modelObject.setUpdated(LocalDateTime.now());
        return articleDao.update(modelObject).toString();
    }

    @GetMapping("/delete")
    public String delete() {
        Article modelObject = articleDao.findById(1L);
        articleDao.remove(modelObject);
        return "Usunięto o id = " + modelObject.getId();
    }

    @GetMapping("/get")
    public String get() {
        Article modelObject = articleDao.findById(1L);
        return modelObject.toString();
    }

    @GetMapping("/all")
    private String all(){
        return articleDao.findAll().stream()
                .map(Article::toString)
                .collect(Collectors.joining());
    }
}
