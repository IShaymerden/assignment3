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

    @GetMapping("/{id}")
    public Flight getById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found with id: " + id));
    }

    @PostMapping
    public Flight create(@RequestBody Flight flight) { return repository.save(flight); }

    @PutMapping("/{id}")
    public Flight update(@PathVariable Integer id, @RequestBody Flight details) {
        Flight flight = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found with id: " + id));
        flight.setFlightNumber(details.getFlightNumber());
        flight.setDestination(details.getDestination());

        return repository.save(flight);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        Flight flight = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found with id: " + id));

        repository.delete(flight);
        return "Flight with ID " + id + " deleted successfully";
    }
}
