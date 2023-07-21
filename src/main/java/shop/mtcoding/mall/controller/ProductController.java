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
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository; //ProductRepository를 new한것임

    @PostMapping("/product/update") //executeUpdate가 있으니 PostMapping사용
    public String update(String name, int price, int qty,int id) {
        productRepository.update(name, price, qty,id);
        return "redirect:/"; //update후 돌아갈 주소 redirect:주소
    }

    @PostMapping("/product/delete") //또한 deleteById를 가보면 executeUpdate가 있다 그러니 PostMapping
    public String delete(int id) {
        productRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/product/{id}")
    public String detail(@PathVariable int id, HttpServletRequest request) { //@PathVariable는 주소창에서 id를 추출할때 사용
//        System.out.println("id: " + id);
        Product product = productRepository.findById(id);
        request.setAttribute("p", product);
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQty());
        return "detail";
    }

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        List<Product> productList = productRepository.findAll();
        request.setAttribute("productList", productList);
        return "home";
    }

    @GetMapping("/write")
    public String writePage() {
        return "write";
    }

    @PostMapping("/product")
    public String write(String name, int price, int qty) {
        System.out.println("name: " + name);
        System.out.println("price: " + price);
        System.out.println("qty: " + qty);
//        return "write";
        productRepository.save(name, price, qty);
        return "redirect:/";
        //컨트롤러의 메서드를 재호출하는법
//        response.sendRedirect("/");
    }


}
