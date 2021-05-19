package pl.coderslab.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AuthorDao  {

    @PersistenceContext
    EntityManager entityManager;


    public void save(Author author) {
        entityManager.persist(author);
    }


    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }

    public void update(Author author) {
        entityManager.merge(author);
    }

    public void delete(Author author) {
        entityManager.remove((entityManager.contains(author) ? author : entityManager.merge(author)));
    }
}
