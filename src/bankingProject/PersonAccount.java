package bankingProject;

public class PersonAccount {
	
	String accountHolderName;
	private String cardNumber;
	private String pinNo;
	private String loginPassword;
	private double accountBalance;
	private int bankAccountNo;
	
	public PersonAccount() {
		this.accountHolderName = "Divya";
		this.bankAccountNo = 6423878;
		this.cardNumber = "4506476692349075";
		this.pinNo = "5432";
		this.loginPassword = "user1234";
		this.accountBalance = 15326.75;
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
	
	public double getBalance() {
		return this.accountBalance;
	}
	
	public int getAccountNum() {
		return this.bankAccountNo;
	}
}
