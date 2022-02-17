package bankingProject;

public class PersonAccount {
	
	private int bankAccountNo;
	String accountHolderName;
	private double totalBalance;
	String[] accountTypes = {"Chequing", "Saving"};
	double[] balanceIndividual = {7895.46, 4343.65};
	
	public PersonAccount(String accountHolderName) {
		this.accountHolderName = accountHolderName;
//		this.bankAccountNo = bankAccountNo;
	}
	
	public double getTotalBalance() {
		this.totalBalance = balanceIndividual[0] + balanceIndividual[1];
		return this.totalBalance;
	}
	
	public double getChequingBalance() {
		return balanceIndividual[0];
	}
	
	public double getSavingsBalance() {
		return balanceIndividual[1];
	}
	
	public int getAccountNum() {
		return bankAccountNo;
	}
}
