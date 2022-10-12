package inheri;

public class InterfaceImple implements SuperInterface1, SuperInterface2{

	@Override
	public void absoluteMethod2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void absoluteMethod1() {
		// TODO Auto-generated method stub
		
	}
	
}
/*
 * 		Overriding 은 재정의
 * 
 * 			부모에 있는 메서드를 자식 클래스에서 다시 정의함.
 * 			메서드명, 매개변수, 반환형 모두 반드시 일치!!
 * 			접근 제한자 : 부모 이상으로 넓어야함
 * 			예외처리 : 부모의 예외처리 범위 이하
 * 		
 * 		Overloading은 중복선언 
 * 
 */