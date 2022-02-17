package bankingProject;

import java.util.Scanner;

public class BankingAppMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		BankingRules bank = null; // Declaring abstract class reference variable
//		StandardProcess process = null; // Declaring interface reference variable

		int attemptsLeft = 3;

		System.out.println("Welcome to Banking Application\n");
		System.out.println("Please select the service you want\n 1. ATM\n 2. Online Banking");
		String choice = sc.next();

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
					attemptsLeft = 3;
					do {
						System.out.println("Welcome " + bank.person.accountHolderName);
						System.out.println("Please select the service you need");
						System.out.println(
								"1. Deposit\n2. Withdraw\n3 .Fund transfer" + "\n4. Investment\n5. CheckBalance");
						String option = sc.next();
						switch (option) {
						case "1":
							System.out.println("Enter the amount to be deposited");
							double amountToDeposit = sc.nextDouble();
							bank.deposit(amountToDeposit);
							break;
						case "2":
							System.out.println("Enter the amount you need to withdraw");
							double amountToWithdraw = sc.nextDouble();
							bank.withdraw(amountToWithdraw);
							break;
						case "3":
							bank.fundTransfer(0.0);
							break;
						case "4":
							bank.investment(0.0);
							break;
						case "5":
							System.out.println("Your current balance is : $" + bank.getBalance());
							break;
						default:
							System.out.println("Please make a valid selection");
						}
						System.out.println("Enter '1' to go back to Main Screen OR '0' to Exit");
					} while (sc.next().equals("1"));
				} else {
					System.out.println("Invalid Card or PIN. Please try again.");
					attemptsLeft--;
					continue;
				}
				System.out.println("Thank You! Have a great day!!");
				break;
			}
			System.out.println("You already had 3 failed login attempts. Account is locked");
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
					do {
						System.out.println("Welcome " + bank.person.accountHolderName);
						System.out.println("Please select the service you need");
						System.out.println("1. Deposit\n2. Withdraw\n3 .Fund transfer"
								+ "\n4. InvestmentCalculator\n5. CheckBalance");
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
							break;
						case "4":
							System.out.println("Enter the amount to be deposited");
							double amountToInvest = sc.nextDouble();
							bank.investment(amountToInvest);
							break;
						case "5":
							System.out.println("Your current balance is : $" + bank.getBalance());
							break;
						default:
							System.out.println("Please make a valid selection");
						}
						System.out.println("Enter '1' to go back to Main Screen OR '0' to Exit");
					} while (sc.next().equals("1"));
				} else {
					System.out.println("Invalid Card Number or Password. Please try again.");
					attemptsLeft--;
					continue;
				}
				System.out.println("Thank You! Have a great day!!");
				break;
			}
			System.out.println("You already had 3 failed login attempts. Account is locked");
			break;

		default:
			System.out.println("Please make a valid selection");
		}
	}

}
