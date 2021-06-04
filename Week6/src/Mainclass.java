import java.util.Scanner;

public class Mainclass {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String choice = "";
		
		Bank bank = new Bank();
		
		while(true) {
			menu();
			System.out.print("Your choice: ");
			choice = scanner.nextLine();
			if (choice.equals("0")) {
				scanner.close();
				break;
			}
			
			switch(choice) {
			case "1":
				addRegularAccount(scanner, bank);
				break;
			case"2":
				addCreditAccount(scanner, bank);
				break;
			case "3":
				deposit(scanner, bank);
				break;
			case "4":
				withdraw(scanner, bank);
				break;
			case "5":
				removeAccount(scanner, bank);
				break;
			case "6":
				printAccount(scanner, bank);
				break;
			case "7":
				printall(bank);
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
		}
	}
	
	public static void addRegularAccount(Scanner scanner, Bank bank) {
		String number = "";
		int amount = 0;
		System.out.print("Give an account number: ");
		number = scanner.nextLine();
		System.out.print("Amount of money to deposit: ");
		amount = scanner.nextInt();
		scanner.nextLine();
		
		//System.out.println("Adding to bank: "+number +","+amount);
		//System.out.println("Account number: " + number);
		//System.out.println("Amount of money: " + amount);
		bank.addSavingsAccount(number, amount);
		System.out.println("Account created.");
	}
	
	public static void addCreditAccount(Scanner scanner, Bank bank) {
		String number = "";
		int amount = 0;
		int credit = 0;
		System.out.print("Give an account number: ");
		number = scanner.nextLine();
		System.out.print("Amount of money to deposit: ");
		amount = scanner.nextInt();
		//scanner.nextLine();
		System.out.print("Give a credit limit: ");
		credit = scanner.nextInt();
		scanner.nextLine();
		//System.out.println("Adding to bank: "+number +","+amount+","+credit);
		bank.addDebitAccount(number, amount, credit);
		System.out.println("Account created.");
	}
	
	public static void deposit(Scanner scanner, Bank bank) {
		String number = "";
		int amount = 0;
		System.out.print("Give an account number: ");
		number = scanner.nextLine();
		System.out.print("Amount of money to deposit: ");
		amount = scanner.nextInt();
		scanner.nextLine();
		//System.out.println("Depositing to the account: "+number +" the amount "+amount);
		bank.deposit(number, amount);
	}
	
	public static void withdraw(Scanner scanner, Bank bank) {
		String number = "";
		int amount = 0;
		System.out.print("Give an account number: ");
		number = scanner.nextLine();
		System.out.print("Amount of money to withdraw: ");
		amount = scanner.nextInt();
		scanner.nextLine();
		bank.withdraw(number, amount);
		//System.out.println("Withdrawing from the account: "+number + " the amount + amount");
		
	}
	public static void removeAccount(Scanner scanner, Bank bank) {
		String number = "";
		System.out.print("Give the account number of the account to delete: ");
		number = scanner.nextLine();
		bank.removeAccount(number);
		System.out.println("Account removed.");
		
	}
	public static void printAccount(Scanner scanner, Bank bank) {
		String number = "";
		System.out.print("Give the account number of the account to print information from: ");
		number = scanner.nextLine();
		bank.printAccount(number);
		//System.out.println("Account number: "+ number + " Amount of money: " + bank.search(number).getBalance());
	}
	
	public static void printall(Bank bank) {
		System.out.println("All accounts:");
		bank.printAll();
	}
	
	public static void menu() {
		String info = "\n" + 
				"*** BANK SYSTEM ***\n" + 
				"1) Add a regular account\n" + 
				"2) Add a credit account\n" + 
				"3) Deposit money\n" + 
				"4) Withdraw money\n" + 
				"5) Remove an account\n" + 
				"6) Print account information\n" + 
				"7) Print all accounts\n" + 
				"0) Quit" ; 
		System.out.println(info);				
	}

}
