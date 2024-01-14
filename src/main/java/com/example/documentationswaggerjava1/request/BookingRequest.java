package com.example.documentationswaggerjava1.request;

import lombok.Data;

@Data
public class BookingRequest {

    private String id;

    private String from;

    private String to;

    private String flightNumber;

    private String journeyDate;
}
