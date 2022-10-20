package iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

/*
 * 이 프로그램은 불완전하다.
 * mi 객체 : MemberInput이 처음부터 다시 만들어지는 것이다.
 * 다시 만들어졌을 때 저장버튼을 클릭하면 memberDao 가 또 만들어지고 필드 부분이 또 다시 만들어짐
 * 첫 데이터가 들어간 후 새로운 창을 열면 또 다시 mi 객체가 만들어지고 또 만들어진다.  
 * 매개변수가 없는 생성자가 빙빙 돌 것이다.
 * 첫번째 창에서 추가된 데이터가 파일에 들어가있는데, 두번쨰가 초기화되고 또 한 건만 들어간다. */

public class MemberDao {

	public String fileName = "member.obj";
	List<Data> list = new Vector<Data>();	//이부분에 대해서 잘 생각해봐야 한다.
	ObjectOutputStream oos;
	ObjectInputStream ois;	
	
	public MemberDao() {
		list = read();
	}	
	public void write(Data d) {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			list.add(d);
			oos.writeObject(list);
			oos.flush();
			oos.close();
			fos.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public List<Data> read() {	//나중에 오버로딩할거임
		//1. 지역형변수로 Data타입 list. null 말고 이미 다른 작업이 있으면 NullPoint bla bla 예외 떨어진다. 
		try {	//try catch는 일단 신경x
			FileInputStream fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			list = (List<Data>) ois.readObject();
			ois.close();
			fis.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	public void modify(Data d) {
		
		// 기존 자료를 다시 read
		list = read();
		// 수정할 데이터 검색
		int index = list.indexOf(d);
		if(index != -1) {
			list.set(index, d);	//자료 갱신
			FileOutputStream fos;
			try {
				fos = new FileOutputStream(fileName);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(list);
				oos.flush();
				oos.close();
				fos.close();
				
			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			
		}
		
	}
	public void delete(String id) {
		
		//삭제하기위해 항목 찾는 법 많다. id값과 id를 비교하는법
		/**
		 *  1. 첫번째 방법
		 *  for(int i = 0; i<list.size(); i++){
		 *  	Data d = list.get(i);
		 *  	if(d.getId().equals(id)){
		 *  		list.remove(i);
		 *  	}
		 *  }
		 *  
		 * */
		
		/**
		 * 	2. 두번째 방법 : Data hashCode(), equals() 재정의한 후
		 * 		int index = list.indexOf(d);
		 * 		list.remove(index);
		 * 
		 * */
		
		read();	//최종 결과물로 다시 list를 갱신
		Data d = new Data(id);
		d.setId(id);
		
		int index = list.indexOf(d);
		if(index != -1) {
			list.remove(index);	//메모리에서만 삭제
			try {	//파일에서도 삭제
				FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(list);
				oos.close();
				fos.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void view() {
		
	}
}
