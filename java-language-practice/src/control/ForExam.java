package control;

public class ForExam {

	//x,y 사이 의 소수
	public void test1(int x,int y) {		
		boolean isPrime = true;		
		if(x == 1) {
			x += 1;
		}
		else if (x == 0) {
			x += 2;
		}			
		for(int i = x; i <= y; i++) {
			for(int j = 2; j*j <= i; j++) {
				if( i%j == 0 ) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				System.out.println(i);
			}
			isPrime = true;
		}
		System.out.println("\n");
	}
	
	//x=3일때
	public void test2(int x) {
		for(int i = 0; i<2*x-1; i++) {
			for(int j = 0; j>=-Math.abs(1+i-x); j--) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	
	//x,y,z매개로 전달받아 x~y중 z배수의 값 출력
	public void test3(int x, int y, int z) {
		for(int i = 1;i<=y/3;i++ ) {
			if(z*i<x || z*i>y) {
				System.out.print("");
			}else {
				System.out.println(z*i);
			}
		}
		System.out.print("\n");
	}
	
	//x,y를 매개로 전달 12345/2345/345/45/5
	public void test4(int x, int y) {
		for(int i=0;i<y;i++) {
			for(int j=i+1;j<y+1;j++) {
				System.out.print(j);
			}
		System.out.print("\n");
		}
		
	}
	
	public static void main(String[] args) {
		ForExam exam = new ForExam();
		exam.test1(1, 100);
		exam.test2(3);
		exam.test3(10,102,3);
		exam.test4(1, 5);
	}
	
}
