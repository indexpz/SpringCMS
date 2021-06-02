package pl.codeslab.app.startup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.codeslab.app.domain.dao.ArticleDao;
import pl.codeslab.app.domain.dao.AuthorDao;
import pl.codeslab.app.domain.dao.CategoryDao;
import pl.codeslab.app.domain.model.Article;
import pl.codeslab.app.domain.model.Author;
import pl.codeslab.app.domain.model.Category;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Transactional
@Slf4j
public class ArticleLoader implements Loader{

    private final ArticleDao articleDao;
    private final CategoryDao categoryDao;
    private final AuthorDao authorDao;

    public ArticleLoader(ArticleDao articleDao, CategoryDao categoryDao, AuthorDao authorDao) {
        this.articleDao = articleDao;
        this.categoryDao = categoryDao;
        this.authorDao = authorDao;
    }

    @Override
    public Integer getPriority() {
        return 2;
    }

    @Override
    public String getEntityName() {
        return Article.class.getSimpleName();
    }

    @Override
    public Set<Long> createEntities() {
        for (int i = 0; i < 3; i++) {
            Author randomAuthor = randomAuthor();
            Set<Category> randomCategories = randomCategories();
            Article article = new Article(null, "Title " + i, "Content " + i, null, null, randomAuthor, randomCategories);
            articleDao.save(article);
        }

        List<Article> articles = articleDao.findAll();
        log.debug("Created articles count: {}", articles.size());
        return articles.stream()
                .map(Article::getId)
                .collect(Collectors.toSet());
    }

    private Set<Category> randomCategories() {
        List<Category> categories = categoryDao.findAll();
        int count = (int) (Math.random() * categories.size()) + 1;
        Collections.shuffle(categories);
        return categories.stream()
                .limit(count)
                .collect(Collectors.toSet());

    }

    private Author randomAuthor() {
        List<Author> authors = authorDao.findAll();
        int index = (int) (Math.random() * authors.size());
        return authors.get(index);
    }
}
