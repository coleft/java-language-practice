package begin;

public class StringEx3 {
	/*생성자 : 반환형 없어. 반환형 있으면 생성자로서의 역할을 못 해. 생성자로서 기능하려면
	 *클래스 명과 같아야 함. 객체가 생성될 때, 그 객체의 값들을 초기화 하는 용도로 사용,
	 *또는 객체가 생성되어 액션이 일어나기 전에 사전에 처리할 일이 있으면 만든다.*/
	public StringEx3() {	//class명에는 소괄호가 없고, 생성자에는 있다. 비록 둘이 이름 같아도...
		System.out.println("생성자...");
		StringBuilder b1 = new StringBuilder("abc");
		StringBuilder b2 = new StringBuilder("abc");
		
		if(b1 == b2) {
			System.out.println("b1, b2는 같다.");
		}else {
			System.out.println("b1, b2는 다르다.");
		}
		
		String s1 = b1.toString();
		String s2 = b2.toString();
		
		if(s1 == s2) {
			System.out.println("s1, s2는 같다.");
		}else {
			System.out.println("s1, s2는 다르다.");
		}
		
		if(s1.equals(s2)) {
			System.out.println("s1, s2는 같다.\n");
		}else {
			System.out.println("s1, s2는 다르다.\n");
		}
	}
	
	public void test() {
		System.out.println("StringEx3.test");
		StringBuilder sb = new StringBuilder(512);
		sb.append("강은성\n");
		sb.append("서울시\n");
		sb.append("01012345678\n");
		String str = sb.toString();
		
		System.out.println(sb);
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		/*클래스 명 = 생성자 명 ----> 객체 생성한다.
		 * 생성자가 없으면 생성자 JVM이 알아서 만들어 줌.
		 * 생성자를 가지고 클래스의 객체를 생성한다고 생각하자.*/
		StringEx3 ex3 = new StringEx3();
		ex3.test();		
	}
	
}
