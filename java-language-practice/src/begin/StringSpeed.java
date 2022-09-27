package begin;

public class StringSpeed {
	public StringSpeed() {
		String str = "a";
		long sTime = 0, eTime = 0, rTime = 0, rTime2;
		
		//String
		sTime = System.currentTimeMillis();
		for(int i = 0; i< 99000; i++) str += "a";
		System.out.println(sTime);
		eTime = System.currentTimeMillis();
		
		rTime = (eTime-sTime);
		System.out.println("Time1 : " + (rTime/1000d)+"초");
		
		//StringBuilder
		StringBuilder sb = new StringBuilder();
		sTime = System.currentTimeMillis();
		for(int i = 0 ;i<99000; i++) sb.append("a");
		eTime = System.currentTimeMillis();
		rTime2 = (eTime - sTime);
		System.out.println("Time2 : " + (rTime2/1000d) + "초");
		
		System.out.println(rTime/rTime2 + "배");
	}
	public static void main(String[] args) {
		
		StringSpeed ss = new StringSpeed(); //객체가 생성되는 순간 생성자는 실행된다.
		//메소드가 만들어지면 ss.메소드명 이런식으로 메소드를 실행한다.
		
		//new StringSpeed();
	}
}
