package iostream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

public class ScoreDao implements ScoreInterface{

	String fileName = "score.obj";
	List<ScoreVo> list = new Vector<ScoreVo>();
	
	public ScoreDao() {
		list = read();
	}
	
	@Override
	public void write(ScoreVo vo) {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			list.add(vo);
			oos.writeObject(list);
			
			oos.flush();
			oos.close();
			fos.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<ScoreVo> read() {
		return null;
	}

	@Override
	public void modify(ScoreVo vo) {
		
	}

	@Override
	public void delete(int serial) {
		
	}

}
