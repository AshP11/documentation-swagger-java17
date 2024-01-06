package com.example.documentationswaggerjava1.controller;

import com.example.documentationswaggerjava1.dao.PassengerDao;
import com.example.documentationswaggerjava1.entity.Flight;
import com.example.documentationswaggerjava1.entity.Passenger;
import com.example.documentationswaggerjava1.request.BookingRequest;
import com.example.documentationswaggerjava1.response.BookingResponse;
import com.example.documentationswaggerjava1.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponse> bookFlight(@RequestBody BookingRequest bookingRequest) {
        PassengerDao passengerDao = new PassengerDao();
        Passenger passenger = passengerDao.getPassenger(bookingRequest.getId());
        Flight flight = getFlightObject(bookingRequest);
        BookingResponse response = bookingService.bookFlight(flight, passenger);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    private Flight getFlightObject(BookingRequest bookingRequest) {
        Flight flight = new Flight();
        flight.setFlightNumber(bookingRequest.getFlightNumber());
        flight.setFrom(bookingRequest.getFrom());
        flight.setTo(bookingRequest.getTo());
        flight.setJourneyDate(bookingRequest.getJourneyDate());
        return flight;
    }
}
