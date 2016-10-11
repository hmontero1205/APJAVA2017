package chatbox;

import java.util.Scanner;

public class HansMain {
	static Scanner input;
	static String user;
	static boolean inLoop;
	static String response;
	static Topic school;
	static Topic like;
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
			if(findKeyword(response,"good", 0) >= 0)
				print("Good looks");
			else if(findKeyword(response,"school",0)>=0){
				inLoop = false;
				school.talk();
			}
			else if(findKeyword(response,"like",0) >=0){
				inLoop = false;
				like.talk();
			}
			else
				print("I don't understand?");
		}
	}

	public static int findKeyword(String searchString, String key, int startIndex) {
		//delete white space
		String phrase = searchString.trim();
		//to lower case
		phrase = phrase.toLowerCase();
		key = key.toLowerCase();
		
//		System.out.println("The phrase is "+phrase);
//		System.out.println("The key is "+key);
		int psn = phrase.indexOf(key);
//		System.out.println("The position found is "+psn);
		//keep looking for word until you find right context
		while(psn >= 0){
			//if phrase doesn't end with is word
			String before = " ";
			String after = " ";
			if(psn + key.length() < phrase.length()){
				after = phrase.substring(psn+key.length(),psn+key.length() +1).toLowerCase();
//				System.out.println("The character after "+key+ " is "+after);
			}
			if(psn>0){
				before = phrase.substring(psn-1,psn).toLowerCase();
//				System.out.println("The character before "+key+ " is "+before);
			}
			if(before.compareTo("a")<0 && after.compareTo("a") < 0){
//				System.out.println(key+" was found at "+psn);
				if(noNegations(phrase,psn)){
					return -1;
				}
				return psn;
			}
			//in case keyword not found, check rest of string	
			psn = phrase.indexOf(key,psn+1);
			//Goody Goode was a character in The Crucible. Goodbye Goody Goode
//			System.out.println(key+" not found. checking "+psn);
		}
		
		return -1;
	}

	private static boolean noNegations(String phrase, int index) {
		if(index-3>= 0 && phrase.substring(index-3,index).equals("no "))
			return true;
		else if(index-4>= 0 && phrase.substring(index-4,index).equals("not "))
			return true;
		else if(index-6>= 0 && phrase.substring(index-6,index).equals("never "))
			return true;	
		else if(index-4>= 0 && phrase.substring(index-4,index).equals("n't "))
			return true;
		else return false;
	}

	public static void promptInput() {
		print(user+", try inputting a string!");
		String userInput = input.nextLine();
		print("You typed: "+userInput);
		
	}

	public static void createTopics() {
		input = new Scanner(System.in);
		school = new School();
		like = new HansLike();
		
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
