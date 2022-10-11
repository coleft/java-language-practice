package my;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{	//JFrame의 대부분 요소 사용 가능(상속)
	JButton b = new JButton("exit");//exit이라는 라벨을 가진 버튼
	
	public MyFrame() {//생성자 : MyFrame만들며 초기화
		setBounds(10,20,400,500);//(x,y,w,h)x,y는 모서리,w,h는 너비와 높이
		setLayout(null);//컴포넌트를 블라블라
		b.setBounds(50,100,150,200);//(x,y,w,h)
		add(b);//붙여라
	}
	
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setVisible(true);//화면에 표시됨
	}	
}
