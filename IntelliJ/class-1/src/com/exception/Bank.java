package com.exception;

import java.security.cert.TrustAnchor;
import java.sql.Struct;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        double amount;
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------");
        System.out.print("Enter Account number: ");
        int accno = sc.nextInt();
        System.out.println("------------------------------------------------");
        System.out.print("Enter Customer name: ");
        String name = sc.next();
        System.out.println("------------------------------------------------");
        System.out.print("Enter Initial Amount: ");
        double balance = sc.nextDouble();
        System.out.println("------------------------------------------------");
        CheckingAccount c = new CheckingAccount(accno, balance, name);
        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdrawal");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice: ");
            int choice=sc.nextInt();
            if(choice==1){
                System.out.print("Enter Diposit amount: ");
                amount=sc.nextDouble();
                c.deposit(amount);
                System.out.println("Amount Deposited Successfully");
                System.out.println("------------------------------------------------");
            } else if (choice==2) {
                try{
                    System.out.print("Enter withdrawal amount: ");
                    amount=sc.nextDouble();
                    c.withdraw(amount);
                    System.out.print("Amount Withdrawal Successfully");
                    System.out.println("------------------------------------------------");
                }catch (InSufficientFund e){
                    System.out.print("Sorry you need another "+e.getAmount()+"Rs. to Withdraw");
                    System.out.println("------------------------------------------------");
                }
            } else if (choice==3) {
                c.checkBalance();
                System.out.println("------------------------------------------------");
            }
            else {
                System.out.println("Thank you for your Services");
                break;
            }
        }
    }
}
