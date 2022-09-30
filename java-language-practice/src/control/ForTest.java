package control;
import java.util.Scanner;

public class ForTest {
		
	Scanner in = new Scanner(System.in);
	int su1;
	int su2;
	int su3;
	int su4;
	
	public ForTest() {
		su1 = in.nextInt();
		su2 = in.nextInt();
		su3 = in.nextInt();
		su4 = in.nextInt();
	}	
	
	/* 파라미터로 전달된 정수까지 1부터 출력 */
	public void test1() {
		for(int i = 0; i<su1; i++) {
			System.out.println(i+1);
		}
		System.out.println(" ");
	}
	
	/* 1부터 파라미터로 전달된 정수까지의 홀수의 합 */
	public void test2() {
		int a2 = 0;
		for(int i = 1; i<=su2; i++) {
			if(i%2==1) {
				a2 += i;
			}
		}
		System.out.println(a2 + "\n");
	}
	
	/* 파라미터로 전달된 수에 해당하는 구구단 출력 */
	public void test3() {
		for(int i = 2; i<=9; i++) {
			System.out.println(su3 + " * " + i + " = " +su2*i);
		}
		System.out.println(" ");
	}
	
	/* 1부터 파라미터로 전달된 n까지의 합계가 1500이상이 되는 시점의 값과 합계 출력 */
	public void test4() {
		int tot = 0;
		for(int i = 0; ;i++) {			
			tot += i+1;
			if(tot>=1500) {
				System.out.println(i+1);
				break;
			}
		}		
		System.out.println(tot);
	}
	
	public static void main(String[] args) {
		ForTest fine = new ForTest();
		System.out.println(" ");
		fine.test1();
		fine.test2();
		fine.test3();
		fine.test4();
	}	
}
