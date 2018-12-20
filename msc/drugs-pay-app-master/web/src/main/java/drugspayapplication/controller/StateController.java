package drugspayapplication.controller;


import drugspayapplication.entity.State;
import drugspayapplication.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/state")
public class StateController {
    @Autowired
    private StateRepository stateRepository;

    @GetMapping("/")
    @ResponseBody
    Iterable<State> getAll() {
        return stateRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    State getState(@PathVariable Long id) {
        return stateRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    @ResponseBody
    void postState(@RequestBody State state) {
        stateRepository.save(state);
    }

    @GetMapping("/deleteById/{id}")
    @ResponseBody
    Long deleteState(@PathVariable Long id) {
        stateRepository.deleteById(id);
        return id;
    }
}

