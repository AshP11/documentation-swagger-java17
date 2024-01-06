package com.example.documentationswaggerjava1.response;

import lombok.Data;

@Data
public class BookingResponse {

    private String passengerId;

    private String from;

    private String to;

    private String flightNumber;

    private String journeyDate;

    private String status;
}
