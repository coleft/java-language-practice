package thread;

public class Bank {
	int amt = 1000;
	public synchronized void output(String n, int a) {	//출금 synchronized가 있으면 메서드 자체가 하나밖에 못 들어옴.		
		if(amt>a) {
			try {
				Thread.sleep(100);
				amt -= a;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		System.out.print(n + " >>> " );
		System.out.printf("출금:%5d, 잔액:%5d\n", a, amt);
	}
}
