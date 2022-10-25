package jdbc;

public class MemberVo {
	
	/*
	 * Vo는 한 사람의 데이터를 저장하는 공간이라고 생각하자.
	 * 한 사람이 여러장의 사진 등을 가지면 Vector나 ArrayList 등을 만들어라.
	 * 
	 * 데이터 포멧 같은 거다. 이거 통해서 데이터를 체계적으로 만든다.
	 * 
	 * */
	
	String id, irum, gender, phone, picture, mDate;
	
	public MemberVo() {}
	public MemberVo(String id, String irum, String gender, String phone, String picture) {	//파라미터로 들어온 값을 필드에 집어넣는다.
		
		this.id = id;
		this.irum = irum;
		this.gender = gender;
		this.phone = phone;
		this.picture = picture;
		
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getmDate() {
		return mDate;
	}
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
	
}
