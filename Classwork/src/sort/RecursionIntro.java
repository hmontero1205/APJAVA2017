package sort;

public class RecursionIntro {

	public static void main(String[] args){
//		//with a for loop
//		System.out.println("Using a for loop..");
//		for(int i=0;i<5;i++){
//			System.out.println("wuz poppin");
//		}
//		
//		System.out.println("Using recursion......");
//		int numberOfTimes = 5;
//		forLoop(numberOfTimes, new Action(){
//			
//			public void act(){
//				System.out.println("wuzz poppin");
//			}
//		});
//	}
//
//	public static void forLoop(int numberOfTimes, Action action) {
//		if(numberOfTimes<2){
//			action.act();
//		}
//		else{
//			action.act();
//			forLoop(numberOfTimes-1,action);
//		}
//		
		hanoi(3,"A","B","C");
		
	}
	public static void hanoi(int numberOfDiscs, String from, String mid, String to){
		if(numberOfDiscs<2){
			print("Move from "+from+" to "+to);
		}
		else{
			hanoi(numberOfDiscs-1,from,to,mid);
			hanoi(1,from,mid,to);
			hanoi(numberOfDiscs-1,mid,from,to);
		}
	}
	
	private static int moveCount = 1;
	public static void print(String string) {
		System.out.println("Move #:"+moveCount+" "+string);
		moveCount++;
		
	}
}
