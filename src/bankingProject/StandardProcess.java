package bankingProject;

public interface StandardProcess {
	
	void deposit(double amount);
	void withdraw(double amount);
	void fundTransfer(double amount);
	double investmentCalculator(double currValue, double rate, int noOfYrs);
	
}
