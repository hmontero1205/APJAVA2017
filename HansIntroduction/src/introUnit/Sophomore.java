package introUnit;

public class Sophomore extends Student {

	private int coolPoints;
	
	public Sophomore(String name, int cPoints) {
		super(name);
		coolPoints = cPoints;
		// TODO Auto-generated constructor stub
	}

	public void talk(){
		super.talk();
		System.out.println("...and I am a Sophomore.");
		System.out.println("I have "+coolPoints+" Cool Points!");
	}
}
