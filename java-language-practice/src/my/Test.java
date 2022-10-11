package my;

public class Test {
	public static void main(String[] args) {
		PrivateClass c = new PrivateClass();
		//c.score = 100;	//PrivateClass 파일에서 private이면 사용할 수 없음
		c.tot = 200;
		c.hap();
		//c.k(); //private이면 사용할 수 없음
	}
}
