package com.example.documentationswaggerjava1.utils;

import com.example.documentationswaggerjava1.entity.Flight;
import com.example.documentationswaggerjava1.request.BookingRequest;

public class ControllerUtils {

    private ControllerUtils() {
        //private constructor to hide the implicit one,
        //as Utility classes should not have a public constructor
    }

    public static Flight getFlightObject(BookingRequest bookingRequest) {
        Flight flight = new Flight();
        flight.setFlightNumber(bookingRequest.getFlightNumber());
        flight.setFrom(bookingRequest.getFrom());
        flight.setTo(bookingRequest.getTo());
        flight.setJourneyDate(bookingRequest.getJourneyDate());
        return flight;
    }
}
