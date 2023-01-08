package ehb.be.webapp.controller;

import ehb.be.webapp.repository.CategoryRepository;
import ehb.be.webapp.repository.ProductRepository;
import ehb.be.webapp.model.Category;
import ehb.be.webapp.model.Product;
import ehb.be.webapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ShopController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductService productService;

    @ModelAttribute("products")
    public Iterable<Product> getAllProd(){
        return productRepository.findAll();
    }

    @ModelAttribute("product")
    public Product getProduct(){
        return new Product();
    }

    @ModelAttribute("categories")
    public Iterable<Category> getAllCat(){
        return categoryRepository.findAll();
    }


    @ModelAttribute("category")
    public Category getCategory(){
        return new Category();
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(String keyword, Model model){
        if(keyword != null) {
            model.addAttribute("products",productService.filterByKeyword(keyword));
        }else {
            model.addAttribute("products",productRepository.findAll());
        }
        return "/products/index";
    }

    //Delete product
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deleteProduct(@PathVariable(value = "id")Long id){
        productRepository.deleteById(id);
        return "redirect:/";
    }

    //Go to add product page
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(){
        return "/products/add";
    }

    //Add product form
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(Product p, BindingResult result){
        productRepository.save(p);
        return "redirect:/";
    }

    //Show detail pages
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showProdcuct(@PathVariable(value = "id")Long id, Model model){
       Optional<Product> p = productRepository.findById(id);
       model.addAttribute("detail",p);
        return "/products/detail";
    }


}
