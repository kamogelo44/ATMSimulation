/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ATMsimulation;
import java.util.Scanner;
/**
 *
 * @author Obakeng Phale
 */
public class ATMSimulation {
    //Hardcoded values for balance and pin
    double balance = 44000;
    final int PIN = 3252;
    //Methods
    public void checkBalance() {
        System.out.println("Your balance is: " + balance);
    }
    
    public void deposit(double depositAmount) {
        balance = balance + depositAmount;
        System.out.println("Your new Balance is: " + balance);
    }
    
    public void withdraw(double withdrawalAmount) {
        balance = balance - withdrawalAmount;
        System.out.println("Your new Balance is: " + balance);
    }
    
    public static void main(String[] args) {
        try( Scanner input = new Scanner(System.in)) {
            //Instance of ATMSimulation
            ATMSimulation newATM = new ATMSimulation();
            int authPIN = newATM.PIN;
            
            System.out.println("********** WELCOME TO ATM ***********");
            System.out.println("  Secure Banking Made Simple");
            System.out.println("Please have your User ID and PIN ready");
            System.out.println("**************************************");
            System.out.println(); // Empty line for spacing
        
            System.out.print("Enter Your ID: ");
            //Prompt user for input
            System.out.print("Enter Your ID: ");
            long userID = input.nextLong();
            System.out.print("Enter Your PIN: ");
            int userPIN = input.nextInt();
            input.nextLine();
            
            //Validation
            if(userPIN != authPIN) {
                System.out.println("Incorrect PIN!");
            } else {
                System.out.println("Welcome User: " + userID);
                System.out.println("What would you like to do? BALANCE, DEPOSIT, WITHDRAW OR EXIT");
                
                OUTER:
                while (true) {
                    String userChoice = input.nextLine().toUpperCase();
                    
                    switch (userChoice) {
                        case "BALANCE":
                            newATM.checkBalance();
                            break;
                        case "DEPOSIT":
                            System.out.print("Enter your Deposit Amount: ");
                            double depositAmount = input.nextDouble();
                            input.nextLine(); 
                            newATM.deposit(depositAmount);
                            break;
                        case "WITHDRAW":
                            System.out.print("Enter Withdrawal Amount: ");
                            double withdrawAmount = input.nextDouble();
                            input.nextLine(); 
                            newATM.withdraw(withdrawAmount);
                            break;
                        case "EXIT":
                            break OUTER;
                        default:
                            System.out.println("Invalid option! Choose: BALANCE, DEPOSIT, WITHDRAW or EXIT");
                            break;
                    }
                    System.out.println("\nWhat would you like to do next?");
                }
            }
        } 
    }
}