package kz.aitu.myservice.Controllers;

import kz.aitu.myservice.entities.Passenger;
import kz.aitu.myservice.entities.Flight;
import kz.aitu.myservice.entities.Reservation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {

    @GetMapping("/index")
    public String print() {
        return "Hello world";
    }


    @GetMapping("/passenger/test")
    public Passenger getTestPassenger() {
        return new Passenger(1, "Ali Nur", "KZ12345");
    }


    @GetMapping("/flight/test")
    public Flight getTestFlight() {
        return new Flight(101, "KC-901", "Astana");
    }

    @GetMapping("/reservation/check")
    public Reservation getMockReservation() {
        Passenger p = new Passenger(5, "Daniyar S.", "ID9988");
        Flight f = new Flight(10, "TK-421", "Istanbul");
        return new Reservation("14B", p, f);

    }
}

