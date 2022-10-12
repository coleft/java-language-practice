package inheri;

public class MathEx {
	
	double a;
	double b;
	
	public MathEx() {
		a = 10.7;
		b = 2.59;
	}
	
	public void test1() {	//Math.ceil()
		System.out.println(Math.ceil(a*b));
	}
	public void test2() {	//Math.floor()
		System.out.println(Math.floor(a*b));
	}
	public void test3() {		//1~45
		int r = (int)(Math.random()*45)+1;
		System.out.println(r);
	}
	public void test4() {		//Math.round
		System.out.println(Math.round(a*b));
	}
	
	public static void main(String[] args) {
		MathEx me = new MathEx();
		me.test1();
		me.test2();
		me.test3();
		me.test4();
	}
}
