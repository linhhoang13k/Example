package tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import tutorial.impl.MyCallable;

public class CallableThreads {
	
	private static final int NTHREADS = 10;
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
		List<Future<Long>> list = new ArrayList<Future<Long>>();
		for(int i = 0; i < 20000; i ++){
			Callable<Long> worker = new MyCallable();
			Future<Long> submit = executor.submit(worker);
			list.add(submit);
		}
		
		long sum = 0;
		System.out.println(list.size());
		for(Future<Long> future : list){
			try{
				sum += future.get();
			}catch (InterruptedException ie) {
				ie.printStackTrace();
			}catch (ExecutionException ee) {
				ee.printStackTrace();
			}
		}
		System.out.println(sum);
		executor.shutdown();
	}

}
