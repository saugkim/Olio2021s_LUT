import java.util.Scanner;

public class Mainclass {

	public static boolean isCar = false;
	
	public static void main(String[] args) {
	
		if (isCar) {
			Car car = new Car();
			car.print();
		}
		
		Scanner scanner = new Scanner(System.in);
		String choice;
		String character="";
		String weapon="";
		
		while(true) {
			mainMenu();
			System.out.print("Your choice: ");
			choice = scanner.nextLine();
			if (choice.equals("0")) {
				break;
			}
			
			switch(choice) {
			case "1":
				characterMenu();
				System.out.print("Your choice: ");
				character = scanner.nextLine();
				weaponMenu();
				System.out.print("Your choice: ");
				weapon = scanner.nextLine();
				createCreature(character, weapon);
				break;
			case "2":
				fightWithCharacter(character, weapon);
				break;
			default:
				mainMenu();
				break;
			}		
		}
	
	}
	
	public static void createCreature(String creature, String weapon) {
		Character character = new Character();
		character.weapon = new WeaponBehavior();
	}
	
	public static void fightWithCharacter(String creature, String wp) {
		String character ="";
		String weapon = "";
		
		switch(creature){
		case "1":
			character = "King";
			break;
		case "2":
			character = "Knight";
			break;
		case "3":
			character = "Queen";
			break;
		case "4":
			character = "Troll";
			break;
		default:
			character= "";
			break;
		}
		
		switch(wp) {
		case "1":
			weapon = "knife";
			break;
		case "2":
			weapon = "Axe";
			break;
		case "3":
			weapon = "Sword";
			break;
		case "4":
			weapon = "Club";
			break;
		default:
			weapon = "none";
			break;
		}
			
		
		System.out.println(character+" fights with weapon "+ weapon);
	}
	
	public static void mainMenu() {
		String info = "*** BATTLE SIMULATOR ***\n" + 
				"1) Create a character\n" + 
				"2) Fight with a character\n" + 
				"0) Quit" ;
				
		System.out.println(info);
	}
	
	public static void characterMenu() {
		String info="Choose your character: \n" + 
				"1) King\n" + 
				"2) Knight\n" + 
				"3) Queen\n" + 
				"4) Troll";
		
		
		System.out.println(info);
	}
	
	public static void weaponMenu() {
		String info = "Choose your weapon: \n" + 
				"1) Knife\n" + 
				"2) Axe\n" + 
				"3) Sword\n" + 
				"4) Club";
		
		System.out.println(info);
	}

}
