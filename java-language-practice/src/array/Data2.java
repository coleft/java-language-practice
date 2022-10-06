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
		//이름을 오름차순으로
		//int r = this.mid.compareTo(o.mid);
		
		//성적을 오름차순으로
		//int r = this.score - o.score;
		
		//이름을 내림차순으로
		//int r = o.mid.compareTo(this.mid);
		
		//성적을 내림차순으로
		int r = o.score - this.score;
		
		return r;		
	}

	@Override
	public String toString() {
		String str = "mid:" + this.mid
					+", score:" + this.score;
		return str;
	}		
}
