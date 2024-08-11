package com.company;
import java.io.FileWriter;
import java.io.IOException;

// Base class with encapsulation
class Deposit {
    private double amount;
    private double interestRate;
    private int duration; // in months

    // Constructor
    public Deposit(double amount, double interestRate, int duration) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.duration = duration;
    }

    public double getAmount() {
        return amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getDuration() {
        return duration;
    }

    // toString method
    @Override
    public String toString() {
        return "Deposit{" +
                "amount=" + amount +
                ", interestRate=" + interestRate +
                ", duration=" + duration +
                " months}";
    }
}

// Derived class for LongTermDeposit
class LongTermDeposit extends Deposit {
    public LongTermDeposit(double amount, double interestRate, int duration) {
        super(amount, interestRate, duration);
    }

    @Override
    public String toString() {
        return "LongTermDeposit: " + super.toString();
    }
}

// Derived class for ShortTermDeposit
class ShortTermDeposit extends Deposit {
    public ShortTermDeposit(double amount, double interestRate, int duration) {
        super(amount, interestRate, duration);
    }

    @Override
    public String toString() {
        return "ShortTermDeposit: " + super.toString();
    }
}

// Derived class for LoanDeposit
class LoanDeposit extends Deposit {
    public LoanDeposit(double amount, double interestRate, int duration) {
        super(amount, interestRate, duration);
    }

    @Override
    public String toString() {
        return "LoanDeposit: " + super.toString();
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create objects
        LongTermDeposit longTerm = new LongTermDeposit(10000, 5.5, 60);
        ShortTermDeposit shortTerm = new ShortTermDeposit(5000, 3.0, 12);
        LoanDeposit loanDeposit = new LoanDeposit(20000, 7.0, 36);


        System.out.println(longTerm.toString());
        System.out.println(shortTerm.toString());
        System.out.println(loanDeposit.toString());

        // Write the results to a text file
        try (FileWriter writer = new FileWriter("deposits.txt")) {
            writer.write(longTerm.toString() + "\n");
            writer.write(shortTerm.toString() + "\n");
            writer.write(loanDeposit.toString() + "\n");
            System.out.println("Results have been written to deposits.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
