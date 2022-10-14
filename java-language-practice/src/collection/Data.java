package collection;

public class Data {
	
	String id;
	String irum;
	int age;
	
	public Data(String id, String irum, int age) {
		this.id = id;
		this.irum = irum;
		this.age = age;
	}
	
	public Data() {
		// TODO Auto-generated constructor stub
	}	

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
	
	@Override
	   public boolean equals(Object obj) {
	      boolean b = false;
	      if(obj instanceof Data) {
	         Data temp = (Data)obj;
	         if(this.id.equals(temp.getId())) { //id값끼리 비교해서 같으면 true
	            b = true;
	         }
	      }else {
	         String temp = (String)obj;
	         if(this.id.equals(temp)) {
	            b = true;
	         }
	      }
	      return b;
	   }
	
	/*
	@Override
	public boolean equals(Object obj) {
		boolean b = false;
		if(obj instanceof Data) {
			Data temp = (Data)obj;
			if(this.id.equals(temp.getId())) {
				b = true; //여기에 }하나가 빠졌구나
			}else {
				String temp = (String)obj;
				if(this.id.equals(temp)) {
					b=true;
				}
			}
		}		
		return b;
	}
	 */
	
	@Override
	public String toString() {
		String str = id + " , " + irum + " , " + age + "\n";
		return str; //이거 하면 결과값이 해시코드 값대신에 문자로 나온다.(ListEx.java에서...)
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIrum() {
		return irum;
	}
	public void setIrum(String irum) {
		this.irum = irum;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
