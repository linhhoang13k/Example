package tutorial;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import tutorial.impl.Counter;

public class AtomicTest {

	private static final int NTHREDS = 10;

	public static void main(String[] args) {
		final Counter counter = new Counter();
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
		for(int i = 0; i < 500; i++){
			Callable<Integer> worker = new Callable<Integer>() {
				@Override
				public  Integer call() throws Exception{
					int number = counter.increment();
					System.out.println(number);
					return number;
				}
			};
			Future<Integer> submit = executor.submit(worker);
			list.add(submit);
		}

		executor.shutdown();

		while(!executor.isTerminated()){
		}
		Set<Integer> set = new HashSet<>();
		for(Future<Integer> future : list){
			try{
				set.add(future.get());
			}catch(InterruptedException ie){

			}catch(ExecutionException ee){

			}

		}
		if(list.size() != set.size()){
			throw new RuntimeException("Double-entries!!!");
		}
	}

}
