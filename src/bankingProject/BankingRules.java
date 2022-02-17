package bankingProject;

public abstract class BankingRules {

	private double dailyWithdrawalLimit;
	private int noOfTransactionsPerDay;
	private double amountWithdrawn; // variable stores total amount withdrawn on current date
	private int transactionsProcessed; // variable stores the total no of transactions processed on current date

	BankingRules() { // initializes the variables
		this.dailyWithdrawalLimit = 500.0;
		this.noOfTransactionsPerDay = 12;
		this.amountWithdrawn = 50.0;
		this.transactionsProcessed = 3;
	}

	/**
	 * this method will determine if a withdrawal is allowed based on daily
	 * withdrawal limit
	 */
	public boolean isWithdrawalAllowed(double amountToWithdraw) {
		if (amountWithdrawn < dailyWithdrawalLimit) {
			if (amountToWithdraw <= (dailyWithdrawalLimit - amountWithdrawn)) {
				amountWithdrawn += amountToWithdraw;
				return true;
			} else {
				System.out.println("You can only withdraw upto $" + (dailyWithdrawalLimit - amountWithdrawn) + " today");
				return false;
			}
		}
		System.out.println("You have already withdrawn upto dailylimit");
		return false;
	}

	/**
	 * this method will determine if a transaction is allowed based on the no of
	 * transactions allowed per day
	 */
	public boolean isTransactionAllowed() {
		if (transactionsProcessed < noOfTransactionsPerDay) {
			transactionsProcessed++;
			return true;
		}
		System.out.println("Oops!! Already did maximum number of transactions allowed today.");
		return false;
	}

	/**
	 * this method will determine if a Pin number to be updated, entered by a user
	 * is valid or not
	 */
	public boolean pinChange(String newPin) {
		if (newPin.length() == 4) {
			return true;
		}
		return false;
	}

	public abstract boolean isUserValid(String userID, String securityCode); // needs to be implemented in subclasses

}
