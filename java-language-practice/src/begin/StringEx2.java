package begin;

//메소드 : 접근제한자 반환형 메소드명(매개변수들){}
public class StringEx2 {
	
	/* 여기 생성자가 있어야 하는 것 같다. => 메소드에 써서 변수를 매개하기 위해서인듯.(Constructor)
	 * 생성자는 변수를 초기화 하는 단계
	 * 무엇을 Construct하는가? => 메소드를 Construct 한다.
	 * 어떻게 Construct하는가? 클래스 바로 안에서 선언한 변수들을 조합한 결과물을 통해... */
	
	//메소드
	public void test() {
		System.out.println("--------");
		String str1 = "abcdefabc";
		String str2 = "abc가나다abc";
		int len1 = str1.length();
		int len2 = str2.length();
		int index1 = str1.indexOf("c");
		int index2 = str2.indexOf("나");
		
		System.out.println("len1 = " + len1);
		System.out.println("len2 = " + len2);
		System.out.println("index1 = " + index1);
		System.out.println("index2 = " + index2);
	}	

	public static void main(String[] args) {		
		//test();	// 바로 이렇게 못쓴다. 왜냐하면 메소드 test가 클래스와는 관련 없기 때문이다.
		//그래서 메모리에 클래스를 먼저 올리고 그 메모리 안의 test라고 지정해주어야 한다.
		//가장 뒤가 생성자랬는데 생성자 어딨어 !! 사실 이미 선언 되어 있음.
		//가상 머신이 알아서 가상의 생성자를 빌려준다. 객체가 만들어질 수 있도록....
		StringEx2 ex2 = new StringEx2(); 		
		ex2.test();
	}
	
}
