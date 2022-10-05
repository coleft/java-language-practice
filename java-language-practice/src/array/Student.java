package array;

public class Student {
	
	//필드값
	String name;
	int score;
	double weight;
	
	//생성자
	Student(String name, int score, double weight){
		this.name = name;	//필드값 = 매개변수 this가 없으면 로컬변수가 우선권을 갖게 된다. 
		this.score = score;
		this.weight = weight;
	}
	
	//메소드
	@Override
	public String toString() {
		String str = "name : " + this.name + "\n"
				   + "score : " + this.score +"\n"
				   + "weight : " + this.weight;
		return str;
	}
	
	
}
