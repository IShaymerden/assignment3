package kz.aitu.myservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String flightNumber;
    private String destination;


    public Flight() {}

    public Flight(int id, String flightNumber, String destination) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.destination = destination;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
}