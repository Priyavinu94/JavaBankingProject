/* Assuming Banking rules class implements StandardProcess Interface
 * Need not implement interface methods, as this is an abstract class
 * This allows implementing interface methods using reference type BankingRules
 */
package bankingProject;

public abstract class BankingRules implements StandardProcess {

	private double dailyWithdrawalLimit, totalAmountWithdrawn;
	private double dailyDepositLimit, totalDepositsMade;
	private int noOfTransactionsPerDay, transactionsProcessed;
	private double dailyTransferLimit, amountTransferred;

	PersonAccount person = new PersonAccount(); // instantiating PersonAccount class

	BankingRules() { // initializes the variables
		this.dailyWithdrawalLimit = 500.0; // daily withdrawal limit allowed
		this.dailyDepositLimit = 10000.0; // daily deposit limit allowed
		this.noOfTransactionsPerDay = 2; // maximum no of atm transactions that can be made per day
		this.dailyTransferLimit = 3000.0; // daily Online transfer limit
		this.totalDepositsMade = 2425.50; // variable stores total deposit made on current date
		this.totalAmountWithdrawn = 50.0; // variable stores total amount withdrawn on current date
		this.transactionsProcessed = 1; // variable stores the total no of transactions processed on current date
		this.amountTransferred = 0; // variable stores the total amount transferred online on current date
	}

	/**
	 * This method will determine if a withdrawal is allowed based on daily
	 * withdrawal limit
	 */
	public boolean isWithdrawalAllowed(double amountToWithdraw) {
		if (totalAmountWithdrawn < dailyWithdrawalLimit) {
			if (amountToWithdraw <= (dailyWithdrawalLimit - totalAmountWithdrawn)) {
				totalAmountWithdrawn += amountToWithdraw;
				return true;
			} else {
				System.out.println(
						"You can only withdraw upto $" + (dailyWithdrawalLimit - totalAmountWithdrawn) + " today");
				return false;
			}
		}
		System.out.println("You have already reached your daily withdrawal limit");
		return false;
	}

	/**
	 * this method will determine if a deposit is allowed based on daily deposit
	 * limit
	 */
	public boolean isDepositAllowed(double amountToDeposit) {
		if (totalDepositsMade < dailyDepositLimit) {
			if (amountToDeposit <= (dailyDepositLimit - totalDepositsMade)) {
				totalDepositsMade += amountToDeposit;
				return true;
			} else {
				System.out.println("You can only deposit upto $" + (dailyDepositLimit - totalDepositsMade) + " today");
				return false;
			}
		}
		System.out.println("You have already reached your daily deposit limit");
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
	 * this method will determine if an online transfer is allowed based on daily
	 * transfer limit
	 */
	public boolean isTransferAllowed(double amountToTransfer) {
		if (amountToTransfer < dailyTransferLimit) {
			if (amountToTransfer <= (dailyTransferLimit - amountTransferred)) {
				amountTransferred += amountToTransfer;
				return true;
			} else {
				System.out
						.println("You can only transfer upto $" + (dailyTransferLimit - amountTransferred) + " today");
				return false;
			}
		}
		System.out.println("You have already transferred upto dailylimit");
		return false;
	}

	// abstract methods which needs to be implemented in subclasses
	public abstract boolean isUserValid(String userID, String securityCode);

	public abstract boolean changeSecurityCode(String newCode);

	public abstract double getBalance();

}
