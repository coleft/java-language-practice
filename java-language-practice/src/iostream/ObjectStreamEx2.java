package iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectStreamEx2 {
	
	List<Score> list = new ArrayList<Score>();
	String fileName = "score.obj";
	
	public void write() throws Exception {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Score d1 = new Score("s001",90,100,96);
		Score d2 = new Score("a003",70,68,77);
		Score d3 = new Score("s007",100,99,97);
		Score d4 = new Score("s002",98,100,87);
		Score d5 = new Score("c017",45,67,79);
		Score d6 = new Score("b121",89,75,90);
		
		list.addAll(Arrays.asList(d1,d2,d3,d4,d5,d6));
		
		oos.writeObject(list);
		oos.close();
		fos.close();
	}
	
	public void read() throws Exception {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);		
		List<Score> readData = (List<Score>) ois.readObject();
		
		list.forEach(x->System.out.println(x));
		
		/*
		for(Data2 d : readData) {
			System.out.println(d);
		}
		*/
		
		ois.close();
		fis.close();
	}
	
	public static void main(String[] args) {
		ObjectStreamEx2 ex2 = new ObjectStreamEx2();
		try {
			ex2.write();
			ex2.read();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
