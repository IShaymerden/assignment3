package kz.aitu.myservice.Controllers;

import kz.aitu.myservice.entities.Flight;
import kz.aitu.myservice.repositories.FlightRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightRepository repository;

    public FlightController(FlightRepository repository) { this.repository = repository; }

    @GetMapping
    public List<Flight> getAll() { return repository.findAll(); }

    @PostMapping
    public Flight create(@RequestBody Flight flight) { return repository.save(flight); }
}
