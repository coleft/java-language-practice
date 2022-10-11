package interfaceEx;

public class AfterMember implements MemberInterface{

	String abc;
	
	@Override
	public void setName(String name) {
		this.abc = name;
		
	}

	@Override
	public String getName() {
		return this.abc;
	}
	
}
