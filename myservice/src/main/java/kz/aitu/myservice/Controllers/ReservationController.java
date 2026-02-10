package kz.aitu.myservice.Controllers;

import kz.aitu.myservice.entities.Flight;
import kz.aitu.myservice.entities.Passenger;
import kz.aitu.myservice.entities.Reservation;
import kz.aitu.myservice.repositories.FlightRepository;
import kz.aitu.myservice.repositories.PassengerRepository;
import kz.aitu.myservice.repositories.ReservationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationRepository repository;
    private final PassengerRepository passengerRepository; // Добавили это
    private final FlightRepository flightRepository;       // И это


    public ReservationController(ReservationRepository repository,
                                 PassengerRepository passengerRepository,
                                 FlightRepository flightRepository) {
        this.repository = repository;
        this.passengerRepository = passengerRepository;
        this.flightRepository = flightRepository;
    }

    @GetMapping
    public List<Reservation> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getById(@PathVariable Integer id) {

        Reservation reservation = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + id));

        if (reservation.getPassenger() != null) {
            Passenger p = passengerRepository.findById(reservation.getPassenger().getId()).orElse(null);
            reservation.setPassenger(p);
        }
        if (reservation.getFlight() != null) {
            Flight f = flightRepository.findById(reservation.getFlight().getId()).orElse(null);
            reservation.setFlight(f);
        }

        return reservation;
    }

    @PostMapping
    public Reservation create(@RequestBody Reservation reservation) {

        if (reservation.getPassenger() != null && reservation.getPassenger().getId() != null) {
            Passenger p = passengerRepository.findById(reservation.getPassenger().getId())
                    .orElseThrow(() -> new RuntimeException("Passenger not found"));
            reservation.setPassenger(p);
        }
        if (reservation.getFlight() != null && reservation.getFlight().getId() != null) {
            Flight f = flightRepository.findById(reservation.getFlight().getId())
                    .orElseThrow(() -> new RuntimeException("Flight not found"));
            reservation.setFlight(f);
        }

        return repository.save(reservation);
    }

    @PutMapping("/{id}")
    public Reservation update(@PathVariable Integer id, @RequestBody Reservation details) {
        Reservation res = repository.findById(id).orElseThrow();
        res.setSeatNumber(details.getSeatNumber());


        if (details.getPassenger() != null) {
            res.setPassenger(passengerRepository.findById(details.getPassenger().getId()).orElse(null));
        }
        if (details.getFlight() != null) {
            res.setFlight(flightRepository.findById(details.getFlight().getId()).orElse(null));
        }

        return repository.save(res);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
