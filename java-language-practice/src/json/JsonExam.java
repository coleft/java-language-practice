package json;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonExam {
	
	String score1;	//1번 문제의 score
	String score2;	//2번 문제의 score
	String member;
	String score4;	//4번 문제의 score
	JSONParser jParser = new JSONParser();
	
	public JsonExam(){
		score1 = "[44,33,55,65,78]";
		score2 = "{'id':'hong', 'name':'길동', 'phone':'010-2222'}";
		member = "[{ '담임' : '홍', '학생':['김', '이', '박']}, { '담임' : '김', '학생':['남','최']},{ '담임' : '남', '학생':['김','가','나','마','사','이']}]";                  
		score4 = "[{'a반' : [3,4,5,6,7]},{'b반' : [6,5,6,7,8]},{'c반' : [1,3,4,5,4,3,2,3,4]}]";		
	}	
	
	public void toJSON1() throws ParseException {
		
		Object obj1 = jParser.parse(score1);
		JSONArray jArray = (JSONArray) obj1;
		double hap = 0;
		for(int i = 0; i<jArray.size(); i++) { 
			Long tot = (Long)jArray.get(i);
			hap = hap + tot;
		}
		System.out.println(hap/jArray.size());
	}
	
	public void toJSON2() throws ParseException {
		score2 = score2.replace("'","\"");
		JSONObject jObject = (JSONObject)jParser.parse(score2);
		System.out.println("id : " + jObject.get("id"));
		System.out.println("name : " + jObject.get("name"));
		System.out.println("phone : " + jObject.get("phone"));
	}

	public void toJSON3() throws ParseException {		
		member = member.replace("'","\"");				
		JSONArray jArray = (JSONArray)jParser.parse(member);
		for(int i=0; i<jArray.size();i++) {
			JSONObject jObject  = (JSONObject)jArray.get(i);
			Object value1 = jObject.get("담임");
			Object value2 = jObject.get( "학생" );
			JSONArray jjArray2 = (JSONArray)value2;
			System.out.println(value1 +":"+ jjArray2.size() + "명");
		}		
	}

	public void toJSON4() throws ParseException {
		score4 = score4.replace("'", "\"");
		JSONArray jArray = (JSONArray)jParser.parse(score4);
		for(Object o:jArray) {
			JSONObject jObject = (JSONObject)o;
			int sum = 0;
			Iterator<String> iter = jObject.keySet().iterator();
			while(iter.hasNext()) {
				String key = (String)iter.next();
				JSONArray values = (JSONArray)jObject.get(key);
				for(int i =0; i<values.size(); i++) {					
					Long tot = (Long)values.get(i);
					sum+=tot;
				}
				System.out.printf("%s : %.3f\n", key, (float)sum/values.size());
			}
		}		
	}
	
	public static void main(String[] args) {
		JsonExam test = new JsonExam();
		try {
			test = new JsonExam();
			test.toJSON1();
			test.toJSON2();
			test.toJSON3();			
			test.toJSON4();
		} catch (ParseException e) {
			e.printStackTrace();
		}		
	}
}