package com.yearup.dealership.model.contract;

import com.yearup.dealership.model.Vehicle;

public class SalesContract extends Contract {
    private double salesTax,recordingFee,processingFee;
    private boolean finance;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double totalPrice, double monthlyPayment, boolean finance) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.salesTax = .05;
        this.recordingFee = 100;
        if (this.vehicleSold.getPrice()<10000){
            this.processingFee = 295;
        }else{
            this.processingFee = 495;
        }
        this.finance = finance;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    @Override
    public double getTotalPrice() {
        return (this.vehicleSold.getPrice() * this.salesTax) + this.recordingFee + this.processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        double interestRate,length;
        if (this.finance){
            if (this.vehicleSold.getPrice()>10000){
                interestRate = .0425;
                length = 48;
            }else{
                interestRate = .0525;
                length = 24;
            }
            this.monthlyPayment = getTotalPrice() * (interestRate * (Math.pow((1 + interestRate), length) / (Math.pow((1 + interestRate), length) - 1)));
        }else{
            this.monthlyPayment = 0;
        }
        return this.monthlyPayment;
    }

}
