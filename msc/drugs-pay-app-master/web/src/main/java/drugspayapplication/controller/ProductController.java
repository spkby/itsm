package drugspayapplication.controller;

import drugspayapplication.entity.Product;
import drugspayapplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
        @ResponseBody
        Iterable<Product> getAll() {
            return productRepository.findAll();
        }

        @GetMapping("/{id}")
        @ResponseBody
        Product getProduct(@PathVariable Long id) {
            return productRepository.findById(id).orElse(null);
        }

        @PostMapping("/")
        @ResponseBody
        void postProduct(@RequestBody Product product) {
            productRepository.save(product);
        }

        @GetMapping("/deleteById/{id}")
        @ResponseBody
        Long deleteProduct(@PathVariable Long id) {
            productRepository.deleteById(id);
            return id;
        }
}
