package thread;

public class ThreadEx {
	
	public void test1() {
		System.out.println("thread 테스트 시작.....");
		
		T t1 = new T();
		T t2 = new T();
		T t3 = new T();
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("thread 테스트 종료....");
	}
	
	public void test2() {
		R r1 = new R();
		R r2 = new R();
		R r3 = new R();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		
		System.out.println("스레드 테스트 시작");
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("스레드 테스트 종료");
	}
	
	public void test3() {	//데몬스레드
		T t1 = new T();
		System.out.println("메인 스레드 시작...");
		t1.setDaemon(true);		
		t1.start();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("메인 스레드 종료...");
	}
	
	public void test4() {	//join
		System.out.println("메인 스레드 시작");
		
		T t1 = new T();
		t1.start();
		
		
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("메인 스레드 종료...");
	}
	
	public static void main(String[] args) {
		
		new ThreadEx().test4();
		
		
		
	}
}

class T extends Thread{		
	@Override
	public void run() {
		for(int i = 0; i<200; i++) {
			System.out.print(this.getName() + " ");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}

class R implements Runnable{

	@Override
	public void run() {
		for(int i = 1; i<=200; i++) {
			System.out.printf("%4d", i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

