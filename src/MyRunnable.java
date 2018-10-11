package tutorial.impl;

public class MyRunnable implements Runnable {
	private final long countUntil;
	
	public MyRunnable(long countUntil) {
		// TODO Auto-generated constructor stub
		this.countUntil = countUntil;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long sum = 0;
		for(long i = 0; i < countUntil; i++){
			sum += i;
		}
		System.out.println(sum);
	}

}
