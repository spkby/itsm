package drugspayapplication.controller;


import drugspayapplication.entity.Patient;
import drugspayapplication.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/")
    @ResponseBody
    Iterable<Patient> getAll() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    Patient getPatient(@PathVariable Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    @ResponseBody
    void postPatient(@RequestBody Patient patient) {
        patientRepository.save(patient);
    }

    @GetMapping("/deleteById/{id}")
    @ResponseBody
    Long deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
        return id;
    }

}
