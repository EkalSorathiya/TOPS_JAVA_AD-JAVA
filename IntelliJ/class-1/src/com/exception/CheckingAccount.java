package com.exception;

public class CheckingAccount {
    int accno;
    double balance;
    String name;
    public CheckingAccount(int accno, double balance, String name) {
        this.accno = accno;
        this.balance = balance;
        this.name = name;
        System.out.println("Hello "+this.name+" Your Account "+this.accno+" Is Now Opened With "+this.balance+" Rs.");
    }
    public void deposit(double amount){
        this.balance=this.balance+amount;
    }

    public void withdraw(double amount) throws InSufficientFund
    {
        if(amount<this.balance){
            this.balance=this.balance-amount;
        }
        else{
            double needs =amount -this.balance;
            throw new InSufficientFund(needs);

        }
    }
    public void checkBalance()
    {
        System.out.println("Current Balance: "+this.balance);
    }
}
