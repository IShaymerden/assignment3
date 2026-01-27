package kz.aitu.myservice.entities;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass // Поля этого класса появятся в таблице наследника (Passenger)
public abstract class Person {
    private String firstName;
    private String lastName;
    private String email;

    public Person() {}

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Геттеры и сеттеры
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}