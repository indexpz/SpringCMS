package pl.codeslab.app.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.codeslab.app.domain.dao.CategoryDao;
import pl.codeslab.app.domain.model.Category;

public class CategoryConverter implements Converter<String, Category> {

    private CategoryDao categoryDao;

    @Autowired
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category convert(String s) {
        return categoryDao.findById(Long.parseLong(s));
    }
}
