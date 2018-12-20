package front;

import front.exeptions.NotFoundExeption;
import front.models.User;
import front.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
@CrossOrigin()
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private HttpStatus httpStatus = HttpStatus.ACCEPTED;

    @GetMapping
    public Iterable<User> userFindAll() {
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    public User UserFindById(@PathVariable String id) {
        Optional<User> byId = userRepository.findById(Integer.parseInt(id));
        return byId.orElse(null);
    }

    @PostMapping("{userLogin}/{userEmail}/{userPassword}")
    public HttpStatus create(@PathVariable(name = "userLogin") String userLogin, @PathVariable(name = "userEmail") String userEmail,
                             @PathVariable(name = "userPassword") String userPassword) {
        try {
            User user = new User(userLogin, userEmail, userPassword);
            userRepository.save(user);
        } catch (RuntimeException ex) {
            ex.fillInStackTrace();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return httpStatus;
    }

    @PutMapping("{id}/{userLogin}/{userEmail}/{userPassword}")
    public HttpStatus update(@PathVariable(name = "userId") String userId, @PathVariable(name = "userLogin") String userLogin, @PathVariable(name = "userEmail") String userEmail,
                             @PathVariable(name = "userPassword") String userPassword) {
        User user;
        Optional<User> byId = userRepository.findById(Integer.parseInt(userId));
        if (byId.isPresent()) {
            user = byId.get();
        } else {
            return HttpStatus.NOT_FOUND;
        }
        try {
            user.setUserLogin(userLogin);
            user.setUserEmail(userEmail);
            user.setPassword(userPassword);
            userRepository.save(user);
        } catch (RuntimeException ex) {
            ex.fillInStackTrace();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return httpStatus;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    HttpStatus delete(@PathVariable String id) {
        Optional<User> byId = userRepository.findById(Integer.parseInt(id));
        if (byId.isPresent()) {
            userRepository.delete(byId.get());
        } else {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return httpStatus;
    }
}