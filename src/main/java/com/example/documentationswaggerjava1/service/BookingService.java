package com.example.documentationswaggerjava1.service;

import com.example.documentationswaggerjava1.dao.PassengerDao;
import com.example.documentationswaggerjava1.entity.Flight;
import com.example.documentationswaggerjava1.entity.Passenger;
import com.example.documentationswaggerjava1.response.BookingResponse;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

@Service
@Log
public class BookingService {

    public BookingResponse bookFlight(Flight flight, Optional<Passenger> passenger) {
        passenger.ifPresent(object -> log.log(Level.INFO, "Flight {0} booked from {1} to {2} for {3} {4}",
                new Object[]{flight.getFlightNumber(), flight.getFrom(), flight.getTo(),
                        object.getFirstName(), object.getLastName()}));
        BookingResponse response = new BookingResponse();
        response.setFlightNumber(flight.getFlightNumber());
        response.setFrom(flight.getFrom());
        response.setTo(flight.getTo());
        response.setPassengerId(passenger.get().getId());
        response.setJourneyDate(flight.getJourneyDate());
        response.setStatus(EFlightBookingStatus.BOOKED_SUCCESSFULLY.name());
        return response;
    }

    public List<Passenger> getAllPassengers() {
        PassengerDao passengerDao = new PassengerDao();
        return passengerDao.getPassengerList();
    }
}
