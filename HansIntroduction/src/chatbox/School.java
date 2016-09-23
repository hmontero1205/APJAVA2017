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

}
