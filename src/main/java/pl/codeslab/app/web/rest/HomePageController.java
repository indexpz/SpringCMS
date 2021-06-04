package pl.codeslab.app.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.codeslab.app.domain.dao.ArticleDao;
import pl.codeslab.app.domain.model.Article;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home")
public class HomePageController {

    private final ArticleDao articleDao;

    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping("/")
    public String prepareHome(){
        return articleDao.findQuantityArticlesByDateDesc(2).stream()
                .map(Article::toString)
                .collect(Collectors.joining());
    }
}
