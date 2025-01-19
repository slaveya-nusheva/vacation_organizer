package edu.vacation.organiser.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Trip trip;
    @ManyToMany()
    @JoinTable(
            name = "reservation_traveller",
            joinColumns = { @JoinColumn(name = "reservation_id") },
            inverseJoinColumns = { @JoinColumn(name = "traveller_id") }
    )
    private List<Traveller> travellers;

    public Reservation() {
    }
    public void addTraveller (Traveller traveller){
        if (travellers == null){
            travellers = new ArrayList<>();
        }
        travellers.add(traveller);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }
}