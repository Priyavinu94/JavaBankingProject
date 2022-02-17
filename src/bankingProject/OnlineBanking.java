package bankingProject;

public class OnlineBanking extends BankingRules implements StandardProcess {

	double balance;
//	private String name;

	public OnlineBanking() {
		super();
		this.balance =  person.getBalance();
	}
	
	public double getBalance() {
		return this.balance;
	}
	@Override
	public void deposit(double depAmount) {
		System.out.println("This feature is not available in Online Banking");
	}

	@Override
	public void withdraw(double withdrawAmount) {
		System.out.println("This feature is not available in Online Banking");
	}

	@Override
	public void fundTransfer(double transferAmount) {
		if (transferAmount > 0 && transferAmount <= balance) {
			balance -= transferAmount;
		}
	}

	@Override
	public void investment(double investmentAmount) {
		if (investmentAmount > 0) {
			balance += investmentAmount;
		}
	}

	@Override
	public boolean isUserValid(String cardNumber, String password) {
		if (cardNumber.equals(person.getCardNumber()) && password.equals(person.getLoginPassword())) {
			return true;
		}
		return false;
	}

}
