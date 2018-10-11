package tutorial;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureSimpleSnippet {

	public static void main(String[] args) {
		long started = System.currentTimeMillis();
		
		CompletableFuture<Integer> futureCont = createCompletableFuture();
		
		System.out.println("Took " + (started - System.currentTimeMillis()) + " milliseconds" );
		
		try{
			int count = futureCont.get();
			System.out.println("CompletableFuture took " + (started - System.currentTimeMillis()) + " milliseconds" );
			System.out.println("Result " + count);
		}catch (InterruptedException | ExecutionException ex) {
			// TODO: handle exception
		}
		
		
	}

	private static CompletableFuture<Integer> createCompletableFuture(){
		CompletableFuture<Integer> futureCont = CompletableFuture.supplyAsync(
				() ->
				{
					try{
						Thread.sleep(6000);
					}catch (InterruptedException e) {
					}
					return 20;
				});
		return futureCont;
	}
	
}
