package bankingProject2;

import java.util.Scanner;

public class BankingAppMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		BankingRules bank = null; // Declaring abstract class reference variable
//		StandardProcess process = null; 

		int attemptsLeft = 3;

		System.out.println("Welcome to Banking Application\n");
		System.out.println("Please select the service you want\n 1. ATM\n 2. Online Banking"
				+ "\nEnter the number corresponding to each service to select");
		String choice = sc.next(); // takes user input to select the desired service

		switch (choice) {
		/*********** ATM *****************/
		case "1":
			bank = new ATM();
			while (attemptsLeft-- >= 0) {
				System.out.println("Please provide your card number");
				String cardNumber = sc.next();
				System.out.println("Enter the 4 digit PIN");
				String pinNumber = sc.next();
				if (bank.isUserValid(cardNumber, pinNumber)) {
					attemptsLeft = 3; // attempts left is set back to 3 once the user enters valid credentials
					System.out.println("Welcome " + bank.getName());
					do {
						System.out.println("Enter the number corresponding to the service you need to select");
						System.out.println("1. Deposit\n2. Withdraw\n3. Fund transfer"
								+ "\n4. Investment\n5. Account Info\n6. Change Security PIN");
						String option = sc.next();
						switch (option) {
						case "1":
							System.out.println("Enter the amount to be deposited");
							double amountToDeposit = sc.nextDouble();
							bank.deposit(amountToDeposit);
							System.out.println("Your current balance is : $" + bank.getBalance());
							break;
						case "2":
							System.out.println("Enter the amount you need to withdraw");
							double amountToWithdraw = sc.nextDouble();
							bank.withdraw(amountToWithdraw);
							System.out.println("Your current balance is : $" + bank.getBalance());
							break;
						case "3":
							bank.fundTransfer(0.0);
							break;
						case "4":
							bank.investment(0.0);
							break;
						case "5":
							System.out.println("Your Account Number : " + bank.getAccountNum());
							System.out.println("Your current balance is : $" + bank.getBalance());
							break;
						case "6":
							System.out.println("Enter the new 4 digit PIN to update");
							String newPin = sc.next();
							if (bank.changeSecurityCode(newPin)) {
								bank.setPinNo(newPin);
								System.out.println("Successfully updated the PIN");
							} else {
								System.out.println("The new PIN entered does not meet the criteria");
							}
							break;
						default:
							System.out.println("Please make a valid selection");
						}
						System.out.println("Enter '1' to go back to Main Screen OR Press any other key to Exit");

					} while (sc.next().equals("1")); // User gets the ability to continue or exit

				} else {
					System.out.println("Invalid Card or PIN. Please try again.");
					if (attemptsLeft == 0) {
						System.out.println("You already had 3 failed login attempts. Account is locked");
					}
					continue;
				}

				System.out.println("Thank You! Have a great day!!");
				break;
			}
			break;

		/*********** Online Banking *****************/
		case "2":
			bank = new OnlineBanking();
			while (attemptsLeft-- >= 0) {
				System.out.println("Enter Card Number");
				String cardNumber = sc.next();
				System.out.println("Enter Online Banking Password");
				String password = sc.next();
				if (bank.isUserValid(cardNumber, password)) {
					attemptsLeft = 3;
					System.out.println("Welcome " + bank.getName());
					do {
						System.out.println("Please select the service you need");
						System.out.println("1. Deposit\n2. Withdraw\n3 .Fund transfer"
								+ "\n4. Investment\n5. CheckBalance\n6. Change Banking Password");
						String option = sc.next();
						switch (option) {
						case "1":
							bank.deposit(0.0);
							break;
						case "2":
							bank.withdraw(0.0);
							break;
						case "3":
							System.out.println("Enter the amount you need to transfer");
							double amountToTransfer = sc.nextDouble();
							bank.fundTransfer(amountToTransfer);
							System.out.println("Your current balance is : $" + bank.getBalance());
							break;
						case "4":
							System.out.println("Enter the amount to be transferred into the account");
							double amountToInvest = sc.nextDouble();
							bank.investment(amountToInvest);
							System.out.println("Your current balance is : $" + bank.getBalance());
							break;
						case "5":
							System.out.println("Your Account Number : " + bank.getAccountNum());
							System.out.println("Your current balance is : $" + bank.getBalance());
							break;
						case "6":
							System.out.println("Enter the new Online banking password to update");
							String newPassword = sc.next();
							if (bank.changeSecurityCode(newPassword)) {
								bank.setPinNo(newPassword);
								System.out.println("Successfully updated the Password");
							} else {
								System.out.println("The new Password entered does not meet the criteria");
							}
							break;
						default:
							System.out.println("Please make a valid selection");
						}
						System.out.println("Enter '1' to go back to Main Screen OR Press any other key to Exit");
					} while (sc.next().equals("1")); // User gets the ability to continue or exit

				} else {
					System.out.println("Invalid Card or Password. Please try again.");
					if (attemptsLeft == 0) {
						System.out.println("You already had 3 failed login attempts. Account is locked");
					}
					continue;
				}
				break;
			}
			break;

		default:
			System.out.println("Please make a valid selection");
		}
	}

}
