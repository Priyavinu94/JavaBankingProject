package bankingProject;

public class ATM extends BankingRules implements StandardProcess {
	
	private double balance;
//	private String name;
	
	public ATM() {
		super();
		balance = person.getBalance();
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	@Override
	public void deposit(double depAmount) {
		if (depAmount > 0 && isTransactionAllowed()) {
			this.balance += depAmount;
		}
	}

	@Override
	public void withdraw(double withdrawAmount) {
		if (withdrawAmount > 0 && withdrawAmount <= balance && isWithdrawalAllowed(withdrawAmount)) {
			this.balance -= withdrawAmount;
		}
	}

	@Override
	public void fundTransfer(double transferAmount) {
		System.out.println("This functionality is available only in Online Banking or at any Branch");
	}

	@Override
	public void investment(double investAmount) {
		System.out.println("This functionality is available only in Online Banking or at any Branch");
	}

	@Override
	public boolean isUserValid(String cardNumber, String pinNo) {
		if (cardNumber.equals(person.getCardNumber()) && pinNo.equals(person.getPinNo())) {
			return true;
		}
		return false;
	}

}
