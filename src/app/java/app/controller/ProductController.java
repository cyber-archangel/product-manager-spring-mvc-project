package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import app.service.*;
import app.model.*;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("products", productService.getProductList());
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        ModelAndView modelAndView = new ModelAndView("search");
        modelAndView.addObject("result", productService.getSearchResult(keyword));
        return modelAndView;
    }

    @GetMapping("/new")
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "new";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:home";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id) {
        productService.delete(productService.getProductById(id));
        return "redirect:home";
    }

    @ExceptionHandler(Exception.class)
    public String error() {
        return "error";
    }
}