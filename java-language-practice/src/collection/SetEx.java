package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetEx {
	
	public void test1() {
		Set<String> hs = new HashSet<String>();
		//추가
		hs.add("kim");
		hs.add("hong");
		hs.add("park");
		hs.add("nam");
		//수정(remove > add)
		hs.remove("park");
		hs.add("gang");
		System.out.println(hs.toString());
		//조회(순차접근) Set -> Iterator -> hasNext, next
		Iterator<String> iter = hs.iterator();
		while(iter.hasNext()) {
			String s = iter.next();
			System.out.println(s);
		}
	}
	
	public void test2() {
		Integer[] a = {1,31,41,32,25,36,3,2,4,1,214};
		Integer[] b = {1,23,32,34,35,45,35,33,424};
		
		List<Integer> aa = new ArrayList<Integer>(Arrays.asList(a));
		List<Integer> bb = new ArrayList<Integer>(Arrays.asList(b));
		
		//합집합
		System.out.println("합하기 전 : " + aa);
		aa.addAll(bb);
		System.out.println("합하고난 후 : " + aa);
		
		//중복제거
		Set<Integer> set = new HashSet<Integer>();
		set.addAll(aa);
		System.out.println("중복제거 후 : " + set/*.toString()*/);		
	}
	
	public void test3() {
		Integer[] su = {1,1,1,1,2,2,2,3,3,4,4,4,4,5,6,7,8};
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(Arrays.asList(su));
		
		Set<Integer> set = new HashSet<>(list);
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			Integer i = iter.next();
			int cnt = Collections.frequency(list,i);
			System.out.printf("%d:%d개  ", i, cnt);
		}
	}
	
	/*score의 값을 사용하여 각 학점대의 명수를 출력*/
	public void test4() {
		Integer[] score = {91,99,74,71,53,54,86,47,32};
		List<Integer> list = new ArrayList<Integer>();
		for(Integer i : score) {
			list.add(Math.floorDiv(i, 10));
		}
		Set<Integer> set = new HashSet<Integer>(list);
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			Integer i = iter.next();
			int cnt = Collections.frequency(list,i);
			System.out.printf("%d~ : %d명\n", (i*10), cnt);
		}		
	}	
	
	public static void main(String[] args) {
		new SetEx().test4();
	}	
}
