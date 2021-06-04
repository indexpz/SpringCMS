package pl.codeslab.app.web.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.codeslab.app.domain.dao.ArticleDao;
import pl.codeslab.app.domain.dao.AuthorDao;
import pl.codeslab.app.domain.dao.CategoryDao;
import pl.codeslab.app.domain.model.Article;
import pl.codeslab.app.domain.model.Author;
import pl.codeslab.app.domain.model.Category;

import java.util.List;

@Controller
@RequestMapping("/forms/article")
@Slf4j
public class ArticleFormController {
    
    private final ArticleDao articleDao;
    private final CategoryDao categoryDao;
    private final AuthorDao authorDao;

    public ArticleFormController(ArticleDao articleDao, CategoryDao categoryDao, AuthorDao authorDao) {
        this.articleDao = articleDao;
        this.categoryDao = categoryDao;
        this.authorDao = authorDao;
    }

    @ModelAttribute("allCategories")
    public List<Category> categories() {
        return categoryDao.findAll();
    }

    @ModelAttribute("allAuthors")
    public List<Author> authors() {
        return authorDao.findAll();
    }

    @GetMapping("/list")
    public String prepareList(Model model) {
        model.addAttribute("articles", articleDao.findAll());
        return "articles/list";
    }

    @GetMapping("/create")
    public String prepareCreate(Model model){
        model.addAttribute("article", new Article());
        return "articles/create-form";
    }

    @PostMapping("/create")
    public String processCreate(Article article){
        log.debug("Kategoria przed zapisem " + article);
        articleDao.save(article);
        log.debug("Kategoria po zapisie " + article);
        return "redirect:/forms/article/list";
    }

    @GetMapping("/edit")
    public String prepareEdit(Long id,Model model){
        model.addAttribute("article", articleDao.findById(id));
        return "articles/edit-form";
    }

    @PostMapping("/edit")
    public String procesEdit(Article article){
        articleDao.update(article);
        return "redirect:/forms/article/list";
    }

    @GetMapping("/delete")
    public String prepareDelete(Long id, Model model){
        model.addAttribute("article", articleDao.findById(id));
        return "articles/confirm-delete";
    }

    @PostMapping("/delete")
    public String processDelete(Long id){
        Article article = articleDao.findById(id);
        articleDao.remove(article);
        return "redirect:/forms/article/list";
    }
    
}
