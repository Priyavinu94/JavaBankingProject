package bankingProject;

public class ATM extends BankingRules implements StandardProcess {

	private double balance;

	public ATM() {
		super();
		balance = person.getBalance(); // setting the value of balance variable
	}

	public double getBalance() {
		return this.balance;
	}

	/**
	 * conditions to proceed with the deposit - Amount should be greater than 0,
	 * less than daily deposit limit and the current transaction should be within
	 * the maximum no of ATM transactions allowed
	 */
	@Override
	public void deposit(double depAmount) {
		if (depAmount > 0 && isDepositAllowed(depAmount) && isTransactionAllowed()) {
			this.balance += depAmount;
			System.out.println("You've successfully deposited $" + depAmount);
		}
	}
	
	/**
	 * conditions to proceed with withdrawal - Amount should be greater than 0 & less than account balance,
	 * withdrawal amount should be less than daily withdraw limit and the transaction no. limit 
	 */
	@Override
	public void withdraw(double withdrawAmount) {
		if (withdrawAmount > 0 && withdrawAmount <= balance && isWithdrawalAllowed(withdrawAmount)
				&& isTransactionAllowed()) {
			this.balance -= withdrawAmount;
			System.out.println("Please collect the cash withdrawn");
		}
	}
	
	// fund transfers between different accounts are not possible in ATM
	@Override
	public void fundTransfer(double transferAmount) {
		System.out.println("This functionality is available only in Online Banking or at any Branch");
	}

	@Override
	public void investment(double investAmount) {
		System.out.println("This functionality is available only in Online Banking or at any Branch");
	}
	
	// method to validate the user
	@Override
	public boolean isUserValid(String cardNumber, String pinNo) {
		if (cardNumber.equals(person.getCardNumber()) && pinNo.equals(person.getPinNo())) {
			return true;
		}
		return false;
	}

	/**
	 * Assuming the criteria for setting pinCode is the No of digits should be
	 * exactly 4 numbers
	 */
	@Override
	public boolean changeSecurityCode(String newPin) {
		if (newPin.length() == 4) {
			return true;
		}
		return false;
	}

}
