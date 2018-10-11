package exploringtwo.the.waters;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AreSimilarUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		int[] a = { 1, 2, 3 };
		int[] b = { 1, 2, 3 };

		boolean result = areSimilar(a, b);

		assertTrue(result);
	}

	@Test
	public void test2() {
		int[] a = { 1, 2, 3 };
		int[] b = { 2, 1, 3 };

		boolean result = areSimilar(a, b);

		assertTrue(result);
	}

	@Test
	public void test6() {
		int[] a = { 2, 3, 1 };
		int[] b = { 1, 3, 2 };

		boolean result = areSimilar(a, b);

		assertTrue(result);
	}

	@Test
	public void test9() {
		int[] a = { 832, 998, 148, 570, 533, 561, 894, 147, 455, 279 };
		int[] b = { 832, 998, 148, 570, 533, 561, 455, 147, 894, 279 };

		boolean result = areSimilar(a, b);

		assertTrue(result);
	}

	boolean areSimilar(int[] a, int[] b) {

		boolean areEquals = Arrays.equals(a, b);

		List<Integer> aSwap = new ArrayList<>();
		List<Integer> bSwap = new ArrayList<>();

		for (int i = 0; i < a.length && !areEquals; i++) {

			if (a[i] != b[i]) {
				aSwap.add(a[i]);
				bSwap.add(b[i]);
			}
		}


		if (aSwap.size() > 2)
			areEquals = false;
		else if (aSwap.size() == 2)
			areEquals = aSwap.get(0).equals(bSwap.get(1)) && bSwap.get(0).equals(aSwap.get(1));


		return areEquals;
	}

	void swapPair(int[] v, int i, int j) {
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}


}
