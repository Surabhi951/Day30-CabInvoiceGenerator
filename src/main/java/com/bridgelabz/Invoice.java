package com.bridgelabz;

import java.util.Objects;

public class Invoice {
    private int totalNumberOfRides;
    private double totalFare;
    private double averageFarePerRide;

    public Invoice(int totalNumberOfRides, double totalFare, double averageFarePerRide) {
        this.totalNumberOfRides = totalNumberOfRides;
        this.totalFare = totalFare;
        this.averageFarePerRide = averageFarePerRide;
    }

    public int getTotalNumberOfRides() {
        return totalNumberOfRides;
    }

    public void setTotalNumberOfRides(int totalNumberOfRides) {
        this.totalNumberOfRides = totalNumberOfRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    public double getAverageFarePerRide() {
        return averageFarePerRide;
    }

    public void setAverageFarePerRide(double averageFarePerRide) {
        this.averageFarePerRide = averageFarePerRide;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "totalNumberOfRides=" + totalNumberOfRides +
                ", totalFare=" + totalFare +
                ", averageFarePerRide=" + averageFarePerRide +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return totalNumberOfRides == invoice.totalNumberOfRides && Double.compare(invoice.totalFare, totalFare) == 0 && Double.compare(invoice.averageFarePerRide, averageFarePerRide) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalNumberOfRides, totalFare, averageFarePerRide);
    }
}
