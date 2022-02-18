package bankingProject;

public interface StandardProcess {

	void deposit(double amount);

	void withdraw(double amount);

	void fundTransfer(double amount);

	void investment(double amount); // assuming investment() processes the transactions into the person's account
									// (investments)

}
