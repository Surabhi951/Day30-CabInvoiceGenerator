package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CabInvoiceGenerator {
    static List<Customer> customerList = new ArrayList<>();

    public static double calculateFare(double distance, int time) {
        double totalFare = distance * Ride.Category.NORMAL_RIDE.costPerKm + time * Ride.Category.NORMAL_RIDE.costPerMinute;
        if(totalFare < Ride.Category.NORMAL_RIDE.minimumFarePerRide) {
            return Ride.Category.NORMAL_RIDE.minimumFarePerRide;

        }else {
            return totalFare;
        }
    }

    public static double calculatePremiumFare(double distance, int time){
        double totalFare = distance*Ride.Category.PREMIUM_RIDE.costPerKm + time *Ride.Category.PREMIUM_RIDE.costPerMinute;
        return totalFare < Ride.Category.PREMIUM_RIDE.minimumFarePerRide?Ride.Category.PREMIUM_RIDE.minimumFarePerRide:totalFare;


    }

    public static double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for(Ride ride : rides){
            if(ride.getCategory() == Ride.Category.PREMIUM_RIDE){
            totalFare += calculatePremiumFare(ride.getDistance(),ride.getTime());
        }else{
                totalFare += calculateFare(ride.getDistance(),ride.getTime());
            }

            }
        return totalFare;
    }

    public static Invoice generateInvoice(Ride[] rides) {
        double totalFare = calculateFare(rides);
        int totalNumberOfRides = rides.length;
        double averageFarePerRide = totalFare / totalNumberOfRides;
        return new Invoice(totalNumberOfRides, totalFare, averageFarePerRide);
    }

    public static Invoice generateInvoice(int id) {
        List<Customer> customerList1 = customerList.stream().filter(customer -> customer.id == id).collect(Collectors.toList());
        Customer customer = customerList1.get(0);
        return generateInvoice(customer.rideList);
    }
}
