package array;

public class ArrayDeclare {

	
	public ArrayDeclare(){
		// 크기를 지정하여 배열 선언
		int[] a = new int[5];
		String[] s = new String[5];
		byte[] b = new byte[1024];
		Object[] obj = new Object[5];
		
		// 배열형만 선언하고 크기를 나중에 지정
		int[] aa;
		aa = new int[5];
		String[] ss;
		ss = new String[3];
		byte[] bb;
		bb = new byte[512];
		Object[] obj2;
		obj2 = new Object[2];
		
		//초기값을 사용하여 배열 선언
		int[] aaa = {1,2,3,4,5};
		byte[] bbb = new byte[] {'a','b','c','d','e'};
		String[] sss = {"홍길동","일지매","임꺽정"};
		
		//첨자를 사용하여 배열 접근
		System.out.println(aaa[0]);
		System.out.println(bbb[1]);
		System.out.println(sss[2]);
		
		//객체형 배열 사용하기
		Data[] d = new Data[5]; //배열
		Data kim = new Data();
		d[0].name = "kim";
		kim.name = "kim";
	
		Data abc = new Data();	//단순 객체
		abc.name = "kim";
		d[0] = abc; //(o)
		System.out.println(d[0].name); //kim
		System.out.println(d[0]);
		
	}
		
	
	public static void main(String[] args) {
		ArrayDeclare ArrayDeclare = new ArrayDeclare() ;
		
	}
	
	
}
