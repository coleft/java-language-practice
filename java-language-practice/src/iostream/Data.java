package iostream;

import java.io.Serializable;

public class Data implements Serializable{
	public static long serialVersionUID = 100L;
	
	String id, mName, addr, phone;
	int point;
	
	public Data(String id, String mName, String addr, String phone, int point) {
		this.id = id;
		this.mName = mName;
		this.addr = addr;
		this.phone = phone;
		this.point = point;
	}
}
