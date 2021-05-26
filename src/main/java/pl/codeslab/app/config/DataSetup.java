package pl.codeslab.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.codeslab.app.domain.dao.ArticleDao;
import pl.codeslab.app.domain.dao.AuthorDao;
import pl.codeslab.app.domain.dao.CategoryDao;
import java.util.concurrent.atomic.AtomicBoolean;


@Component
public class DataSetup {

    private static final Logger logger = LoggerFactory.getLogger(DataSetup.class);

    private AtomicBoolean alreadyRun = new AtomicBoolean(false);

//    private final ArticleDao articleDao;
//    private final AuthorDao authorDao;
//    private final CategoryDao categoryDao;
//
//
//    public DataSetup(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
//        this.articleDao = articleDao;
//        this.authorDao = authorDao;
//        this.categoryDao = categoryDao;
//    }

    @EventListener
    public void testData(ContextRefreshedEvent event) {
        if (!alreadyRun.getAndSet(true)) {
            System.out.println("Aplikacja właśnie się uruchomiła i rozpoczynamy zabawę");
//            categoryDao.save(new Publisher(null, "Publisher1", null));
//            categoryDao.save(new Publisher(null, "Publisher2", null));
//            articleDao.save(new Author(null, "Author1", "Author1", null));
//            articleDao.save(new Author(null, "Author2", "Author2", null));
//            articleDao.save(new Author(null, "Author3", "Author3", null));

//            Publisher publisher1 = categoryDao.findById(1L);
//            Publisher publisher2 = categoryDao.findById(2L);
//            Author author1 = articleDao.findById(1L);
//            Author author2 = articleDao.findById(2L);
//            Author author3 = articleDao.findById(3L);

//            authorDao.save(new Book(null, "Book1", 5, "Description1", publisher1, List.of(author1, author2)));
//            authorDao.save(new Book(null, "Book2", 6, "Description2", publisher2, List.of(author2, author3)));
//
//            logger.debug("--- Wszystkie książki:");
//            logger.debug(authorDao.findAll().stream().map(Book::toString).collect(Collectors.joining("\n")));
//            logger.debug("--- Dla wydawcy: " + publisher1);
//            logger.debug(authorDao.findAllByPublisher(publisher1).stream().map(Book::toString).collect(Collectors.joining("\n")));
//            logger.debug("--- Dla id wydawcy: " + publisher1.getId());
//            logger.debug(authorDao.findAllByPublisher(publisher1.getId()).stream().map(Book::toString).collect(Collectors.joining("\n")));
//            logger.debug("--- Dla autora: " + author1);
//            logger.debug(authorDao.findAllByAuthor(author1).stream().map(Book::toString).collect(Collectors.joining("\n")));
//            logger.debug("--- Dla autora: " + author2);
//            logger.debug(authorDao.findAllByAuthor(author2).stream().map(Book::toString).collect(Collectors.joining("\n")));
        }

    }


}