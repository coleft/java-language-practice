package array;

import java.util.Arrays;

public class ArrayCopy {
	
	public ArrayCopy() {
		
	}
	
	public void exam1() {
		int[] a = {1,2,3};
		int[] b = new int[3];
		for(int n = 0; n<3; n++) {
			b[n] = a[n];
		}
		System.out.println(Arrays.toString(b));
	}
	
	public void exam2() {
		int[] a = {1,2,3,4,5};
		int[] b = new int[5];
		System.arraycopy(a, 0, b, 0, 5);
		
		System.out.println(Arrays.toString(b));
	}
	
	public void exam3() {
		int[] a = {1,2,3,4,5};
		int[] b = a.clone();
		
		System.out.println(Arrays.toString(b));
	}
	
	public static void main(String[] args) {
		ArrayCopy ac = new ArrayCopy();
		ac.exam1();
		ac.exam2();
		ac.exam3();
	}	
}
