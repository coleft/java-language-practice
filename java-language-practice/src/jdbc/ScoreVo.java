package jdbc;

public class ScoreVo {
	
	String serial, id, mdate, subject, score;
	
	public ScoreVo() {}
	public ScoreVo(String serial, String id, String mdate, String subject, String score) {
		this.serial = serial;
		this.id = id;
		this.mdate = mdate;
		this.subject = subject;
		this.score = score;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	
	
}
