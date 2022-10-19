package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx {
	public StreamEx() {
		
		//List
		String[] str = {"강아지","송아지","망아지","호랑이","고양이"};
		List<String> list = new ArrayList<String>(Arrays.asList(str));
		Stream<String> stream = list.stream();
		stream.forEach(x->System.out.println(x));
		System.out.println("-".repeat(20));
		list.forEach(x->System.out.println(x));
		
		//Array /* 이미 위에 str 만들어져있으니까 그냥 쓸게 */
		System.out.println("-".repeat(20));
		stream = Arrays.stream(str);
		stream.forEach(abc->System.out.println(abc));
		
		//Map<K,V>
		System.out.println("-".repeat(20));
		Map<String, String> map = new HashMap<>();
		map.put("aaaa", "kim");
		map.put("bbbb", "lee");
		map.put("cccc", "park");
		map.put("dddd", "hong");
		
		map.forEach((key,value)->{
			System.out.printf("%s : %s\n", key, value);
		});		
		
		/*
		 * 	- stream에서 사용할 수 있는 메서드 - 
		 * 
		 * map()
		 * distinct()
		 * filter()
		 * sorted()
		 * match()
		 * sum(), count(), average(), max(), min()
		 * reduce()
		 * collect() 
		 * 
		 * 
		 * */
		
		//3 map()
		System.out.println("-".repeat(20));
		List<String> list2 = Arrays.asList("abc","Abc","aBC","abC");
		Stream<String> stream2 = list2.stream().map(x->x.toUpperCase());
		stream2.forEach(x->System.out.print(x+","+"\n"));
		
		//4 distinct()
		System.out.println("-".repeat(20));
		List<String> list3 = Arrays.asList("abc","Abc","aBC","abC");
		Stream<String> stream3 = list3.stream().map(x->x.toUpperCase());
		stream3.forEach(x->System.out.print(x+","+"\n"));
		
		//5 filter()
		System.out.println("-".repeat(20));
		List<Integer> list4 = Arrays.asList(1,2,3,4,3,4,5,6);
		Stream<Integer> stream4 = list4.stream().filter(x-> x>4);
		stream4.forEach(x->System.out.print(x+" "+"\n"));
		
		//6 sorted()
		System.out.println("-".repeat(20));
		List<Integer> list6 = Arrays.asList(6,5,8,9,4,3,2,1,7);
		Stream<Integer> stream6 = list6.stream().sorted();
		stream6.forEach(x->System.out.print(x+" "));
		
		//7 match()	AllMatch(), anyMatch(), noneMatch()
		System.out.println("-".repeat(20));
		List<Integer> list7 = Arrays.asList(6,5,8,9,4,3,2,1,7);
		boolean b1 = list7.stream().allMatch(x->x%2==0);
		System.out.println("모두 짝수인가?" + b1);
		
		Stream<Integer> stream7 = list7.stream();
		boolean b2 = stream7.allMatch(x-> x<10);
		System.out.println("모두 10보다 작은가?"+b2);
		
		//8 기본집계 sum(),count(), average(), max(), min()
		System.out.println("-".repeat(20));
		int[] su = {1,2,3,4,5};
		long hap = Arrays.stream(su).sum();
		System.out.println("hap : " + hap);
		hap = Arrays.stream(su).filter(x->x<4).sum();
		System.out.println("hap2 : " + hap);
				
		long cnt = Arrays.stream(su).count();
		System.out.println("cnt : " + cnt);
		cnt = Arrays.stream(su).filter(x->x<4).count();
		System.out.println("hap2 : " + cnt);
		
		//9 reduce()
		System.out.println("-".repeat(20));
		Stream<Integer> stream9 = Stream.of(1,2,3,4,5);
		Optional<Integer> opt = stream9.reduce((x,y)->x+y);
		opt.ifPresent(s->System.out.println(s));
		
		//10 collect()
		System.out.println("-".repeat(20));
		Integer[] su2 = {1,2,3,4,5,6,7,8,9};
		List<Integer> list10 = Arrays.stream(su2).filter(x -> x>5).collect(Collectors.toList());
		list10.stream().forEach(x->System.out.println(x));
		
	}
	public static void main(String[] args) {
		new StreamEx();
	}
}
