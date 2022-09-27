package begin;
//Class 밖에는 package와 import 그리고 주석밖에 쓸 수 없다.
public class A {
	
	public static void main(String[] args) {	// String[] / args : 문자열 유형(not 그냥 문자) []:배열 / 파라미터 arguments 매개변수 / main :  시작합니다
		
		System.out.println("강은성");
		System.out.println("봉천동");
		System.out.println(10+10 + "\n");
		
		/* 논리형 */
		boolean b1 = false;
		boolean b2 = 10>20;
		System.out.println("b1=" + b1);
		System.out.println("b2=" + b2 + "\n");		
		
		/* 문자형 */
		char c1 = '1';
		c1 += 1;
		System.out.println("c1=" + c1);
		
		/* long */
		long l1 = 10L;
		System.out.println(l1);
		
		/* 실수형 */
		float f1 = 3.14F;
		System.out.println(f1 + "\n");
		
		/* 정수형 연산 정수형은 정수형 */
		System.out.println(10/4);
		System.out.println(10/(double)4);
		System.out.println((double)10/4);
		System.out.println(10.0/4);
		System.out.println(10/4.0);
		
		
	}
}
