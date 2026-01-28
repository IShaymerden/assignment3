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

    @PostMapping // Тут POST http://localhost:8081/passengers
    public Passenger create(@RequestBody Passenger passenger) {
        return repository.save(passenger);
    }
}
