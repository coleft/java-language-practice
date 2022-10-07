package json;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonTest {
	public void stringToJSON() throws ParseException {
		
		//-------------------------------------
		System.out.println("1. 정수형 배열을 JSONArray");
		String jsonInt = "[1,2,3,4,5]";
		
		JSONParser jParser = new JSONParser();
		Object o = jParser.parse(jsonInt);
		JSONArray jArray = (JSONArray)o;
		
		System.out.println(jArray.toJSONString());
		
		for(int i=0; i<jArray.size(); i++) {
			Long s=(Long)jArray.get(i);
			System.out.printf("%d : %d\n", i, s);
		}
		
		
		
		//---------------------------------------		
		System.out.println("-".repeat(20));	
		System.out.println("2. 문자열 배열을 JSONArray");	
		
		String jsonString = "['a','b','1','c']";
		jsonString = jsonString.replace("'", "\"");
		jArray = (JSONArray)jParser.parse(jsonString);
				
		System.out.println(jArray.toJSONString());
		for(int i=0; i<jArray.size(); i++) {
			System.out.printf("%d : %s\n", i, jArray.get(i));
		}
			
			
		//--------------------------------------			
		System.out.println("-".repeat(20));
		System.out.println("3. map구조를 JSONOBject");
		
		String jsonMap = "{'name':'hong', 'age':'20'}";
		jsonMap = jsonMap.replace("'", "\"");
		JSONObject jObject = 
				(JSONObject) jParser.parse(jsonMap);
		System.out.println("json map: " + jObject.toJSONString());
		System.out.println("name: " + jObject.get("name"));
		System.out.println("age: " + jObject.get("age"));
		
		
		
		//-----------------------------------------
		System.out.println("-".repeat(20));
		System.out.println("4. json map list to json object");
		
		String jsonListMap = "[{'name':'hong','addr':'seoul'},{'name':'kim','addr':'busan'}]";
		jsonListMap = jsonListMap.replaceAll("'", "\"");
		jArray = (JSONArray) jParser.parse(jsonListMap);
		System.out.println("json map list string : " + jArray.toJSONString());
		for(Object o2 : jArray) {
			JSONObject job = (JSONObject) o2;
			System.out.println("---");
			System.out.println("name : " + job.get("name"));
			System.out.println("addr : " + job.get("addr"));
		}
		
		
		
		//------------------------------------------
		System.out.println("-".repeat(20));
		System.out.println("5. json map{<K : []} to json object");
		
		jsonString = "{'names' : ['a','b','c','d']}";
		jsonString = jsonString.replace("'", "\"");
		jObject = (JSONObject)jParser.parse(jsonString);//String을 JSON타입으로가져오기
		Object value = jObject.get("names");//그 중 names가져와 그게 value
		jArray = (JSONArray)value;//그걸 Array로 만들어
		for(Object ob : jArray) {	//그 Array 전부 돌면서 ob 뽑아내
			System.out.println(ob);
		}		
		
		//-------------------------------------------
		System.out.println("-".repeat(20));
		System.out.println("6. json map 2 : [{k:[]},{k:[]}]");
		
		jsonString = "[{'names':['a','b','c']},{'ages':[5,6,7]}]";
		jsonString = jsonString.replace("'","\"");		
		jArray = (JSONArray)jParser.parse(jsonString);
				
		for(int i=0;i<jArray.size();i++) {
			jObject = (JSONObject)jArray.get(i);
			Iterator<String> iter = jObject.keySet().iterator();//jObject keySet 나열해줘!! iterator : 배열을 순환시켜준다.
			//아래 while의 hasNext는 iter가 더 많은 요소 갖으면 true 반환
			while(iter.hasNext()) {
				String key = (String)iter.next();
				JSONArray values = (JSONArray)jObject.get(key);
				System.out.println(values.toJSONString());
			}
		}		
		//for(Object ob : jArray){}				
	}
	
	public static void main(String[] args) {
		JsonTest abc = new JsonTest();
		try {
			abc.stringToJSON();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		//여기서도 thorws 하면 가상머신에 예외 던져버림. 실제로는 throws 잘 안 쓰고 예외처리를 해준다.
	}
}
