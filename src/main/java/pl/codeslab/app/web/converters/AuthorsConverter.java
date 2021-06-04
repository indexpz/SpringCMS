package pl.codeslab.app.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.codeslab.app.domain.dao.AuthorDao;
import pl.codeslab.app.domain.model.Author;

public class AuthorsConverter implements Converter<String, Author> {

    private AuthorDao authorDao;

    @Autowired
    public void setAuthorDao(AuthorDao authorDao){
        this.authorDao = authorDao;
    }

    @Override
    public Author convert(String s) {
        return authorDao.findById(Long.parseLong(s));
    }
}
