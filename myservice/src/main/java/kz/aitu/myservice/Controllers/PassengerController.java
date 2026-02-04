package kz.aitu.myservice.Controllers;

import kz.aitu.myservice.entities.Passenger;
import kz.aitu.myservice.repositories.PassengerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    private final PassengerRepository repository;

    public PassengerController(PassengerRepository repository) {
        this.repository = repository;
    }

    @GetMapping // Здесь http://localhost:8081/passengers
    public List<Passenger> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Passenger getById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found"));
    }

    @PostMapping // Тут POST http://localhost:8081/passengers
    public Passenger create(@RequestBody Passenger passenger) {
        return repository.save(passenger);
    }

    @PutMapping("/{id}") // Тут PUT http://localhost:8081/passengers
    public Passenger update(@PathVariable Integer id, @RequestBody Passenger details) {
        Passenger p = repository.findById(id).get();
        p.setName(details.getName());
        p.setPassportNumber(details.getPassportNumber());
        return repository.save(p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
