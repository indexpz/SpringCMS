package pl.codeslab.app.startup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.codeslab.app.domain.dao.CategoryDao;
import pl.codeslab.app.domain.model.Category;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Transactional
@Slf4j
public class CategoryLoader implements Loader{

    private final CategoryDao categoryDao;

    public CategoryLoader(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Integer getPriority() {
        return 0;
    }

    @Override
    public String getEntityName() {
        return Category.class.getSimpleName();
    }

    @Override
    public Set<Long> createEntities() {
        categoryDao.save(new Category(null, "Polityka", "Artykuły o polityce"));
        categoryDao.save(new Category(null, "Sport", "Artykuły na tematy sportowe"));
        categoryDao.save(new Category(null, "Lifestyle", "Ogólne artykuly o życiu"));

        List<Category> categories = categoryDao.findAll();
        log.debug("Created categories count: {}", categories.size());
        return categories.stream().map(Category::getId).collect(Collectors.toSet());
    }
}
