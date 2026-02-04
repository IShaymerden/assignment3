package kz.aitu.myservice.Controllers;

import kz.aitu.myservice.entities.Reservation;
import kz.aitu.myservice.repositories.ReservationRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationRepository repository;

    public ReservationController(ReservationRepository repository) { this.repository = repository; }

    @GetMapping
    public List<Reservation> getAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public Reservation getById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + id));
    }

    @PostMapping
    public Reservation create(@RequestBody Reservation reservation) { return repository.save(reservation); }

    @PutMapping("/{id}")
    public Reservation update(@PathVariable Integer id, @RequestBody Reservation details) {
        Reservation res = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        res.setSeatNumber(details.getSeatNumber());
        return repository.save(res);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        Reservation res = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + id));

        repository.delete(res);
        return "Reservation with ID " + id + " deleted successfully";
    }

}
