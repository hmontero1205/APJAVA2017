package introUnit;

public class Freshman extends Student {
	
	private String favYouTuber;
	
	public Freshman(String name, String fYT) {
		super(name);
		this.favYouTuber = fYT;
	}
	
	public void talk(){
		super.talk();
		System.out.println("..and I am a freshman!");
		System.out.println("my favorite YouTuber is "+favYouTuber);
	}

}
