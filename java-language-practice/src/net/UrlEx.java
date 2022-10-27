package net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlEx {
	public static void main(String[] args) {
		String domain = "http://192.168.219.161:8888/web-2022-08/index.jsp";
		try {
			URL url = new URL(domain);
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is); //문자형 변환됨
			BufferedReader br = new BufferedReader(isr);
			String data = "";
			
			/*
			while((data=br.readLine())!=null) {
				data = br.readLine();
				System.out.println(data);
			}
			*/
			
			//이렇게 잘 안 쓴다.			
				while(true) {
					data = br.readLine();
					if(data==null)break;
					System.out.println(data);
				}	
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
