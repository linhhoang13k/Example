package tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import tutorial.impl.MyRunnable;

public class Threads {

	private static final int NTHREADS = 10;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		List<Thread> threads = new ArrayList<Thread>();
//		
//		for(int i = 0; i < 500; i++){
//			Runnable task = new MyRunnable(10000000L + i);
//			Thread worker = new Thread(task);
//			worker.setName(String.valueOf(i));
//			worker.start();
//			threads.add(worker);
//		}
//		
//		int running = 0;
//		do {
//			running = 0;
//			for(Thread thread : threads){
//				if(thread.isAlive()){
//					running ++;
//				}
//			}
//			
//			System.out.println("We have " + running + " running threads");
//			
//		}while (running > 0);
		
		ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
		for(int i = 0; i < 500; i++){
			Runnable worker = new MyRunnable(10000000L + i);
			executor.execute(worker);
		}
		executor.shutdown();
		executor.awaitTermination(10000000L, TimeUnit.MILLISECONDS);
		System.out.println("Finished all threads");
		
		
	}

}
