package inheri;

public class Student extends Data {
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot() {
		this.tot = kor+eng+mat;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg() {
		this.avg = tot/3;
	}
	
	public Student() {
		
		setName("Kang");
		setAddress("Seoul");
		setPhone("010");
		setKor(90);
		setEng(95);
		setMat(100);
		setTot();
		setAvg();
	}
	
	@Override
	public String toString() {
		return "Student [kor=" + getKor() + ", eng=" + getEng() + ", mat=" + getMat() + ", tot=" + getTot() + ", avg=" + getAvg() + ", name="
				+ getName() + ", address=" + getAddress() + ", phone=" + getPhone() + "]";
	}
	
}
