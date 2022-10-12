package lang;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class WrapperEx {
	public void test() {
		String x = "123";
		String y = "456";
		System.out.println("x+y=" + (x+y));
		
		int n1 = Integer.parseInt(x);
		int n2 = Integer.parseInt(y);
		System.out.println("n1+n2=" + (n1+n2));
	}
	
	public void test2() {
		String x = "123.456";
		String y = "3.14";
		System.out.println(x+y);
		
		double d1 = Double.parseDouble(x);
		double d2 = Double.parseDouble(y);
		
		System.out.println(d1+d2);
	}
	
	public void test3() {
		//JSON 유형으로 전달된 성적의 합계와 평균을 구하시오.
		String score = "[70,80,90,60,60]";
		
		// 1) JSONArray로 파싱
		JSONParser jParser = new JSONParser();
		int hap = 0;
		double avg = 0;
		// 2) List 구조의 값을 사용하여 합계와 평균을 계산
		try {
			JSONArray jArray=(JSONArray)jParser.parse(score);
			for(int i = 0; i<jArray.size(); i++) {
				System.out.println(jArray.get(i));
				Object o = jArray.get(i);
				Long su = (Long)o;
				hap += su;
			}
			avg = (double)hap/jArray.size();
			
			System.out.println("hap : " + hap);
			System.out.println("avg : " + avg);
			
		} catch (ParseException e) {
			e.printStackTrace();
		} 				
	}
	
	public void test4() {		//합계와 평균
		String score = "['10','20','30','40','50']";
		score = score.replace("'", "");
		JSONParser jParser = new JSONParser();
		long sum = 0L;
		double avg = 0;	
		JSONArray jArray = null;
		try {
			jArray = (JSONArray)jParser.parse(score);			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for(int i = 0; i<jArray.size(); i++) {
			sum += (Long)jArray.get(i);	//이 자체가 오브젝트라서 다른 타입으로 바뀔 수 있다.
		}
		avg = (double)sum/jArray.size();		
		System.out.println("합계 : " + sum + "\n" + "평균 : " + avg);						
	}	
	
	/*
	public void test4() {		//합계와 평균
		String score = "['10','20','30','40','50']";
		score = score.replace("'", "");
		JSONParser jParser = new JSONParser();
		long sum = 0L;
		double avg = 0;	
		JSONArray jArray = null;
		try {
			jArray = (JSONArray)jParser.parse(score);				
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Iterator iter = jArray.iterator();
		while(iter.hasNext()) {
			sum += (Long)iter.next();	//이 자체가 오브젝트라서 다른 타입으로 바뀔 수 있다.
		}
		avg = (double)sum/jArray.size();		
		System.out.println("합계 : " + sum + "\n" + "평균 : " + avg);						
	}
	*/
	
	public static void main(String[] args) {
		WrapperEx ex = new WrapperEx();
		//ex.test();
		ex.test4();
	}
}
