
public class Monitor {

	// Verificar ocorremcia de String
	static int strstr(String s, String x) {
		final int sizeX = x.length();
		final int sizeS = s.length();
		if (sizeX > sizeS) {
			return -1;
		}
		if (s.equals(x)) {
			return 0;
		}
		if (s.contains(x)) {
			for (int i = 0; i < sizeS; i++) {
				for (int j = 0; j < sizeX; j++) {
					String a = s.substring(i, sizeS);
					if (a.substring(0, sizeX).equals(x)) {
						return i;
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// Memória total
		System.out.println("Memória total: " + Runtime.getRuntime().totalMemory());

		// Memória livre
		System.out.println("Memória livre: " + Runtime.getRuntime().freeMemory());

		// Tempo de inicio
		long initialTime = System.nanoTime();

		System.out.println(strstr("aaaA", "aaA"));

		System.out.println("Tempo de execução total --> " + (System.nanoTime() - initialTime));

		System.out.println("Memória total: " + Runtime.getRuntime().totalMemory());

		// Memória livre
		System.out.println("Memória livre: " + Runtime.getRuntime().freeMemory());

	}

}
