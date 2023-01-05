package ehb.be.webapp.controller;

import ehb.be.webapp.repository.CategoryRepository;
import ehb.be.webapp.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryRepository dao;

    @ModelAttribute("categories")
    public Iterable<Category> getAll(){ return dao.findAll(); }


    @ModelAttribute("category")
    public Category getCategory(){
        return new Category();
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(){
        return "/category/index";
    }


    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deleteCategory(@PathVariable(value = "id")Long id){
        dao.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(){
        return "/category/add";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCategory(Category c, BindingResult result){
        dao.save(c);
        return "redirect:/";
    }
}
