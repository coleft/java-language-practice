package interfaceEx;

public class TestRun {
	public static void main(String[] args) {
		Member m = new Member();
		AscMember am = new AscMember();
		
		Main main = new Main(m);
		Main main2 = new Main(am);
		
		MemberInterface mf1 = new AfterMember();
		MemberInterface mf2 = new AfterAscMember();
		
		Main main3 = new Main(mf1);
		Main main4 = new Main(mf2);
				
	}
}

/*
 *
 * MemberInterface inter = new AfterMember();
 *
 * MemberInterface inter = new AfterAscMember();
 * 
 *  로 볼 수 있다는 거야~
 *  이게 바로 다형성이다.
 *  
 */