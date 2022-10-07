package json;

import org.json.simple.JSONObject;

public class JavaObjectToJSON {
	public JavaObjectToJSON() {
		//----------------------------
		JSONObject obj = new JSONObject();
		obj.put("name", "홍길동");
		obj.put("score", 90);
		
		System.out.println(obj.toJSONString());
		
		
	}
	
	public static void main(String[] args) {
		new JavaObjectToJSON();
	}
	
}
