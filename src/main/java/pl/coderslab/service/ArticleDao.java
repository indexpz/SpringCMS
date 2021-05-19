package pl.coderslab.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;


    public void save(Article article) {
        entityManager.persist(article);
    }


    public Article findById(long id) {
        return entityManager.find(Article.class, id);
    }


    public void update(Article article) {
        entityManager.merge( article);
    }


    public void delete(Article article) {
        entityManager.remove((entityManager.contains( article) ? article : entityManager.merge(article)));
    }
}
