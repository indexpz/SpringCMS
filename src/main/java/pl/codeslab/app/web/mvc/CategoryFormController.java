package pl.codeslab.app.web.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.codeslab.app.domain.dao.CategoryDao;
import pl.codeslab.app.domain.model.Category;

@Controller
@RequestMapping("/forms/category")
@Slf4j
public class CategoryFormController {
    private final CategoryDao categoryDao;

    public CategoryFormController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/list")
    public String prepareList(Model model) {
        model.addAttribute("categories", categoryDao.findAll());
        return "categories/list";
    }

    @GetMapping("/create")
    public String prepareCreate(Model model){
        model.addAttribute("category", new Category());
        return "categories/create-form";
    }

    @PostMapping("/create")
    public String processCreate(Category category){
        log.debug("Kategoria przed zapisem " + category);
        categoryDao.save(category);
        log.debug("Kategoria po zapisie " + category);
        return "redirect:/forms/category/list";
    }

    @GetMapping("/edit")
    public String prepareEdit(Long id,Model model){
        model.addAttribute("category", categoryDao.findById(id));
        return "categories/edit-form";
    }

    @PostMapping("/edit")
    public String procesEdit(Category category){
        categoryDao.update(category);
        return "redirect:/forms/category/list";
    }

    @GetMapping("/delete")
    public String prepareDelete(Long id, Model model){
        model.addAttribute("category", categoryDao.findById(id));
        return "categories/confirm-delete";
    }

    @PostMapping("/delete")
    public String processDelete(Long id){
        Category category = categoryDao.findById(id);
        categoryDao.remove(category);
        return "redirect:/forms/category/list";
    }
}
