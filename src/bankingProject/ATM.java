package bankingProject;

public class ATM extends BankingRules implements StandardProcess {
	
	private String cardNo;
	private String pinNo;
	private double balance;
	private String name;
		
	PersonAccount person = new PersonAccount(name);

//	public ATM() {
//		super();
//	}

	public ATM(String cardNo, String pinNo) {
		this.cardNo = cardNo;
		this.pinNo = pinNo;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	@Override
	public void deposit(double depAmount) {
		if (depAmount > 0 && isTransactionAllowed()) {
			balance += depAmount;
		}
	}

	@Override
	public void withdraw(double withdrawAmount) {
		if (withdrawAmount > 0 && withdrawAmount <= balance && isWithdrawalAllowed(withdrawAmount)) {
			balance -= withdrawAmount;
		}
	}

	@Override
	public void fundTransfer(double transferAmount) {
		System.out.println("This functionality is available only in Online Banking or at any Branch");
	}

	@Override
	public double investmentCalculator(double currValue, double rate, int noOfYears) {
		System.out.println("This functionality is available only in Online Banking or at any Branch");
		return 0;
	}

	@Override
	public boolean isUserValid(String cardNo, String pinNo) {
		if (cardNo.equals(this.cardNo) && pinNo.equals(this.pinNo)) {
			return true;
		}
		return false;
	}

}
