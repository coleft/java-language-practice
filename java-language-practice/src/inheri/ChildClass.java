package inheri;

public class ChildClass extends SuperClass {
	ChildClass(){
		System.out.println(publicField);
		publicMethod();
		//this.까지 치면 SuperClass의 privateField나 privateMethod는 나오지 않아.		
	}
	public static void main(String[] args) {
		ChildClass cc = new ChildClass();
	}
}
