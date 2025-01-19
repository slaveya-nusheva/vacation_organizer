package edu.vacation.organiser.service;

import edu.vacation.organiser.model.*;
import edu.vacation.organiser.repository.ReservationRepository;
import edu.vacation.organiser.repository.TripRepository;

import java.util.Date;
import java.util.List;

public class VacationOrganiserService {

    private final ReservationRepository reservationRepository;
    private final TripRepository tripRepository;
    public VacationOrganiserService(ReservationRepository reservationRepository, TripRepository tripRepository) {
        this.reservationRepository = reservationRepository;
        this.tripRepository = tripRepository;
    }

    public Reservation makeReservation(Traveller traveller, Trip trip){
        Reservation reservation = new Reservation();
        reservation.addTraveller(traveller);
        reservation.setTrip(trip);
        return reservationRepository.save(reservation);
    }

    public Trip makeTrip (String name, Date startDate, Date endDate, Double pricePerPerson, String phone, TravelType travelType, TripType tripType,List<Destination> destinations){
        Trip trip = new Trip( name,  startDate,  endDate,  pricePerPerson,  phone,  travelType,  tripType, destinations);
        return tripRepository.save(trip);
    }
    public List<Trip> getAllTrips (){
       return tripRepository.findAll();
    }

}
