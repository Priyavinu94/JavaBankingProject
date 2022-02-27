/* Assuming Banking rules class implements StandardProcess Interface
 * Need not implement interface methods, as this is an abstract class
 * This allows implementing interface methods using reference type BankingRules
 */
package bankingProject3;

public abstract class BankingRules implements StandardProcess {

	private double dailyWithdrawalLimit;
	private double dailyDepositLimit;
	private int noOfTransactionsPerDay;
	private double dailyTransferLimit;
	private PersonAccount account;

	BankingRules(PersonAccount account) { // initializes the variables
		this.account = account;
		this.dailyWithdrawalLimit = 500.0; // daily withdrawal limit allowed
		this.dailyDepositLimit = 10000.0; // daily deposit limit allowed
		this.noOfTransactionsPerDay = 5; // maximum no of ATM transactions that can be made per day
		this.dailyTransferLimit = 3000.0; // daily Online transfer limit
	}

	public PersonAccount getAccount() {
		return account;
	}

	public void setAccount(PersonAccount account) {
		this.account = account;
	}

	/**
	 * This method will determine if a withdrawal is allowed based on daily
	 * withdrawal limit
	 */
	public boolean isWithdrawalAllowed(double amountToWithdraw) {
		if (account.getTotalAmountWithdrawn() < dailyWithdrawalLimit) {
			if (amountToWithdraw <= (dailyWithdrawalLimit - account.getTotalAmountWithdrawn())) {
				account.setTotalAmountWithdrawn(account.getTotalAmountWithdrawn() + amountToWithdraw);
				return true;
			} else {
				System.out.println("You can only withdraw upto $"
						+ (dailyWithdrawalLimit - account.getTotalAmountWithdrawn()) + " today");
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
		if (account.getTotalDepositsMade() < dailyDepositLimit) {
			if (amountToDeposit <= (dailyDepositLimit - account.getTotalDepositsMade())) {
				account.setTotalDepositsMade(account.getTotalDepositsMade() + amountToDeposit);
				return true;
			} else {
				System.out.println("You can only deposit upto $" + (dailyDepositLimit - account.getTotalDepositsMade())
						+ " today");
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
		if (account.getTransactionsProcessed() < noOfTransactionsPerDay) {
			account.setTransactionsProcessed(account.getTransactionsProcessed() + 1);
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
			if (amountToTransfer <= (dailyTransferLimit - account.getAmountTransferred())) {
				account.setAmountTransferred(account.getAmountTransferred() + amountToTransfer);
				return true;
			} else {
				System.out.println("You can only transfer upto $"
						+ (dailyTransferLimit - account.getAmountTransferred()) + " today");
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