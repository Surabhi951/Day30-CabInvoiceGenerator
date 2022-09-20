package com.bridgelabz;

public class CabInvoiceGenerator {

    public double calculateFare(double distance, int time) {
        double totalFare = distance * Ride.Category.NORMAL_RIDE.costPerKm + time * Ride.Category.NORMAL_RIDE.costPerMinute;
        if(totalFare <= Ride.Category.NORMAL_RIDE.minimumFarePerRide) {
            return Ride.Category.NORMAL_RIDE.minimumFarePerRide;

        }else {
            return totalFare;
        }
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for(Ride ride : rides){
            totalFare += calculateFare(ride.getDistance(),ride.getTime());
        }
        return totalFare;
    }

    public Invoice generateInvoice(Ride[] rides) {
        double totalFare = calculateFare(rides);
        int totalNumberOfRides = rides.length;
        double averageFarePerRide = totalFare / totalNumberOfRides;
        return new Invoice(totalNumberOfRides, totalFare, averageFarePerRide);
    }
}
