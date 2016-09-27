package chatbox;

public class HansLike implements Topic {

	private boolean inLikeLoop;
	private String likeResponse;
	public void talk() {
		HansMain.print("What are some things you like?");
		inLikeLoop = true;
		while(inLikeLoop){
			likeResponse = HansMain.getInput();
			int likePsn = HansMain.findKeyword(likeResponse,"like", 0);
			if(likePsn >=0){
				String thingsLiked = likeResponse.substring(likePsn+5);
				HansMain.print("Woah dude! You're so cool because you like "+thingsLiked);
				if(HansMain.findKeyword(thingsLiked, "school", 0) >=0){
					inLikeLoop = false;
					HansMain.school.talk();
				}
				else{
					inLikeLoop=false;
					HansMain.talkForever();
				}
			}
			else{
				HansMain.print("I don't understand?");
			}
		}
	}
	

}
