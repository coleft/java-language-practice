package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapEx {
	public void test1() {
		Map<String, String> hm = new HashMap<String, String>();
		
		//입력(Create)
		hm.put("a1", "aaaa");
		hm.put("a2", "bbbb");
		hm.put("a3", "cccc");
		System.out.println(hm);
		
		//수정(Update)
		hm.put("a2", "홍길동");
		System.out.println(hm);
		
		//삭제(Delete)
		hm.remove("a2");
		System.out.println(hm);
		
		//조회 : 키를 알 때
		System.out.println(hm.get("a1"));
		System.out.println(hm.get("a3"));
		
		//조회(Read) : 키를 모를 때
		System.out.println("-".repeat(27));
		Set<String> set = hm.keySet(); //제너릭을 쓰지 않으면 무조건 Object 타입, set은 순서가 지 맴이다.
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(hm.get(key));
		}
		
		//조회 : 키 값 없이 밸류 출력하고 싶을 때
		System.out.println("-".repeat(27));
		Collection<String> values = hm.values();
		iter = values.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		/* set구조와 map 구조는 iterator를 만들 생각을 하면 좋다. */
		
		//Map.Entry
		//원래 Set set = hm.entrySet();
		System.out.println("-".repeat(27));
		Set<Map.Entry<String, String>> set2 = hm.entrySet(); //교재랑 비교할 것 !!
		Iterator<Map.Entry<String, String>> iter2 = set2.iterator(); //Map이 안보이지만 Map.Entry가 반환타입이다.
		while(iter2.hasNext()) {
			Map.Entry<String,String> entry = iter2.next();
			System.out.println(entry.getKey() + "," + entry.getValue());
		}
		
		//value값이 Data클래스
		Map<String,Data> hm3 = new HashMap<String, Data>();
		hm3.put("a001", new Data("a001", "hong", 18));
		hm3.put("b001", new Data("b001", "kim", 20));
		hm3.put("c001", new Data("c001", "park", 30));		
		
		//key값을 기준으로
		Set<String> set3 = hm3.keySet();
		Iterator<String> iter3 = set3.iterator();
		while(iter3.hasNext()) {
			String key = iter3.next();
			Data d = hm3.get(key);
			System.out.println(d);
		}
		/* 순서가 중요하면 map이나 set 구조를 웬만하면 쓰지말라. 신버전에선 순서 있을 수 있으나 기본적으로
		 * 순서가 있으면 list에 하는 게 좋다. */
		
	}
	
	public static void main(String[] args) {
		new MapEx().test1();
	}
}
