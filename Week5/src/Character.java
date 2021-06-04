
public class Character {
	
	public WeaponBehavior weapon;
	
	public Character() {
		
	}
	
	public void fight() {
		System.out.println("do fight");
	}
}

/*
*** BATTLE SIMULATOR ***
1) Create a character
2) Fight with a character
0) Quit
Your choice: 1
Choose your character: 
1) King
2) Knight
3) Queen
4) Troll
Your choice: 1
Choose your weapon: 
1) Knife
2) Axe
3) Sword
4) Club
Your choice: 1
*** BATTLE SIMULATOR ***
1) Create a character
2) Fight with a character
0) Quit
Your choice: 2
King fights with weapon Knife
*** BATTLE SIMULATOR ***
1) Create a character
2) Fight with a character
0) Quit
Your choice: 1
Choose your character: 
1) King
2) Knight
3) Queen
4) Troll
Your choice: 3
Choose your weapon: 
1) Knife
2) Axe
3) Sword
4) Club
Your choice: 4
*** BATTLE SIMULATOR ***
1) Create a character
2) Fight with a character
0) Quit
Your choice: 1
Choose your character: 
1) King
2) Knight
3) Queen
4) Troll
Your choice: 2
Choose your weapon: 
1) Knife
2) Axe
3) Sword
4) Club
Your choice: 1
*** BATTLE SIMULATOR ***
1) Create a character
2) Fight with a character
0) Quit
Your choice: 2
Knight fights with weapon Knife
*** BATTLE SIMULATOR ***
1) Create a character
2) Fight with a character
0) Quit
Your choice: 0
 
 */


class WeaponBehavior {
	
	public WeaponBehavior() {
		
	}
	
	public void useWeapon() {
		System.out.println("use weapong");
	}
	
}
