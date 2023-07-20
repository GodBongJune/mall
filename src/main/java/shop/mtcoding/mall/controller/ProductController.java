package shop.mtcoding.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.mall.model.Product;
import shop.mtcoding.mall.model.ProductRepository;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product/{id}")
    public String detail(@PathVariable int id, HttpServletRequest request){
        System.out.println("id: "+id);
        Product product = productRepository.findById(id);
        request.setAttribute("p",product);
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQty());
        return "detail";
    }

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        List<Product> productList = productRepository.findAll();
        request.setAttribute("productList",productList);
        return "home";
    }

    @GetMapping("/write")
    public String writePage() {
        return "write";
    }

    @PostMapping("/product")
    public String write(String name, int price, int qty) throws IOException {
        System.out.println("name: " + name);
        System.out.println("price: " + price);
        System.out.println("qty: " + qty);
//        return "write";
        productRepository.save(name, price, qty);
        return "redirect:/";
    }
}
