package collection;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertyEx {
	public void store() throws IOException {	//원래의 소스가 지저분해보이지 않도록 던졌습니다. 
		
		File f = new File("my.ini");
		if(!f.exists()) {
			f.createNewFile();
		}
		Properties prop = new Properties();
		prop.setProperty("id", "a001");
		prop.setProperty("irum", "홍길동");
		prop.setProperty("phone", "02-1111-1111");
		
		String path = URLDecoder.decode(f.getPath(), "utf-8");
		System.out.println("path : " + path);
		FileWriter fw = new FileWriter(f);
		prop.store(fw, "");
		fw.close();
		
	}
	public void load() throws Exception {
		
		String path = "my.ini";
		path = URLDecoder.decode(path, "utf-8");
		FileReader fr = new FileReader(path);
		Properties prop = new Properties();
		prop.load(fr);
		
		System.out.println("id : " + prop.getProperty("id"));
		System.out.println("irum : " + prop.getProperty("irum"));
		System.out.println("phone : " + prop.getProperty("phone"));
		fr.close();
		
	}
	
	public static void main(String[] args) {
		
		/* 에러 나는 이유
		 * class P{}
		 * class C extends P{}
		 * 
		 *  P c1 = new C();(o) -> 자식 객체를 만들어서 부모를 집어넣어서 태어나게 할 수는 있다.
		 *  C c2 = new P();(x) -> 부모를 만들어서 자식에 집어 넣는 건 안 된다. 
		 *  
		 *  그래서 IOException 말고 Exception을 넣을 것이다. 왜냐하면 Exception은 모든
		 *  예외의 부모이기 때문이다. */
		
		try {
			new PropertyEx().load();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
