package inheri;

public class HashcodeObject {
	int id;
	public HashcodeObject(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	public static void main(String[] args) {

	// hashCode()를 재정의한 이후
	HashcodeObject o3 = new HashcodeObject(100);
	HashcodeObject o4 = new HashcodeObject(100);
	
	System.out.println(o3==o4);
	System.out.println(o3.equals(o4));
	
	System.out.println(o3.hashCode());
	System.out.println(o4.hashCode());		
	
	/* hashCode()를 재정의하기 이전
	HashcodeObject o1 = new HashcodeObject();
	HashcodeObject o2 = new HashcodeObject();
	
	System.out.println(o1==o2);
	System.out.println( o1.equals(o2));
	
	System.out.println(o1.hashCode());
	System.out.println(o2.hashCode());
	*/
	
	}
}