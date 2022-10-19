package iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectStreamEx {
	
	List<Data> list = new ArrayList<Data>();
	String fileName = "object.obj";
	
	public void write() throws Exception {
		
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Data d1 = new Data("aaaa1","hong1","서울1","010-1111", 90);
		Data d2 = new Data("aaaa2","hong2","서울2","010-1112", 70);
		Data d3 = new Data("aaaa3","hong3","서울3","010-1113", 60);
		Data d4 = new Data("aaaa4","hong4","서울4","010-1114", 40);
		list.addAll(Arrays.asList(d1, d2, d3, d4));
		
		oos.writeObject(list);
		oos.close();
		fos.close(); //oos와 fos 닫는 순서 꼭 지켜야한다.
		
	}
	
	public void read() throws Exception {		
		
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		List<Data> readData = (List<Data>) ois.readObject();
		for(Data d : readData) {
			System.out.println(d);
		}
		ois.close();
		fis.close();
	}
	
	public static void main(String[] args) {
		ObjectStreamEx ex = new ObjectStreamEx();
		try {
			ex.write();
			ex.read();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
