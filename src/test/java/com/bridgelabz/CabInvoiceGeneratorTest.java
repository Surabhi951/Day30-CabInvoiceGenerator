package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {

    CabInvoiceGenerator cabInvoiceGenerator;

    @BeforeEach
    void initialize(){
        cabInvoiceGenerator = new CabInvoiceGenerator();
    }

    @Test
    void givenDistanceAndTime_ShouldReturn_TotalFare(){
        double totalFare = cabInvoiceGenerator.calculateFare(5.5,10);
        Assertions.assertEquals(65,totalFare);
    }

    @Test
    void givenDistanceAndTime_ShouldReturn_MinimumFare(){
         double totalFare = cabInvoiceGenerator.calculateFare(0.2,1);
        Assertions.assertEquals(5,totalFare);
    }

    @Test
    void givenMultipleRide_ShouldReturn_TotalFare(){
       Ride ride1 = new Ride(4, 10);
       Ride ride2 = new Ride(5,10);
       Ride ride3 = new Ride(3, 10);
       Ride[] rides = new Ride[]{ride1,ride2,ride3};
       double totalFare = cabInvoiceGenerator.calculateFare(rides);
       Assertions.assertEquals(150.0, totalFare);
    }

    @Test
    void givenMultipleRide_ShouldReturn_Invoice(){
        Ride ride1 = new Ride(4, 10);
        Ride ride2 = new Ride(5,10);
        Ride ride3 = new Ride(3, 10);
        Ride[] rides = new Ride[]{ride1,ride2,ride3};
        Invoice actualInvoice = cabInvoiceGenerator.generateInvoice(rides);
        Invoice expectedInvoice = new Invoice(3, 150.0, 50.0);
        Assertions.assertEquals(actualInvoice,expectedInvoice);
    }

    @Test
    void givenUserId_ShouldReturn_Invoice(){
        Ride ride1 = new Ride(4, 10);
        Ride ride2 = new Ride(5,10);
        Ride ride3 = new Ride(3, 10);
        Ride[] rides1 = new Ride[]{ride1,ride2,ride3};
        Customer customer1 = new Customer(1);
        customer1.rideList = rides1;
        CabInvoiceGenerator.customerList.add(customer1);
        Ride ride4 = new Ride(8, 4);
        Ride[] rides2 = new Ride[]{ride4};
        Customer customer2 = new Customer(2);
        customer2.rideList = rides2;
        CabInvoiceGenerator.customerList.add(customer2);
        Invoice actualInvoice = CabInvoiceGenerator.generateInvoice(1);
        Invoice expectedInvoice = new Invoice(3, 150.0, 50.0);
        Assertions.assertEquals(actualInvoice,expectedInvoice);
    }

    @Test
    void givenUserId_ShouldReturn_Invoice_ForPremiumRides(){
        Ride ride1 = new Ride(Ride.Category.NORMAL_RIDE,4, 10);
        Ride ride2 = new Ride(Ride.Category.NORMAL_RIDE,5,10);
        Ride ride3 = new Ride(Ride.Category.NORMAL_RIDE,3, 10);
        Ride[] rides1 = new Ride[]{ride1,ride2,ride3};
        Customer customer1 = new Customer(1);
        customer1.rideList = rides1;
        CabInvoiceGenerator.customerList.add(customer1);
        Ride ride4 = new Ride(Ride.Category.PREMIUM_RIDE,8, 4);
        Ride ride5 = new Ride(Ride.Category.PREMIUM_RIDE,6, 3);
        Ride[] rides2 = new Ride[]{ride4, ride5};
        Customer customer2 = new Customer(2);
        customer2.rideList = rides2;
        CabInvoiceGenerator.customerList.add(customer2);
        Invoice actualInvoice = CabInvoiceGenerator.generateInvoice(2);
        Invoice expectedInvoice = new Invoice(2, 224.0, 112.0);
        Assertions.assertEquals(actualInvoice,expectedInvoice);

    }
}
