package pl.codeslab.app.startup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.codeslab.app.domain.dao.AuthorDao;
import pl.codeslab.app.domain.model.Author;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Transactional
@Slf4j
public class AuthorLoader implements Loader{

    private final AuthorDao authorDao;

    public AuthorLoader(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Integer getPriority() {
        return 1;
    }

    @Override
    public String getEntityName() {
        return Author.class.getSimpleName();
    }

    @Override
    public Set<Long> createEntities() {
        authorDao.save(new Author(null, "Henryk", "Sienkiewicz"));
        authorDao.save(new Author(null, "Tomasz", "Lis"));
        authorDao.save(new Author(null, "Adam", "Kowalski"));

        List<Author> authors = authorDao.findAll();
        log.debug("Created authors count: {}", authors.size());
        return authors.stream().map(Author::getId).collect(Collectors.toSet());
    }
}
