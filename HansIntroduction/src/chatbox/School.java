package chatbox;

public class School implements Topic {

	private boolean inSchoolLoop;
	private String schoolResponse;
	
	public void talk() {
		inSchoolLoop = true;
		while(inSchoolLoop){
			HansMain.print("Tell me about school ;)");
			schoolResponse = HansMain.getInput();
			if(schoolResponse.indexOf("stop") >=0){
				inSchoolLoop = false;
				HansMain.talkForever();
			}
			else	
				HansMain.print("That's my favorite part too!");
		}

	}

	public boolean isTriggered(String userInput) {
		String[] triggers = {"school","class","teacher"};
		//use for loop to iterate thru array
		if (HansMain.findKeyword(userInput, "school", 0)>=0)
			return true;
		if (HansMain.findKeyword(userInput, "class", 0)>=0)
			return true;
		
		return false;
	}

}
