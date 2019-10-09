package BankAccountLab;

public class BankAccount {
    private static double interestRate = 0.02;
    private static int acccountsID = 0;

    private int id;
    private double balance;


    public BankAccount() {
        this.id = ++acccountsID;
        this.balance = 0.0;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void deposit(double balance) {
        this.balance += balance;
    }

    public Integer getID() {
        return this.id;
    }

    public double getRevenue(int years) {
        return this.balance * years * BankAccount.interestRate;
    }
}
