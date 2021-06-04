package pl.codeslab.app.domain.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.codeslab.app.domain.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {
    @PersistenceContext
    protected EntityManager em;

    public void save(Category entity) {
        em.persist(entity);
    }

    public Category update(Category entity) {
        return em.merge(entity);
    }

    public Category findById(Long id) {
        return em.find(Category.class, id);
    }

    public void remove(Category entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public List<Category> findAll() {
        return em.createQuery("SELECT x from Category x", Category.class).getResultList();
    }


}
