package control;

import java.util.Scanner;

public class IfTest {	
	Scanner in = new Scanner(System.in);	
	StringBuilder sb = new StringBuilder();
	StringBuilder sb2 = new StringBuilder();
	
	// 1. 점수
	int score = in.nextInt();
	
	// 2. 구매
	int price = in.nextInt();
	int ea = in.nextInt();
	int amount = price*ea;
	double tax = amount*0.1;
	double totAmount = amount+tax;
	
	public IfTest() {		//입력받은 score를 매개로 결과물이 갈린다.
		
		if(score >= 80) sb.append("합격");
		else if(score>=40) sb.append("대기");
		else sb.append("불합격");			
				
		if(totAmount>=1000) sb2.append("비행기");
		else if(totAmount>=500) sb2.append("자동차");
		else if(totAmount>=300) sb2.append("자전거");
		else sb2.append("화장지");		
	}	
	
	
	public void test1() {	//생성자의 결과물을 출력하는 "역량을 지닌" 메소드
		
		System.out.println("\n" + "[합불여부]");
		System.out.println(sb + "\n");
	}
	
	
	public void test2() {
		System.out.println("수량 : " + ea);
		System.out.println("가격 : " + price);
		System.out.println("세금 : " + tax);
		System.out.println("금액 : " + amount);
		System.out.println("총액 : " + totAmount);
		System.out.println("사은품 : " + sb2);
	}
	
	
	public static void main(String[] args) {	//실제로 출력한다.
		IfTest grade = new IfTest();
		grade.test1();		
		grade.test2();
	}
	
	
}
