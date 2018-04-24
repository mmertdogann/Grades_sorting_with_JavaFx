package mert;
public class Student {


	private String name;
	public int[] grades;
	
	
	public Student(String name,int[] grades){
		this.name=name;
		this.grades=grades;
		
	}
        public String getName(){
        return this.name;
        }
        
	
	public void setName(String input){
		this.name=input;
	}
	public String toString(){
		return String.format("Student name: %-10s \n"+"Student grades: %d %d %d \n", this.name,this.grades[0],this.grades[1],this.grades[2]);
	}

	public void setGrades(int[] grades2) {
		this.grades=grades2;		
	}
}
