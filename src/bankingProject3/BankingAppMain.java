package bankingProject3;

import java.util.ArrayList;
import java.util.Scanner;

public class BankingAppMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		BankingRules bank = null; // Declaring abstract class reference variable

		ArrayList<PersonAccount> accountsList = new ArrayList<PersonAccount>();
		accountsList.add(new PersonAccount("Priya", "4506123467934324", "1234", "abcd1234", 5298609, 5217.45, 100.00, 0,
				1, 75.0));
		accountsList.add(new PersonAccount("Vinod", "4506347218933950", "2453", "sdab4526", 5298610, 34126.35, 0,
				300.00, 2, 250.00));
		accountsList.add(new PersonAccount("Hari", "4456897523839094", "5236", "hari5345", 2573684, 2253.42, 0.0, 0.0,
				0, 430.42));

		int attemptsLeft = 3;

		System.out.println("Welcome to Banking Application\n");
		System.out.println("Please select the service you want\n 1. ATM\n 2. Online Banking"
				+ "\nEnter the number corresponding to each service to select");
		String choice = sc.next(); // takes user input to select the desired service

		switch (choice) {
		/*********** ATM *****************/
		case "1":

			while (attemptsLeft-- >= 0) {
				System.out.println("Please provide your card number");
				String cardNumber = sc.next();
				// validating if the inserted card/ entered cardNumber is on the accounts list
				boolean isCardValid = false;
				for (PersonAccount account : accountsList) {
					if (accountsList.get(accountsList.indexOf(account)).getCardNumber().equals(cardNumber)) {
						if (accountsList.indexOf(account) == accountsList.size() - 1) {
							break;
						}
						bank = new ATM(account);
						isCardValid = true;
						break;
					}
				}
				if (!isCardValid) {
					System.out.println("The Card is not Valid. Data cannot be matched.");
					break;
				} else {
					System.out.println("Enter the 4 digit PIN");
					String pinNumber = sc.next();
					if (bank.isUserValid(cardNumber, pinNumber)) {
						attemptsLeft = 3; // attempts left is set back to 3 once the user enters valid credentials
						System.out.println("Welcome " + bank.getAccount().getName());
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
								System.out.println(bank.getAccount().toString());
								break;
							case "6":
								System.out.println("Enter the new 4 digit PIN to update");
								String newPin = sc.next();
								if (bank.changeSecurityCode(newPin)) {
									bank.getAccount().setPinNo(newPin);
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
						if (attemptsLeft == 0) {
							System.out.println("You already had 3 failed login attempts. Account is locked");
							break;
						}
						System.out.println("Invalid Card or PIN. Please try again.");
						continue;
					}
				}
				System.out.println("Thank You! Have a great day!!");
				break;
			}
			break;

		/*********** Online Banking *****************/
		case "2":

			while (attemptsLeft-- >= 0) {
				System.out.println("Enter Card Number(UserID)");
				String cardNumber = sc.next();
				System.out.println("Enter Online Banking Password");
				String password = sc.next();
				// validating if the entered cardNumber(userID) is on the accounts list
				boolean isUserIdValid = false;
				for (PersonAccount account : accountsList) {
					if (accountsList.get(accountsList.indexOf(account)).getCardNumber().equals(cardNumber)) {
						if (accountsList.indexOf(account) == accountsList.size() - 1) {
							break;
						}
						bank = new OnlineBanking(account);
						isUserIdValid = true;
						break;
					}
				}
				if (!isUserIdValid) {
					System.out.println("The User is not Valid. Data cannot be matched.");
					break;
				} else {
					if (bank.isUserValid(cardNumber, password)) {
						attemptsLeft = 3;
						System.out.println("Welcome " + bank.getAccount().getName());
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
								System.out.println(bank.getAccount().toString());
								break;
							case "6":
								System.out.println("Enter the new Online banking password to update");
								String newPassword = sc.next();
								if (bank.changeSecurityCode(newPassword)) {
									bank.getAccount().setPinNo(newPassword);
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
						if (attemptsLeft == 0) {
							System.out.println("You already had 3 failed login attempts. Account is locked");
							break;
						}
						System.out.println("Invalid Card or PIN. Please try again.");
						continue;
					}
				}
				System.out.println("Thank You! Have a great day!!");
				break;
			}
			break;

		default:
			System.out.println("Please make a valid selection");
		}

		sc.close();
	}

}