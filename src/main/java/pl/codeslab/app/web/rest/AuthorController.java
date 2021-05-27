package pl.codeslab.app.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.codeslab.app.domain.dao.AuthorDao;
import pl.codeslab.app.domain.model.Author;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }


    @GetMapping("/add")
    public String add() {
        Author modelObject = new Author(null, "Bla", "Cala");
        authorDao.save(modelObject);
        return "Zapisano pod id = " + modelObject.getId();
    }

    @GetMapping("/edit")
    public String edit() {
        Author modelObject = authorDao.findById(1L);
        modelObject.setFirstName("Ala");
        modelObject.setLastName("Kota");
        return authorDao.update(modelObject).toString();
    }

    @GetMapping("/delete")
    public String delete() {
        Author modelObject = authorDao.findById(1L);
        authorDao.remove(modelObject);
        return "Usunięto o id = " + modelObject.getId();
    }

    @GetMapping("/get")
    public String get() {
        Author modelObject = authorDao.findById(1L);
        return modelObject.toString();
    }
}
