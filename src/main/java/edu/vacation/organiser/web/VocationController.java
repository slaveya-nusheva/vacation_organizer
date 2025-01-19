package edu.vacation.organiser.web;


import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import edu.vacation.organiser.model.Traveller;
import edu.vacation.organiser.model.Trip;
import edu.vacation.organiser.service.VacationOrganiserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class VocationController {



    @Autowired
    private VacationOrganiserService vacationOrganiserService;

    public VocationController() {
        super();
    }



    @ModelAttribute("allTrips")
    public List<Trip> populateTrips() {
        return vacationOrganiserService.getAllTrips();
    }



    @RequestMapping({"/","/index"})
    public String makeReservation(final Traveller traveller, final Trip trip) {
        vacationOrganiserService.makeReservation(traveller,trip);
        return "index";
    }



}
