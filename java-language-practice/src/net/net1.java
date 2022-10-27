package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class net1 {
	
	
	
	public static void main(String[] args) {
		System.out.println("[ Local Host ]");
		try {
			
			InetAddress n1 = InetAddress.getLocalHost();
			System.out.println("host name : " + n1.getHostName());
			System.out.println("address : " + n1.getHostAddress());
			
			System.out.println("[ Network Host ]");
			InetAddress n2 = InetAddress.getByName("www.naver.com");
			System.out.println("host name : " + n2.getHostName());
			System.out.println("address : " + n2.getHostAddress());
			
			n2 = InetAddress.getByName("www.google.com");
			System.out.println("host name : " + n2.getHostName() );
			System.out.println("address : " + n2.getHostAddress());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
}
