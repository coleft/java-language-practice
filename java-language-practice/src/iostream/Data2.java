package iostream;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Data2 implements Serializable{
	public static long serialVersionUID = 100L;
	
	String id;
	int kor, eng, mat;
	double tot;
	double avg;
	
	public Data2(String id, int kor, int eng, int mat) {
		this.id = id;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor+eng+mat;
		this.avg = tot/3;
		
	}
	
	@Override
	public String toString() {
		DecimalFormat sdf = new DecimalFormat("#,###.0");
		
		String temp = "\n-----------------"
					 +"\nid : " + this.id
					 +"\nkorean : " + this.kor
					 +"\nenglish : " + this.eng
					 +"\nmath : " + this.mat
					 +"\ntotal : " + sdf.format(this.tot)
					 +"\naverage : " + sdf.format(this.avg);
		return temp;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



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

	public double getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}	
	
}
