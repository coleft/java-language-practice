package array;

public class Data2 implements Comparable<Data2>{
	private String mid;
	private int score;
	
	Data2(String mid, int score){
		this.mid = mid;
		this.score = score;
	}	
	
	public String getMid() {
		return mid;
	}
	
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int compareTo(Data2 o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
