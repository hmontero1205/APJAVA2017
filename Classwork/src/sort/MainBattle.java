package sort;

public class MainBattle {

	public static void main(String[] args){
		Pokemon raticate  = new Pokemon("Raticate",26);
		Pokemon bulbasaur  = new Pokemon("Bulbasaur",26);
		
		raticate.iChooseYou();
		bulbasaur.iChooseYou();
		
		System.out.println("Raticate is preparing to use Super Fang!!!!1");
		
		raticate.attack(bulbasaur, new Attack(){
			
			@Override
			public void attack(Pokemon target) {
				System.out.println("Raticate used Super Fang!");
				int newHP = target.getHP()/2;
				target.setHP(newHP);
				
			}
		});
		
		bulbasaur.attack(raticate, new Attack(){
			public void attack(Pokemon target){
				System.out.println("Bulbasaur used Poison Powder!");
				target.setPoisoned(true);
			}
		});
		
		raticate.lapse();
		bulbasaur.lapse();
		
		printScore(raticate,bulbasaur);
		
	}
	
	public static void printScore(Pokemon p1, Pokemon p2){
		System.out.println(p1.getName()+" HP="+p1.getHP());
		System.out.println(p2.getName()+" HP="+p2.getHP());
		
	}

}
