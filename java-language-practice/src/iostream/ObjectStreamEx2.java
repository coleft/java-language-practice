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
	
	List<Data2> list = new ArrayList<Data2>();
	String fileName = "score.obj";
	
	public void write() throws Exception {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Data2 d1 = new Data2("s001",90,100,96);
		Data2 d2 = new Data2("a003",70,68,77);
		Data2 d3 = new Data2("s007",100,99,97);
		Data2 d4 = new Data2("s002",98,100,87);
		Data2 d5 = new Data2("c017",45,67,79);
		Data2 d6 = new Data2("b121",89,75,90);
		
		list.addAll(Arrays.asList(d1,d2,d3,d4,d5,d6));
		
		oos.writeObject(list);
		oos.close();
		fos.close();
	}
	
	public void read() throws Exception {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);		
		List<Data2> readData = (List<Data2>) ois.readObject();
		
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
