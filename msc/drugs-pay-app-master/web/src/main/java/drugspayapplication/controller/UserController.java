package drugspayapplication.controller;

import drugspayapplication.entity.User;
import drugspayapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    @ResponseBody
    Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    @ResponseBody
    void postUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping("/deleteById/{id}")
    @ResponseBody
    Long deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
