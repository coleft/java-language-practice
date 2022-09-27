package begin;

import java.io.UnsupportedEncodingException;

public class StringEx {
	public static void main(String[] args) { //void는 반환값 없다는 뜻 (void : 빈)
		String s1 = "홍길동";
		String s2 = "홍길동";
		System.out.println(s1==s2); // Heap Memory에 홍길동이라는 값
		System.out.println(s1.equals(s2)); //문자열 비교
		
		/* 그러나 */
		String s3 = new String("일지매");
		String s4 = new String("일지매");
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4)+"\n");
				
		String jumin = "123456-3";
		char c = jumin.charAt(7);
		int r = Character.getNumericValue(c);
		String str = null;
		if(r%2==0) str = "여자";
		else	   str = "남자";
		System.out.println("c=" + c);
		System.out.println("성별=" + str + "\n");
		
		if(c=='1' || c=='3') str = "진짜 남자 !!!!";
		else	   str = "진짜 여자 !!!!";
		System.out.println(str);
		
		/* String pn = '123R456'인 경우 4번째 값은   
		 * R:red, B:blue, G:green 색을 나타내고 있다.
		 * 위의 pn을 확인하여 어떤 색의 제품인지 출력
		 */
		
		String pn = "123G456";
		char pnMark = pn.charAt(3);
		String pnColor = "";
		
		/*
		if(pnMark == 'R') {
			pnColor = "red";
		}else if(pnMark == 'B') {
			pnColor = "blue";
		}else if(pnMark == 'G') {
			pnColor = "green";
		}else {
			pnColor = "none";
		}
		*/
		
		switch (pnMark) {
			case 'R' : pnColor = "red";
				break;
			case 'B' : pnColor = "blue";
				break;
			case 'G' : pnColor = "green";
				break;
			default : pnColor = "none";
				break;
		}		
		System.out.println(pnColor + "\n");
		
		/* getBytes */
		str = "abc 123 가나다"; //str 원래 String인데 이미 선언 되어서 str 재활용한다.
		try {
			
			byte[] euc = str.getBytes("euc-kr");
			byte[] ksc = str.getBytes("ksc5601");
			byte[] iso = str.getBytes("iso8859-1");
			byte[] utf = str.getBytes("utf-8");
			
			System.out.println("euc-kr : " + new String(euc));
			System.out.println("ksc : " + new String(ksc));
			System.out.println("iso : " + new String(iso));
			System.out.println("utf : " + new String(utf));
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} //getBytes의 반환 타입이 배열이라고 하니까... 인코딩 한다. euc-kr 에러 = 예외처리
		//예외 처리의 두 가지 방법 : 자체를 감싸든지 아니면 초반에...
		
		
		
		
		
		
		
		
		
		
		
		
	}
}