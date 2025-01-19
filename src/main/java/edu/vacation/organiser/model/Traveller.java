package edu.vacation.organiser.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "traveller")
public class Traveller {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String EGN;
    private int age;
    private String phone;
    @ManyToMany
    private List<Reservation> reservations;

    // Constructors, getters, and setters
    public Traveller() {}
    public Traveller(String name, String EGN, int age, String phone) {
        this.name = name;
        this.EGN = EGN;
        this.age = age;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEGN() {
        return EGN;
    }

    public void setEGN(String EGN) {
        this.EGN = EGN;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
