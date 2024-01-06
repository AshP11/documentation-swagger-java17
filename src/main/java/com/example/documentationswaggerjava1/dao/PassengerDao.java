package com.example.documentationswaggerjava1.dao;

import com.example.documentationswaggerjava1.entity.Passenger;

public class PassengerDao {

    public Passenger getPassenger(String id) {
        Passenger passenger = new Passenger();
        passenger.setId(id);
        passenger.setFirstName("John");
        passenger.setLastName("Wood");
        return passenger;
    }
}
