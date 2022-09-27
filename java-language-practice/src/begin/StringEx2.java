package begin;

//메소드 : 접근제한자 반환형 메소드명(매개변수들){}
public class StringEx2 {
	
	/* 여기 생성자가 있어야 하는 것 같다. => 메소드에 써서 변수를 매개하기 위해서인듯.(Constructor)
	 * 생성자는 변수를 초기화 하는 단계
	 * 무엇을 Construct하는가? => 메소드를 Construct 한다.
	 * 어떻게 Construct하는가? 클래스 바로 안에서 선언한 변수들을 조합한 결과물을 통해... */
	
	//메소드
	public void test() {
		System.out.println("----------");
		String str1 = "abcdefabc";
		String str2 = "abc가나다abc";
		int len1 = str1.length();
		int len2 = str2.length();
		int index1 = str1.indexOf("c");
		int index2 = str2.indexOf("나");
		int index3 = str2.indexOf("ab", 3);//3번째자리 이후부터 찾아라
		
		System.out.println("len1 = " + len1);
		System.out.println("len2 = " + len2);
		System.out.println("index1 = " + index1);
		System.out.println("index2 = " + index2);
		System.out.println("index3 = " + index3);
		
	}

	public void replaceTest() {
		System.out.println("replace---");
		String source = "abc def 123 가나다 abc 123";
		String r1 = source.replace("123", "하나둘셋");
		String r2 = source.replaceAll("[12]", "헛둘"); //그냥 12만 쓰면 한 번만 나온다.
		
		System.out.println("r1 = " + r1);
		System.out.println("r2 = " + r2);
	}
	
	public void substringTest() {
		String source = "abc def 123 가나다 abc 123";		
		String z1 = source.substring(4,5);	//시작 : 4부터, 끝 5미만
		String z2 = source.substring(5,7);
		
		System.out.println("z1 = " + z1);
		System.out.println("z2 = " + z2 + "\n");
	}
	
	public void lowerTest() {
		String source = "ABCabcABCabc";
		String a1 = source.toUpperCase();
		String a2 = source.toLowerCase();
		
		System.out.println("a1 = " + a1);
		System.out.println("a2 = " + a2 + "\n");
	}
	
	public void trimTest() {
		String source = "abc def 123 가나다 abc 123";
		String b1 = source.trim();
		
		System.out.println("b2 = " + b1 + "\n");
	}
	
	public void valueOfTest() {
		Integer c1 = Integer.valueOf(7);			//정수형
		Double c2 = Double.valueOf(5);				//실수형
		Float c3 = Float.valueOf("38");				//실수형
		Integer c4 = Integer.valueOf("100",16);		//정수형 16진법 > 10진법 변환		
		
		System.out.println("c1 = " + c1);
		System.out.println("c1 = " + c2);
		System.out.println("c1 = " + c3);
		System.out.println("c1 = " + c4 + "\n");
	}
	
	public void splitTest() {
		String source = "abc def 123 가나다 abc 123";
		String[] segr = source.split(" ");
		String d1 = segr[0];
		String d2 = segr[1];
		String d3 = segr[2];
		String d4 = segr[3];
		String d5 = segr[4];
		
		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		System.out.println("d3 = " + d3);
		System.out.println("d4 = " + d4);
		System.out.println("d5 = " + d5 + "\n");
	}
	
	public static void main(String[] args) {	
		//test();	// 바로 이렇게 못쓴다. 왜냐하면 메소드 test가 클래스와는 관련 없기 때문이다.
		//그래서 메모리에 클래스를 먼저 올리고 그 메모리 안의 test라고 지정해주어야 한다.
		//가장 뒤가 생성자랬는데 생성자 어딨어 !! 사실 이미 선언 되어 있음.
		//가상 머신이 알아서 가상의 생성자를 빌려준다. 객체가 만들어질 수 있도록....
		StringEx2 ex2 = new StringEx2();
		ex2.test();
		ex2.replaceTest();
		
		ex2.substringTest();
		ex2.lowerTest();
		ex2.trimTest();
		ex2.valueOfTest();
		ex2.splitTest();
	}
	
}












