package tutorial.algorithm;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class Solver extends RecursiveTask<Long>{
	private int[] list;
	public long result;
	
	public Solver(int[] array){
		this.list = array;
	}
	
	@Override
	protected Long compute(){
		if(list.length == 1){
			long sum = 0;
			sum += list[0];
			return sum;
		}else{
			int midpoint = list.length/2;
			int[] l1 = Arrays.copyOfRange(list, 0, midpoint);
			int[] l2 = Arrays.copyOfRange(list, midpoint, list.length);
			Solver s1 = new Solver(l1);
			Solver s2 = new Solver(l2);
			s1.fork();
			
			return s2.compute() + s1.join();
		}
	}
	
}
