package sort;

public class Pokemon {
	
	private int level;
	private int hp;
	private String name;
	boolean poisoned;
	
	public Pokemon(String n, int l) {
		level = l;
		name = n;
		hp = 100;
		poisoned = false;
	}
	
	public void iChooseYou(){
		System.out.println(name);
		System.out.println(name);
	}
	
	public int getHP(){
		return hp;
	}
	
	public String getName(){
		return name;
	}
	
	public void setHP(int h){
		hp = h;
	}
	
	public void setVoid(boolean b){
		poisoned = b;
	}
	
	public void lapse(){
		if(poisoned)
			hp-=15;
	}
	
	 public void attack(Pokemon target, Attack attack){
		 if(Math.random() < .9){
			 attack.attack(target);
			 System.out.println("The attack hit");
		 }
		 else{
			 System.out.println("The attack missed");
		 }
	 }
	

}
