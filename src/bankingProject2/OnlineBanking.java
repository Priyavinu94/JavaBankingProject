package bankingProject2;

public class OnlineBanking extends BankingRules implements StandardProcess {

	double balance;

	public OnlineBanking() {
		super();
		this.balance = getAccountBalance(); // setting the value of balance variable
	}

	public double getBalance() {
		return balance;
	}
	
	// deposit() and withdraw() are not possible through Online Banking
	@Override
	public void deposit(double depAmount) {
		System.out.println("This feature is not available in Online Banking");
	}

	@Override
	public void withdraw(double withdrawAmount) {
		System.out.println("This feature is not available in Online Banking");
	}

	// Online transfer from person's account
	@Override
	public void fundTransfer(double transferAmount) {
		if (transferAmount > 0 && transferAmount <= balance) {
			balance -= transferAmount;
			System.out.println("Transferred $" + transferAmount + " from your account");
		}
	}

	// Assuming investment() does Online transfer into person's account
	@Override
	public void investment(double investmentAmount) {
		if (investmentAmount > 0) {
			balance += investmentAmount;
			System.out.println("Transferred $" + investmentAmount + " into your account");
		}
	}

	// method to validate the user
	@Override
	public boolean isUserValid(String cardNumber, String password) {
		if (cardNumber.equals(getCardNumber()) && password.equals(getLoginPassword())) {
			return true;
		}
		return false;
	}

	/**
	 * Assuming the criteria for setting password is the password length should be
	 * in b/w 8 and 16 (including) characters
	 */
	@Override
	public boolean changeSecurityCode(String newPasword) {
		if (newPasword.length() >= 8 && newPasword.length() <= 16) {
			return true;
		}
		return false;
	}

}
