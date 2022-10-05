package control;

public class BreakAndContinue {
	
	public void breakTest() {
		int n=1;
		while(n<10) {
			n++;
			if(n>5) break;
			System.out.println(n);
		}
	}
	
	public static void main(String[] args) {
		BreakAndContinue ex = new BreakAndContinue();
		ex.breakTest();
	}
}
