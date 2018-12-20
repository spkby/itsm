package front;

import front.exeptions.NotFoundExeption;
import front.models.Product;
import front.models.State;
import front.models.User;
import front.repository.ProductRepository;
import front.repository.StateRepository;
import front.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("product")
@CrossOrigin()
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Iterable<Product> userProductAll() {
        return productRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Product> UserProductById(@PathVariable String id) {
        Optional<Product> byId = productRepository.findById(Integer.parseInt(id));
        if (!byId.isPresent()) {
            throw new NotFoundExeption();
        } else {
            return byId;
        }
    }

    @PostMapping("{name}/{stateId}")
    public HttpStatus create(@PathVariable(name = "name") String name, @PathVariable(name = "stateId") String stateId ) {
        HttpStatus httpStatus= HttpStatus.ACCEPTED;
        State state = stateRepository.findById(Integer.parseInt(stateId)).get();
        User user = userRepository.findById(4).get();
        try{
            productRepository.save(new Product(name, state, user, LocalDateTime.now(), user, LocalDateTime.now()));
        }catch (RuntimeException ex){
            ex.fillInStackTrace();
            httpStatus= HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return httpStatus;
    }

    @PutMapping("{id}")
    public Product update(@RequestBody Product product){
         productRepository.save(product);
         return product;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody void delete (@PathVariable String id){
        Optional<Product> byId = productRepository.findById(Integer.parseInt(id));
        productRepository.delete(byId.get());
    }
}