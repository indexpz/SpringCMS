package pl.coderslab.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;


    public void saveCategory(Category category) {
        entityManager.persist(category);
    }


    public Category findById(long id) {
        return entityManager.find(Category.class, id);
    }

    public void update(Category category) {
        entityManager.merge(category);
    }

    public void delete(Category category) {
        entityManager.remove((entityManager.contains(category) ? category : entityManager.merge(category)));
    }
}
