package bankingProject3;

public class PersonAccount {

	private String accountHolderName;
	private String cardNumber;
	private String pinNo;
	private String loginPassword;
	private double accountBalance;
	private int bankAccountNo;

	private double totalAmountWithdrawn;
	private double totalDepositsMade;
	private int transactionsProcessed;
	private double amountTransferred;

	public PersonAccount() {

	}

	// to create list
	public PersonAccount(String accountHolderName, String cardNumber, String pinNo, String loginPassword,
			int bankAccountNo, double accountBalance, double totalAmountWithdrawn, double totalDepositsMade,
			int transactionsProcessed, double amountTransferred) {
		super();
		this.accountHolderName = accountHolderName;
		this.cardNumber = cardNumber;
		this.pinNo = pinNo;
		this.loginPassword = loginPassword;
		this.bankAccountNo = bankAccountNo;
		this.accountBalance = accountBalance;
		this.totalAmountWithdrawn = totalAmountWithdrawn;
		this.totalDepositsMade = totalDepositsMade;
		this.transactionsProcessed = transactionsProcessed;
		this.amountTransferred = amountTransferred;
	}

	public String getName() {
		return this.accountHolderName;
	}

	public String getCardNumber() {
		return this.cardNumber;
	}

	public String getPinNo() {
		return this.pinNo;
	}

	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
	}

	public String getLoginPassword() {
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public double getAccountBalance() {
		return this.accountBalance;
	}

	public double getTotalAmountWithdrawn() {
		return totalAmountWithdrawn;
	}

	public void setTotalAmountWithdrawn(double totalAmountWithdrawn) {
		this.totalAmountWithdrawn = totalAmountWithdrawn;
	}

	public double getTotalDepositsMade() {
		return totalDepositsMade;
	}

	public void setTotalDepositsMade(double totalDepositsMade) {
		this.totalDepositsMade = totalDepositsMade;
	}

	public int getTransactionsProcessed() {
		return transactionsProcessed;
	}

	public void setTransactionsProcessed(int transactionsProcessed) {
		this.transactionsProcessed = transactionsProcessed;
	}

	public double getAmountTransferred() {
		return amountTransferred;
	}

	public void setAmountTransferred(double amountTransferred) {
		this.amountTransferred = amountTransferred;
	}

	public String toString() {
		return "Your Account Number : " + bankAccountNo + "\nYour Current Balance : " + accountBalance;
	}

}
