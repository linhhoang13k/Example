import java.util.Arrays;

public class Principal {

	public static void main(String[] args) {
		// System.out.println("Duração da chamada em minutos: " + phoneCall(1,
		// 2, 1, 6));
		// verificaSomaItemVertor();
		// System.out.println(strstr("aaaA", "aaA"));

		// System.out.println(shapeArea(3));

		// int[] a = { 6, 2, 3, 8 };
		// System.out.println(makeArrayConsecutive2(a));

		// int[] b = { 1, 3, 2 };
		// System.out.println(almostIncreasingSequence(b));

		/*
		 * int[][] matrix = { {1,1,1,0 }, {0,5,0,1}, {2,1,3,10} };
		 * 
		 * System.out.println(matrixElementsSum(matrix));
		 */

		System.out.println(stringReformatting("2-4a0r7-4k", 4));

	}

	static String stringReformatting(String s, int k) {
		String fatiada = s.replace("-", "");
		String alterada = "";
		int posicao;
		if (fatiada.length() % k == 0) {
			posicao = k;
		} else {
			posicao = fatiada.length() % k;
		}
		for (int i = 0; i < fatiada.length(); i++) {
			if (i != 0 && posicao == i) {
				alterada += "-";
				alterada += fatiada.charAt(i);
				posicao += k;
			} else {
				alterada += fatiada.charAt(i);
			}
		}
		return alterada;
	}

	static int matrixElementsSum(int[][] matrix) {
		int soma = 0;
		if (matrix.length > 0) {
			if (matrix.length != matrix[0].length) {
				for (int i = 1; i < matrix.length; i++) {
					for (int j = 0; j < matrix[i].length; j++) {
						if (matrix[i - 1][j] > 0) {
							soma += matrix[i - 1][j];
						}
					}
				}
			} else {
				for (int i = 1; i < matrix.length + 1; i++) {
					for (int j = 0; j < matrix[i - 1].length; j++) {
						if (matrix[i - 1][j] > 0) {
							soma += matrix[i - 1][j];
						}
					}
				}
			}
		}
		return soma;
	}

	static boolean almostIncreasingSequence(int[] sequence) {
		int counter = 0;
		for (int x = 1; x < sequence.length; x++) {
			if (x >= 2)
				if (sequence[x] == sequence[x - 2]) {
					counter++;
					continue;
				}
			if (sequence[x] <= sequence[x - 1]) {
				counter++;
				if (counter == 1 && x >= 2)
					if (sequence[x] <= sequence[x - 2])
						counter++;
			}
		}
		if (counter == 1)
			return true;
		return false;
	}

	static int makeArrayConsecutive2(int[] statues) {
		int quantidadeEstatuas = 0;
		Arrays.sort(statues);
		for (int i = 1; i < statues.length; i++) {
			if (statues[i] - statues[i - 1] > 1) {
				quantidadeEstatuas += (statues[i] - statues[i - 1]) - 1;
			}
		}
		return quantidadeEstatuas;
	}

	static int shapeArea(int n) {
		int poligono = n * n;
		for (int i = 2; i <= n; i++) {
			poligono += n - 1;
		}
		return poligono;
	}

	int[] sortedSquaredArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = array[i] * array[i];
		}
		Arrays.sort(array);
		return array;
	}

	String sortByString(String s, String t) {
		String retorno = "";
		for (int i = 0; i < t.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (t.charAt(i) == s.charAt(j)) {
					retorno += t.charAt(i);
				}
			}
		}
		return retorno;
	}

	int adjacentElementsProduct(int[] inputArray) {
		int maiorProduto = inputArray[0] * inputArray[1];
		if (inputArray.length > 2) {
			for (int i = 1; i < inputArray.length - 1; i = i + 1) {
				if (inputArray[i] * inputArray[i + 1] > maiorProduto) {
					maiorProduto = inputArray[i] * inputArray[i + 1];
				}
			}
		}
		return maiorProduto;
	}

	// Verifica se valor de S pode satisfazer quantidades de minutos fornecidos
	static int phoneCall(int min1, int min2_10, int min11, int s) {
		int chamada = 0;
		if (s > 0 && s >= min1 && min1 > 0) {
			s -= min1;
			chamada++;
		}
		if (s > 0 && s >= min2_10 && min2_10 > 0) {
			for (int i = 0; i < 9; i++) {
				s -= min2_10;
				chamada++;
				if (s < min2_10) {
					return chamada;
				}
			}
		}
		if (s > 0 && s >= min11 && min11 > 0) {
			chamada += s / min11;
		}
		System.out.println("Duração da chamada em minutos: " + chamada);
		return chamada;
	}

	static void verificaSomaItemVertor() {
		int[] a = { 1, 2, 3 };
		int[] b = { 10, 20, 30, 40 };
		int v = 43;

		System.out.println(sumOfTwo(a, b, v));
	}

	// Verifica se valor de v aparece na soma de posições dos vetores
	static boolean sumOfTwo(int[] a, int[] b, int v) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] + b[j] == v) {
					return true;
				}
			}
		}
		return false;

	}

	// Verificar ocorremcia de String
	static int strstr(String s, String x) {
		if (s.contains(x)) {
			if (s.length() == x.length()) {
				return 0;
			}
			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < x.length(); j++) {
					String a = s.substring(i, s.length());
					if (a.substring(0, x.length()).equals(x)) {
						return i;
					}
				}
			}
		}
		return -1;
	}
}
