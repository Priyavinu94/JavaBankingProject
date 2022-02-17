package bankingProject;

public class OnlineBanking extends BankingRules implements StandardProcess {
	
	private String userName;
	private String password;
	double balance;
	private String name;
	
	PersonAccount person = new PersonAccount(name);
	
    public OnlineBanking(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
    
	@Override
	public void deposit(double depAmount) {
		if (depAmount > 0) {
			balance += depAmount;
		}
	}

	@Override
	public void withdraw(double withdrawAmount) {
		if (withdrawAmount > 0 && withdrawAmount <= balance) {
			balance -= withdrawAmount;
		}
	}

	@Override
	public void fundTransfer(double transferAmount) {
		if (transferAmount > 0 && transferAmount <= balance) {
			balance -= transferAmount;
		}
	}

	@Override
	public double investmentCalculator(double currValue, double rate, int noOfYears) {
		if (currValue > 0 && noOfYears > 0) {
			for (int i = 1; i <= noOfYears; i++) {
				currValue *= (1 + rate);
			}
		}
		return currValue;
	}
	
	@Override
	public boolean isUserValid(String userID, String password) {
		if(userName.equals(this.userName) && password.equals(this.password)) {
			return true;
		}
		return false;
	}

}
