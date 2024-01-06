package com.example.documentationswaggerjava1.service;

import com.example.documentationswaggerjava1.entity.Flight;
import com.example.documentationswaggerjava1.entity.Passenger;
import com.example.documentationswaggerjava1.response.BookingResponse;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.logging.Level;

@Service
@Log
public class BookingService {

    public BookingResponse bookFlight(Flight flight, Passenger passenger) {
        log.log(Level.INFO, "Flight {0} booked from {1} to {2} for {3} {4}",
                new Object[]{flight.getFlightNumber(), flight.getFrom(), flight.getTo(),
                passenger.getFirstName(), passenger.getLastName()});
        BookingResponse response = new BookingResponse();
        response.setFlightNumber(flight.getFlightNumber());
        response.setFrom(flight.getFrom());
        response.setTo(flight.getTo());
        response.setPassengerId(passenger.getId());
        response.setJourneyDate(flight.getJourneyDate());
        response.setStatus("BOOKED SUCCESSFULLY");
        return response;
    }
}
