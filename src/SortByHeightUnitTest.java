package smooth.saling;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SortByHeightUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		int[] a = { -1, 150, 190, 170, -1, -1, 160, 180 };

		int[] result = sortByHeight(a);

		assertTrue(result[0] == -1);
		assertTrue(result[1] == 150);
		assertTrue(result[2] == 160);
		assertTrue(result[3] == 170);
		assertTrue(result[4] == -1);
		assertTrue(result[5] == -1);
		assertTrue(result[6] == 180);
		assertTrue(result[7] == 190);

	}

	int[] sortByHeight(int[] a) {

		int POSITION_TREE = -1;
		int leftTree = a[0] == POSITION_TREE ? 0 : POSITION_TREE;
		int rightTree = POSITION_TREE;

		for (int i = 1; i < a.length; i++) {

			if (a[i] == POSITION_TREE && leftTree == POSITION_TREE) {
				leftTree = i;
			}

			if (a[i] == POSITION_TREE && leftTree > POSITION_TREE && rightTree == POSITION_TREE) {
				rightTree = i;
			}

			if (leftTree > POSITION_TREE && rightTree > POSITION_TREE) {

				if ((rightTree - leftTree) > 1) {
					Arrays.sort(a, leftTree, rightTree);

				}

				leftTree = POSITION_TREE;
				rightTree = POSITION_TREE;
			}
		}

		sortAll(a);

		return a;
	}

	private void sortAll(int[] a) {
		List<Integer> aList = new ArrayList<>();

		int POSITION_TREE = -1;

		for (int i = 0; i < a.length; i++) {
			if (a[i] != POSITION_TREE)
				aList.add(a[i]);
		}

		Collections.sort(aList);
		Iterator<Integer> aIterator = aList.iterator();

		for (int i = 0; i < a.length; i++) {
			if (a[i] != POSITION_TREE) {
				a[i] = aIterator.next();
			}
		}

	}

}
