package games.Memory.ihm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleText {
	// The Scanner is in another class according to MVC Design Pattern
	private static Scanner sc = new Scanner(System.in); 

	/**
	 * @param text
	 * @return
	 */
	public static int readANumber(String text) {
		System.out.println(text);
		int number=-1;
		while(number==-1) {
			try {
				number = sc.nextInt();		
			}
			catch(InputMismatchException iME) {
				System.out.println("Problème de type !!! Nous souhaitons un nombre. Rééssayer: \n");
				sc.next();
			}
		}
		return number;
	}

	/**
	 * @param text
	 * @return
	 */
	public static String readAString(String text) {
		System.out.println(text);
		String word = sc.next();
		while(!Character.isLetter(word.charAt(0))) {
			System.out.println("Problème de type !!! Nous souhaitons un nom. Rééssayer:");
			word = sc.next();
		}
		return word;
	}

	public static void close() {
		sc.close();
	}

	public static void print(Object object) {
		System.out.println(object);
		sc.nextLine();
	}
	
	public static void pressEnter() {
		System.out.println("press Enter to continue...");
		sc.nextLine();	
	}
	
	public static boolean readABoolean(String string) {
		System.out.println(string+" y/Y n/N");
		String word = sc.next();		
		return word.equals("y")||word.equals("Y");
	}

}
