package net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient {
	
	/* 클라이언트단 */
	
	public TcpClient() throws Exception {
		// 1) 서버에 접속(서버의 ip, port)
		InetAddress ia = InetAddress.getLocalHost();
		String ip = "192.168.219.161"; /*ia.getHostAddress();*/	//지금 내가 클라이언트니까
		System.out.println("IP : " + ip);
		Socket socket = new Socket(ip, 5555);
		
		// 2) IOStream 생성 
		OutputStream os = socket.getOutputStream();
		InputStream is = socket.getInputStream();
		
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);		
		
		// 3) 메시지 전송			
		String msg = ""; 
		for(int i = 1; i<=10; i++) {
			msg = "점심메뉴추천받습니다.\n";
			bw.write(msg);
			bw.flush();		
		}
		
		// 4) 메시지 수신
		String receiveMsg = br.readLine();
		System.out.println("수신된 메시지 : " + receiveMsg);	
		
		msg = "exit\n";
		
		bw.write(msg);
		bw.flush();	
		
		br.close();
		isr.close();
		is.close();
		
		bw.close();
		osw.close();
		os.close();
		
		socket.close();
	}
	
	public static void main(String[] args) throws Exception {
		new TcpClient();
	}
	
}
