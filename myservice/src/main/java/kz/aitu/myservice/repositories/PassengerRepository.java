package kz.aitu.myservice.repositories;

import kz.aitu.myservice.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}