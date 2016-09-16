package introUnit;

public class Student {
	private String name;
	
	//constructor..creates students
	public Student(String name){
		//initialize fields
		this.name = name;
	}
	
	public void talk(){
		System.out.println("Hi, my name is "+name+"!");
	}
}
