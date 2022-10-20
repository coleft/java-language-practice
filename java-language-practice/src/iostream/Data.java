package iostream;

import java.io.Serializable;
import java.util.Vector;

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

	// JTable의 데이터 속성이 Vector<Vector>이기 떄문에
	public Vector getVector() {
		Vector v = new Vector();
		v.add(id);
		v.add(mName);
		v.add(addr);
		v.add(phone);
		v.add(phone);
		return v;		
	}
	
	@Override
	public String toString() {
		String temp = "\n-----------------"
					 +"\nid : " +this.id
					 +"\nname : " +this.mName
					 +"\naddress : " +this.addr
					 +"\nphone : " +this.phone
					 +"\npoint : " +this.point;
		return temp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
}
