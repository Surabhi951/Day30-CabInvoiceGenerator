package com.bridgelabz;

public class Ride {

    private double distance;
    private int time;


    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public enum Category {
        NORMAL_RIDE(10, 1, 5);

        public double costPerKm;
        public int costPerMinute;
        public double minimumFarePerRide;


         Category(double costPerKm, int costPerMinute, double minimumFarePerRide) {
            this.costPerKm = costPerKm;
            this.costPerMinute = costPerMinute;
            this.minimumFarePerRide = minimumFarePerRide;
        }
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


}
