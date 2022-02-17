package bankingProject;

import java.util.Scanner;

public class BankingAppMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		BankingRules bank = null;	//Declaring abstract class reference variable
//		StandardProcess process = null;
		
		System.out.println("Welcome to Banking Application\n");
		System.out.println("Please select the service you want\n 1. ATM\n 2. Online Banking");
		String choice = sc.next();
		if (choice.equals("1")){
			bank = new ATM("3428990434689703", "3456");
//			System.out.println("Please provide your card number");
//			String cardNumber = sc.next();
//			System.out.println("Enter the 4 digit PIN");
//			String pinNumber = sc.next();
//			if (bank.isUserValid(cardNumber, pinNumber)) {
				
			
//			}
		}
		
		

	}

}
