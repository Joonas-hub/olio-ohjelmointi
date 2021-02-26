package har2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Dog {
	private String name;
	//private String say;
	public Dog(String n) {
		if (n.isEmpty()) {
			name = "Doge";
		}
		else {
			name = n.trim();
		}
		
	}
	public String getName() {
		return name;
	}
	
	public void speak(String s) {
		String say;

		if (s.isEmpty()) {
			say = "Much wow!";
			System.out.println(name + ": " + say);
			
			Scanner scan = new Scanner(System.in);
			System.out.print("What does the dog say: ");
			say = scan.nextLine();
			speak(say);
		}
		else {
			//say = s.trim();
			Scanner scan = new Scanner(s);
			while (scan.hasNext()) {
				if (scan.hasNextInt()) {
					System.out.println("Such integer: " + scan.next());
				}
				else if (scan.hasNextBoolean()) {
					System.out.println("Such boolean: " + scan.next());
				}
				else {
					System.out.println(scan.next());
				}
			}
			//System.out.println(name + ": " + say);
		}
		
		
	}
}
