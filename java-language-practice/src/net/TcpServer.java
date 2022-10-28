package net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	
	/* 서버단 */
	
	public TcpServer() throws Exception {	//여기서 예외 처리하면 main메서드로 보내고, main메서드는 가상머신으로 보낸다.
		
		/* *
		 * 
		 * 이렇게 만드는 서버를 에코 서버라고 한다.
		 * 클라이언트로부터 들어오는 정보를 반송하기
		 * 때문이다. 
		 * 
		 * */
		
		// 1) ServerSocket 생성
		ServerSocket server = new ServerSocket(4444);	//두 번째꺼 포트번호만 써서 해보자
			
		// 2) 클라이언트 접속 대기
		System.out.println("클라이언트의 접속을 대기하고 있습니다.");
		Socket socket = server.accept();	//Accept 대기하고 있다. 만약 UI가 있는 프로그램이면 버튼도 안 눌리고 아무것도 안 될 것이다.(블로킹모드)
		
		// 3) IOStream 생성
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();	//가끔 인풋 먼저 만들면 트러블 생길 가능성 있어서 생성 자체를 output 먼저 생성하는 게 좋다.		
		
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		while(true) {
			// 4) 수신된 메시지를 표시
			String msg = br.readLine();	//영상, 이미지, 문서 자체는 ByteStream으로 보내야 한다.
			System.out.println("수신 메시지 : " + msg);
			
			/* while문 돌다가 exit 받으면 나가 */
			if(msg.equals("exit")) {				
				break;	
			}
			
			// 5) 클라이언트로 메시지 전송
			msg = "서버가 재전송함 >> " + msg;
			bw.write(msg);	
			bw.write("\n");
			bw.flush();
		}
		
		br.close();
		isr.close();
		is.close();
		
		bw.close();
		osw.close();
		os.close();
		
		socket.close();
		server.close();
		
		//io 관련된 거 전부 닫아줘
		//에코서버...
		
	}
	
	public static void main(String[] args) throws Exception {
		new TcpServer();		
	}
	
}
