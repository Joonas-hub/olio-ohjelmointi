package har2;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mainclass {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Give a name to the dog: ");
		String dogName = scan.nextLine();
		
		
		Dog dog1 = new Dog(dogName);
		//Dog dog2 = new Dog("Musti");
		
		System.out.println("Hey, my name is " + dog1.getName());
		System.out.print("What does a dog say: ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try {
		String dogSay = br.readLine();
		dog1.speak(dogSay);
		}	
		catch(IOException ex) {
		}
		//System.out.println("Hey, my name is " + dog2.getName() + "!");
		
		//dog2.speak("Vuh!");**/
		
	}

}
