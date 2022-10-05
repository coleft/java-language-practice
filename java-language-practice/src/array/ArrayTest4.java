package array;

import java.util.Arrays;

public class ArrayTest4 {	
	public ArrayTest4() {
		int[][] score = {{1,2,3,10},{4,5,6},{7,8,9},{3,4,2,1,3}};
		tot(score);
		//prn(score);	//매개변수 전달
		//prn(score[2]);
		//prn(score[2][2]);		
		for(int r = 0; r<score.length; r++) {
			hap(score[r]);
		}
	}
	
	void hap(int[] s) {
		int sum=0;
		double avg=0;
		for(int c= 0; c<s.length; c++) {
			sum += s[c];
		}
		avg = sum/(double)s.length;
		System.out.println("합계 = " + sum);
		System.out.println("평균 = " + avg);
		System.out.println("-".repeat(20));
	}
	
	public void tot(int[][] s) {
		int sum = 0;
		double avg = 0;
		int cnt = 0;
		for(int r =0; r<s.length; r++) {
			for(int c = 0; c<s[r].length; c++) {
				sum += s[r][c];
				cnt++;
			}
		}
		avg = sum/((double)cnt);
		System.out.println(sum);
		System.out.println(avg);
	}
	
	
	public void prn(int[][] s) {
		System.out.println("2차원 배열 전체 출력");
		for(int a = 0; a<s.length; a++) {
			System.out.println(Arrays.toString(s[a]));
		}
	}
	
	public void prn(int[] s) {
		System.out.println("1차원 배열 전체 출력");
		System.out.println(Arrays.toString(s));
	}
	
	public void prn(int s) {
		System.out.println("정수값 출력 : "+ s);
	}
	
	public static void main(String[] args) {
		ArrayTest4 at = new ArrayTest4();
		
	}	
}


