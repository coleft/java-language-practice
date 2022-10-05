package array;

import java.util.Arrays;
import java.util.Collections;

public class ArraySort {
	
	//오름차 정렬
	void test1() {
		int[] su = {3,4,3,2,4,76,7,87,56,54,3,3,2,11};
		System.out.println(Arrays.toString(su));
		Arrays.sort(su);
		System.out.println("정렬후......");//자바스크립트는 정렬하면 무조건 문자라서 숫자 정의를 해줬어야해 
		System.out.println(Arrays.toString(su));
	}
	
	//오름차순 큰거 5개만 마지막에
	void test2() {
		int[] su = {3,4,3,2,4,76,7,87,56,54,3,3,2,11};
		Arrays.sort(su,5,su.length);
		System.out.println(Arrays.toString(su));
	}
	
	//내림차 정렬
	void test3() {
		Integer[] su = {3,4,3,2,4,76,7,87,56,54,3,3,2,11};
		Arrays.sort(su,Collections.reverseOrder());
		System.out.println(Arrays.toString(su));
	}
	
	//배열에 저장된 수는 5의 배수개, 배열을 5개씩 잘라서 오름차 정렬후 출력하라
	void test4() {
		int[] su = {123,124,5,25,26,7,6,3,2,52,34,45,6,7,346423,1,2,34,1};
		int[] su1 = new int[5];
		int a = su.length%5;
		int b = su.length/5;
		int[] su2 = new int[a];
		for(int i=0; i<b; i++) {
			System.arraycopy(su, 5*i, su1, 0, 5);
			Arrays.sort(su1);
			System.out.println(Arrays.toString(su1));
		}
		System.arraycopy(su, 5*b, su2, 0, a);
		Arrays.sort(su2);
		System.out.println(Arrays.toString(su2));
	}
	
	void test44() {
		int[] su = {123,124,5,25,26,7,6,3,2,52,34,45,6,7,346423};
		int[] temp = new int[5];
		
		for(int i=0; i<su.length; i=i+5) {
			System.arraycopy(su, i, temp,  0, 5);
			Arrays.sort(temp);
			System.out.println(Arrays.toString(temp));
		}
	}
	
	public static void main(String[] args) {
		ArraySort as = new ArraySort();
		as.test44();		
	}
}