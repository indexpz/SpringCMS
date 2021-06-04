package pl.codeslab.app.domain.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.codeslab.app.domain.model.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
    protected EntityManager em;

    public void save(Article entity) {
        em.persist(entity);
    }

    public Article update(Article entity) {
        return em.merge(entity);
    }

    public Article findById(Long id) {
        return em.find(Article.class, id);
    }

    public void remove(Article entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public List<Article> findAll() {
        return em.createQuery("select a from Article a", Article.class).getResultList();
    }

    public List<Article> findQuantityArticlesByDateDesc(long quantity){
       List<Article> articles = em.createQuery("select a from Article a order by a.created DESC", Article.class).getResultList();
        return articles.stream()
                .limit(quantity)
                .collect(Collectors.toList());
    }
}
