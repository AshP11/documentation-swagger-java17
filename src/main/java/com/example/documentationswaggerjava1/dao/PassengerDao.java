package com.example.documentationswaggerjava1.dao;

import com.example.documentationswaggerjava1.entity.Passenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PassengerDao {

    public List<Passenger> getPassengerList() {
        List<Passenger> passengerList = new ArrayList<>();
        passengerList.add(new Passenger("1","Will","Smith"));
        passengerList.add(new Passenger("2","Abhishek","T"));
        passengerList.add(new Passenger("3","Arjun","Reddy"));
        passengerList.add(new Passenger("4","Chandrasekhar","P"));
        passengerList.add(new Passenger("5","Mark","Wood"));
        passengerList.add(new Passenger("6","Larry","Root"));
        return passengerList;
    }

    public Optional<Passenger> getPassenger(String id) {
        return getPassengerList().stream().filter(p -> p.getId().equals(id)).findFirst();
    }
}
