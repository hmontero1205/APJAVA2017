package array;

import java.util.Scanner;

public class LogIn {
	static Scanner input = new Scanner(System.in);
	
	public static String waitForEntry(){
		return input.nextLine();
	}
	
	private static String username = "test_user";
	private static String password = "test";
	
	public static void main(String[] args) {
		if(correctUser())
			askPassword();
		else
			System.out.println("Unknown user name. Please contact network adminstrator.");

	}

	public static void askPassword() {
		boolean inLoop = true;
		int remainingTries = 3;
		
		while(inLoop){
			System.out.println("Enter your password");
			String entry = waitForEntry();
			if(entry.equals(password)){
				System.out.println("You're in!");
				inLoop = false;
			}
			else{
				remainingTries--;
				if(remainingTries ==0){
					System.out.println("Invalid password.");
					inLoop = false;
				}
				else{
					System.out.println("Incorrect password. You now have "+remainingTries+" attempts left");					
				}
			}
		}
		
	}

	public static boolean correctUser() {
		System.out.println("Enter username");
		return waitForEntry().equals(username);
	}
}
