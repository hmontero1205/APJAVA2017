package chatbox;

import java.util.Scanner;

public class HansMain {
	static Scanner input;
	static String user;
	static boolean inLoop;
	static String response;
	static Topic school;
	//static int lineCount;

	public static void main(String[] args) {
		createTopics();
		//lineCount = 0;
		//demonstrateStringMethods();
		//promptInput();
		promptName();
		talkForever();
		
	}
	
	private static void promptName() {
		print("Suh, dude. I am a board covered with semiconductors and other electronic components. What is your name?");
		user = input.nextLine();
		print("Cool beans. I will call you "+user+" until you terminate me.");
	}

	public static void talkForever(){
		inLoop = true;
		while(inLoop){
			//promptInput();
			print("Greetings, "+user+". How's it going?");
			response = getInput();
			if(response.indexOf("good")>=0)
				print("Good looks");
			else if(response.indexOf("school")>=0){
				inLoop = false;
				school.talk();
			}
			else
				print("I don't understand?");
		}
	}

	public static void promptInput() {
		print(user+", try inputting a string!");
		String userInput = input.nextLine();
		print("You typed: "+userInput);
		
	}

	public static void createTopics() {
		input = new Scanner(System.in);
		school = new School();
		
	}
	public static void print(String s){
		//create multiline string
		String printString = "";
		int cutOff = 35;
		//check if there are words to add
		//is length of s > 0?
		while(s.length() > 0){
			String currentLine = "";
			String nextWord = "";
			//while the currentLine and nextWord are less than cutoff,AND THERE ARE STILL WORDS TO ADD,
			//do the following loooooooop
			while(currentLine.length() + nextWord.length() <= cutOff && s.length() > 0){
				//add the next word to line
				currentLine += nextWord;
				//remove that word
				s = s.substring(nextWord.length());
				//get the next word
				int endOfWord = s.indexOf(" ");
				//check to see if this is the last word
				if(endOfWord == -1)
					endOfWord = s.length()-1;
				nextWord = s.substring(0,endOfWord+1);
			}
			printString += currentLine + "\n"; 
			
		}
		System.out.println(printString);
	}
	public static String getInput(){
		return input.nextLine();
	}
}
