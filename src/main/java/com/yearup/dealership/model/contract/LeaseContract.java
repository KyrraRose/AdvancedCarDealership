package com.yearup.dealership.model.contract;

import com.yearup.dealership.model.Vehicle;

public class LeaseContract extends Contract{
    double expectedEndValue,leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double totalPrice, double monthlyPayment) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.expectedEndValue = this.vehicleSold.getPrice()/2;
        this.leaseFee = this.vehicleSold.getPrice()*.07;
    }

    public double getExpectedEndValue() {
        return expectedEndValue;
    }

    public void setExpectedEndValue(double expectedEndValue) {
        this.expectedEndValue = expectedEndValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return this.expectedEndValue + this.leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        double interestRate = .04, length = 36;
        return  getTotalPrice() * (interestRate * (Math.pow((1 + interestRate), length) / (Math.pow((1 + interestRate), length) - 1)));
    }
}
