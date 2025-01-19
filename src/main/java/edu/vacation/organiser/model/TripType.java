package edu.vacation.organiser.model;

import jakarta.persistence.*;

@Entity
@Table(name = "trip_type")
public class TripType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    public TripType() {}
    public TripType(String name) {
        this.name = name;
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
}