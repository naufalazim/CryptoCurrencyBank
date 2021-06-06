
public class Account {

	
	private String accountNumber;
	private String accountHolder;
	private String Date;
	private double balance;
	
	
	public Account(String akaunNo, String akaunHolder, String date, double baki) {
		super();
		accountNumber = akaunNo;
		accountHolder = akaunHolder;
		Date = date;
		balance = baki;
	}
	
	//=================System deposit:========================
	
	public void deposit(double amount) {
		
		balance = balance + amount;
	}
	
	
	//================ System Withdraw duit:================
	
	public void withdraw(double amount) {
		
		balance = balance - amount;
		
	}
	

	//=================System Transfer=========================
	
	public void transfer(Account a, double amount) {
		
		withdraw(amount);
		a.deposit(amount);
	}
	
	
	
	//Decode Account Number using toString:
	@Override
	public String toString() {
		return accountNumber;
	}
	
	
	//Panggil private variable using getMethod:
	
	//accountHolder:
	public String getAccountHolder() {
		return accountHolder;
	}
	
	//Date:
	public String getoDate() {
		return Date;
	}
	
	//balance:
	public String Balance() {
		return  "RM " +balance;
	}
	
	
	

}