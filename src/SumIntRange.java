package SumIntRange;
import java.util.HashMap;
import java.util.Map;

public class SumIntRange {

	public static void Main(String args) {

		int[] nums = { 34, 19, 21, 5, 1, 10, 26, 46, 33, 10 };

		int[][] queries = { { 3, 7 }, { 3, 4 }, { 3, 7 }, { 4, 5 }, { 0, 5 } };

		System.out.println(sumIntRange(nums, queries));

	}

	static int sumIntRange(int[] nums, int[][] queries) {

		//
		if (nums == null || nums.length == 0)
			return 0;
		if (queries == null || queries.length == 0)
			return 0;

		int total = 0;
		Map<Integer, Integer> s = new HashMap<Integer, Integer>();
		int sum = 0;
		int mod = 1000000007;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			s.put(i, sum % mod);
		}

		for (int i = 0; i < queries.length; i++) {

			Integer val1 = (Integer) s.get(queries[i][0] - 1);
			Integer val2 = (Integer) s.get(queries[i][1]);
			if (queries[i][0] == 0) {
				val1 = 0;
				val2 = (Integer) s.get(queries[i][1]);
			} else {
				val1 = (Integer) s.get(queries[i][0] - 1);
				val2 = (Integer) s.get(queries[i][1]);
			}

			total = total % mod + (val2 - val1) % mod;
		}

		return (total + mod) % mod;

	}
}
