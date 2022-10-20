package iostream;

import java.util.List;

//설계도면 역할을 하는 깡통이다.
public interface ScoreInterface {
	
	public void write(ScoreVo vo);	//중괄호 쓰면 에러 난다. 있으면 바디가 있다는 것.	
	public List<ScoreVo> read();	
	public void modify(ScoreVo vo);	
	public void delete(int serial);
	
}
