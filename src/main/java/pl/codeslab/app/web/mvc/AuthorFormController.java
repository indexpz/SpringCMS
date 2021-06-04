package pl.codeslab.app.web.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.codeslab.app.domain.dao.AuthorDao;
import pl.codeslab.app.domain.model.Author;

@Controller
@RequestMapping("/forms/author")
@Slf4j
public class AuthorFormController {
    
    private final AuthorDao authorDao;

    public AuthorFormController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/list")
    public String prepareList(Model model) {
        model.addAttribute("authors", authorDao.findAll());
        return "authors/list";
    }

    @GetMapping("/create")
    public String prepareCreate(Model model){
        model.addAttribute("author", new Author());
        return "authors/create-form";
    }

    @PostMapping("/create")
    public String processCreate(Author author){
        log.debug("Kategoria przed zapisem " + author);
        authorDao.save(author);
        log.debug("Kategoria po zapisie " + author);
        return "redirect:/forms/author/list";
    }

    @GetMapping("/edit")
    public String prepareEdit(Long id,Model model){
        model.addAttribute("author", authorDao.findById(id));
        return "authors/edit-form";
    }

    @PostMapping("/edit")
    public String procesEdit(Author author){
        authorDao.update(author);
        return "redirect:/forms/author/list";
    }

    @GetMapping("/delete")
    public String prepareDelete(Long id, Model model){
        model.addAttribute("author", authorDao.findById(id));
        return "authors/confirm-delete";
    }

    @PostMapping("/delete")
    public String processDelete(Long id){
        Author author = authorDao.findById(id);
        authorDao.remove(author);
        return "redirect:/forms/author/list";
    }
    
}
