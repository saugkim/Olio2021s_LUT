import java.util.ArrayList;

public class Bank {

	ArrayList<Account> accounts;
	
	public Bank() {
		this.accounts = new ArrayList<Account>();
	}
	
	public void addSavingsAccount(String acc_number, int amount) {
		Savings account = new Savings(acc_number, amount);
		accounts.add(account);
	}
	
	public void addDebitAccount(String acc_number, int amount, int debit) {
		Debit account = new Debit(acc_number, amount, debit);
		accounts.add(account);
	}
	
	public void deposit(String number, int amount) {
		Account acc = search(number);
		if (acc != null)
			acc.deposit(amount);
	}
	
	public void withdraw(String number, int amount) {
		Account acc = search(number);
		if (acc != null)
			acc.withdraw(amount);
	}
	
	public void removeAccount(String acc_number) {
		
		Account acc = search(acc_number);
		if (acc != null)
			this.accounts.remove(acc);
		
	}
	
	public Account search(String acc_number) {
		
		for (int i=0; i<accounts.size(); i++) {
			if (accounts.get(i).account_number.equals(acc_number)) {
				return accounts.get(i);
			}
		}
		
		return null;
	}
	
	public void printAccount(String acc_number) {
		Account acc = search(acc_number);
		if (acc != null)
			acc.print();
	}
	
	public void printAll() {
		for (int i=0; i<accounts.size(); i++) {
			accounts.get(i).print();
		}
	}

}

/*
abstract class Account {
	
	String account_number;
	int current_amount;
	
	public Account(String acc, int amount) {
		this.account_number = acc;
		this.current_amount = amount;
	}
	
	public int getBalance() {
		return this.current_amount;
	}
	abstract void deposit(int amount);
	abstract void withdraw(int amount);
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
}
*/