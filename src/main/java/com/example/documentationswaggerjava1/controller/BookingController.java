package com.example.documentationswaggerjava1.controller;

import com.example.documentationswaggerjava1.dao.PassengerDao;
import com.example.documentationswaggerjava1.entity.Flight;
import com.example.documentationswaggerjava1.entity.Passenger;
import com.example.documentationswaggerjava1.request.BookingRequest;
import com.example.documentationswaggerjava1.response.BookingResponse;
import com.example.documentationswaggerjava1.service.BookingService;
import com.example.documentationswaggerjava1.utils.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@RequestMapping("/v1/api")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<BookingResponse> bookFlight(@RequestBody BookingRequest bookingRequest) {
        PassengerDao passengerDao = new PassengerDao();
        Optional<Passenger> passenger = passengerDao.getPassenger(bookingRequest.getId());
        if (isEmpty(passenger)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            Flight flight = ControllerUtils.getFlightObject(bookingRequest);
            BookingResponse response = bookingService.bookFlight(flight, passenger);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
    }

    @GetMapping("/getAllPassengers")
    public ResponseEntity<List<Passenger>> getAllPassengers() {
       return ResponseEntity.status(HttpStatus.OK).body(bookingService.getAllPassengers());
    }
}
