package array;

public class ObjectArrayTest {
	void memberTest() {	//같은 패키지에서 혹은 상속받았다면 접근 가능 정 껄끄러우면 public 써
		//메소드 만드는 중이다.
		
		//1) 배열 선언
		Member[] m = new Member[5];
		
		//2) 배열 요소에 객체 생성한 후 대입
		for(int i=0; i<m.length; i++) {
			m[i] = new Member();
		}
		
		//3) 사용
		for(int i=0; i<m.length; i++) {
			m[i].name = "kim" + i;
			m[i].address = "서울" + i;
			m[i].tel = "010-1111-1111" + i;
		}
		
		for(int i=0; i<m.length; i++) {
			System.out.println(m[i].name);
			System.out.println(m[i].address);
			System.out.println(m[i].tel);
			System.out.println("------------");
		}		
	}
	
	public static void main(String[] args) {
		ObjectArrayTest ot = new ObjectArrayTest();
		ot.memberTest();
	}
	
}
