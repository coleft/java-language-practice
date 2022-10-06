package array;

import java.util.Arrays;

public class ObjectArraySort {
	
	public static void main(String[] args) {
		
		Data2[] a = new Data2[3];	//배열 객체 생성(인천 메모리 위치)
		a[0] = new Data2("kim", 90);//데이터 삽입(대구 메모리 위치)
		a[1] = new Data2("lee", 95);
		a[2] = new Data2("park", 65);
		
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
	}
}
