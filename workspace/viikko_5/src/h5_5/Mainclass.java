package h5_5;

import java.util.Scanner;

public class Mainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int menuSelection;
		int characterSelection;
		int weaponSelection;
		String[] characterInfo = new String[2];
		Character character = null;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*** BATTLE SIMULATOR ***");
		System.out.println("1) Create a character");
		System.out.println("2) Fight with a character");
		System.out.println("0) Quit");
		System.out.print("Your choice: ");
		menuSelection = scan.nextInt();
		
		
		while (menuSelection != 0) {
			switch (menuSelection){
			
			case 1:
				System.out.println("Choose your character: ");
				System.out.println("1) King");
				System.out.println("2) Knight");
				System.out.println("3) Queen");
				System.out.println("4) Troll");
				System.out.print("Your choice: ");
				characterSelection = scan.nextInt();
				
				System.out.println("Choose your weapon: ");
				System.out.println("1) Knife");
				System.out.println("2) Axe");
				System.out.println("3) Sword");
				System.out.println("4) Club");
				System.out.print("Your choice: ");
				weaponSelection = scan.nextInt();
			
				character = new Character(characterSelection, weaponSelection);
				break;
			case 2:
				characterInfo = character.getCharacter();
				System.out.print(characterInfo[0] + " fights with weapon " + characterInfo[1] + "\n");
				break;
			default:
				break;
			
			}
			System.out.println("*** BATTLE SIMULATOR ***");
			System.out.println("1) Create a character");
			System.out.println("2) Fight with a character");
			System.out.println("0) Quit");
			System.out.print("Your choice: ");
			
			menuSelection = scan.nextInt();
		
		}
		scan.close();
	}

}
