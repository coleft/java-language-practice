package json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class JavaObjectToJSON {
	
	
	public JavaObjectToJSON() {
		//----------------------------
		JSONObject obj = new JSONObject();
		obj.put("name", "홍길동");
		obj.put("score", 90);
		obj.put("addre", "봉천동");
		
		System.out.println(obj.toJSONString());
		System.out.println("name : " + obj.get("name"));
		System.out.println("score : " + obj.get("score"));
		System.out.println("addre : " + obj.get("addre"));
		
		//key를 알 수 없는 경우-------------------
		Set<String> set = obj.keySet();
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key +"=>"+obj.get(key));
		}
		
		//Object 저장-------------------------------
		Test t1 = new Test();
		t1.setIrum("hong");
		t1.setScore(60);
		
		Test t2 = new Test();
		t2.setIrum("지매");
		t2.setScore(90);
		
		obj = new JSONObject();
		obj.put("o1", t1);
		obj.put("o2", t2);
		
		System.out.println(obj.toJSONString());	
		
		//obj에 저장된 Test객체를 가져와 출력
		Test t3 = (Test)obj.get("o1");
		System.out.println("t3.irum : " + t3.getIrum());
		System.out.println("t3.score : " + t3.getScore());	
		Test t4 = (Test)obj.get("o2");
		System.out.println("t4.irum : " + t4.getIrum());
		System.out.println("t4.score : " + t4.getScore());		
		
		//4. json array object
		JSONArray array = new JSONArray();
		obj = new JSONObject();
		obj.put("name", "박원기");
		obj.put("phone", "010-1111-1111");
		
		array.add(obj);
		array.add(obj);
		array.add(obj);
		
		for(Object o : array) {
			System.out.println(o);
		}
		
		for(Object o : array) {
			obj = (JSONObject) o;
			System.out.println(obj.toJSONString());
		}
		
		System.out.println("전체 데이터를 map으로");
		System.out.println(array);
		
		//5. Map to JSONObject
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "hong");
		map.put("age", 20);
		obj = new JSONObject(map);
		
		System.out.println(obj);
		System.out.println("name : " + obj.get("name"));
		System.out.println("age : " + obj.get("age"));
		
		//6. List to JSONArray
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		array.clear();
		array.addAll(list);
		for(Object s : array) {
			System.out.println(s);
		}
		System.out.println(array.toJSONString());
		
		//List<Test> to JSONArray
		System.out.println("-------------");
		System.out.println("6. JavaObject to JSONArray");
		List<Test> listTest = new ArrayList<Test>();
		
		//listTest.add(new Test("kim", 20));
		//listTest.add(new Test("hong", 30));
		array.clear();
		array.addAll(listTest);
		for(Object o : array) {
			Test t = (Test) o;
			System.out.println(t.getIrum() + "," + t.getScore());
			System.out.println(JSONValue.toJSONString(t));
		}
		
	}
	
	public static void main(String[] args) {
		new JavaObjectToJSON();
	}	
}
