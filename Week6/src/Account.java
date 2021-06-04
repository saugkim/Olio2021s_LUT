
public abstract class Account {
	
	String account_number;
	int current_amount;
	
	public Account(String acc, int amount) {
		this.account_number = acc;
		this.current_amount = amount;
	}
	
	abstract void deposit(int amount);
	abstract void withdraw(int amount);
	abstract void print();
	
}


class Savings extends Account {
	
	public Savings(String acc, int amount) {
		super(acc, amount);
		// TODO Auto-generated constructor stub
	}
	
	public void deposit(int amount) {
		this.current_amount += amount;
	}
	
	public void withdraw(int amount) {
		if (this.current_amount - amount >= 0)
			this.current_amount -= amount;
	}
	
	public void print() {
		System.out.println("Account number: " + this.account_number + " Amount of money: " + this.current_amount);
	}
}


class Debit extends Account {
	int debit;
	
	public Debit(String acc, int amount, int credit) {
		super(acc, amount);
		this.debit = credit;
		// TODO Auto-generated constructor stub
	}
	
	public void deposit(int amount) {
		this.current_amount += amount;
	}
	
	public void withdraw(int amount) {
		if (this.current_amount - amount + this.debit >= 0) 
			this.current_amount -= amount;
	}
	
	public void print() {
		System.out.println("Account number: " + this.account_number + " Amount of money: " + this.current_amount + " Credit limit: " + this.debit);
	}
}
