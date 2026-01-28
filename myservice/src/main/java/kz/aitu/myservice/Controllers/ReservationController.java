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

    @PostMapping
    public Reservation create(@RequestBody Reservation reservation) { return repository.save(reservation); }
}
