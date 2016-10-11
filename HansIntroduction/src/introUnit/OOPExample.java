/**
 * 
 */
package introUnit;

/**
 * @author Student 6
 * This class is designed to contrast with the procedural example! It embodies
 * an Object-Orientated approach!
 */
public class OOPExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student jillian = new Senior("Jillian","programmer");
		Student jordan = new Freshman("Jordan","Pewdiepie");
		Student jason = new Sophomore("Jason",69);
		jillian.talk();
		//jillian.name = "BoogerNose";
		//jillian.talk();
		
		
		jordan.talk();
		jason.talk();

	}

}
