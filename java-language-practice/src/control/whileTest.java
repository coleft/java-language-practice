package control;

public class whileTest {
	//1~10까지 출력
	public void test1() {
		int a = 1;
		while(a < 11) {
			System.out.println(a);
			a ++;
		}
		System.out.println("\n");
	}
	//1~100 중 3, 5의 공배수 출력
	public void test2() {
		int a = 1;
		while(a<101) {
			if(a%3==0&&a%5==0) {
				System.out.println(a);
			}			
			a ++;
		}
		System.out.println("\n");
	}	
	//1~10을 1씩 증가시키며 홀수이면 continue, 짝수이면 출력
	public void test3() {
		int a=0;
		while(a<10) {
			a++;
			if(a%2==1) {
				continue;
			}else if(a%2==0) {
				System.out.println(a);
			}			
		}
		System.out.println("\n");
	}	
	//1~100까지 while을 반복 사용할 때 10 이상이면 break
	public void test4() {
		int a = 0;
		while(a<100) {
			a++;
			System.out.println(a);
			if(a>=10) {
				break;
			}
		}
		System.out.println("\n");
	}	
	
	public void test5() {			
		int a = 0;
		int i = 0;
		while(a<1000) {			
			i++;
			a += i;			
		}
		System.out.println(i);
		System.out.println(a);
		System.out.println("\n");
	}
	
	public void test6() {
		int i = 0;
		while(i<124) {
			i++;
			if(124%i==0) {
				System.out.println(i);
			}			
		}
		System.out.println("\n");
	}
	
	public void test7() {
		int x = 0;
		int y = 0;
		while(x>=0) {			
			x++;
			y = 2*x + 10;
			if(y>33) {
				break;
			}
			System.out.print(x + " ");
			System.out.println(y);				
		}
	}
		
	public static void main(String[] args) {
		whileTest wt = new whileTest();
		wt.test1();
		wt.test2();
		wt.test3();
		wt.test4();
		wt.test5();
		wt.test6();
		wt.test7();
	}
}
