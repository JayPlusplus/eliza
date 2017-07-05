package eliza2;

import java.util.Random;
import java.util.Scanner;

public class ElizaApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "";
		Eliza e = new Eliza();
		Random rand = new Random();
		System.out.print("Good day. What is your problem?");
		System.out.print("Enter your response here or Q to quit:");
		Scanner keyboard = new Scanner(System.in);
		input = keyboard.nextLine();
		input = input.toLowerCase();
			while(!input.equals("q")){
				System.out.println(e.response(input));
				System.out.print("Enter your response here or Q to quit: "); 
				input = keyboard.nextLine().toLowerCase();
				//e.response(input);
			}
	}

}
