package com.invoicegenerator;

import InvoiceSummary.InvoiceSummary;

public class InvoiceGenerator {

    private static final double MINIMUN_COST_PER_KILOMETER = 10;
    private static final double MINIMUN_FARE = 5;
    private static final int COST_PER_TIME = 1;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUN_COST_PER_KILOMETER + time * COST_PER_TIME;
        if (totalFare < MINIMUN_FARE)
            return MINIMUN_FARE;
            return totalFare;

    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return null;
    }
}
