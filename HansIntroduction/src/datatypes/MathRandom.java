package datatypes;

import java.util.Random;

public class MathRandom {

	public static void main(String[] args) {
		int[] results = new int[6];
		int totalRolls = 10000;
		for(int index = 0; index < totalRolls; index++){
			int rollRes = rollUnfairDie();
			System.out.println("Roll #"+(index+1)+" Die is "+rollRes);
			results[rollRes-1]++;
		}
		for(int i = 0;i < results.length;i++){
			//System.out.println((i+1)+" was rolled "+results[i]+" times!!");
			System.out.println((i+1)+" was rolled "+(int)(((double)results[i]/totalRolls)*100)+"% of the time!!");
		}

	}
	
	public static int rollFairDie(){
//		Random gen = new Random();
//		return gen.nextInt(6)+1;
		double rand = Math.random();//random double between 0 and 1.
		int roll = (int) (6*rand);//[0,5]
		return roll+1;
		
	}
	
	public static int rollUnfairDie(){
		double rand2 = Math.random();
		int rollProb = (int) (6*rand2);
		//System.out.println(rollProb);
		if(rollProb <1)
			return (int)(3*Math.random())+1;
		else
			return (int)(3*Math.random())+4;
	}
}

