package tutorial;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureCallback {

	public static void main(String[] args) {
		long started = System.currentTimeMillis();

		CompletableFuture<String> data = createCompletableFuture().thenApply(
				(Integer count) -> {
					int transformedValue = count * 10;
					return transformedValue;
				}
				).thenApply(transformed -> "Finally creates a string: " + transformed);

		try{
			System.out.println(data.get());
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

	private static CompletableFuture<Integer> createCompletableFuture(){
		CompletableFuture<Integer> result = CompletableFuture.supplyAsync(()
				->
		{
			try{
				Thread.sleep(5000);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return 20;
		}
				);
		return result;
	}

}
