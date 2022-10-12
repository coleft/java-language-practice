package exceptionEx;
public class TryTest {
	
	int a(){
		String s = "abc";
		try{
			int i = Integer.parseInt(s);
		}catch(NumberFormatException ex) {
			System.out.println("좋은말 할 때 숫자만... 제발...");
		}finally {
			System.out.println("무조건이야~~~");
		}
		return 10;
	}
	
	void b() {	//여기는 첨자 오류를 해볼게
		String[] ary = {"a","b","c"};
		for(int i = 0; i<= 3; i++) {
			try {	//for문 전체를 감싸줘도 됨
				System.out.println(ary[i]);
			}catch(ArrayIndexOutOfBoundsException ex) {
				System.out.println("배열의 크기를 벗어난 듯....");
			}
		}
	}
	
	void c() throws Exception {	//연산오류
		int a = 10;
		int r = a/0;
	}
	
	void d() {	// null 오류
		String name = null;
		try {
			System.out.println(name.equals("abc"));
		} catch(NullPointerException ex) {
			System.out.println("값이 없음");
		}
	}
	
	void test() {
		try {
			throw new Exception("오류남...");
			//System.out.println("이곳은 실행되지 않음.");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new TryTest().test();		//익명으로 만들자 마자 x를 실행해줘
	}	
}
