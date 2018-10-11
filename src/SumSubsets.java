/*
Given a sorted array of integers arr and an integer num, find all possible unique subsets of arr that add up to num. Both the array of subsets and the subsets themselves should be sorted in lexicographical order.
*/

int[][] sumSubsets(int[] arr, int n) {
	List<Integer> list = new ArrayList<Integer>();
	List<List<Integer>> rs = new ArrayList<List<Integer>>();
	boolean[] bt = new boolean[arr.length];
	canculate(arr, n, 0, bt, list, rs);
	rs = removeDuplicate(rs);
	return convert(rs);
}

List<List<Integer>> removeDuplicate(List<List<Integer>> input) {
	HashMap<String, Boolean> hash = new HashMap<String, Boolean>();
	List<List<Integer>> rs = new ArrayList<List<Integer>>();
	for (List<Integer> list : input) {
		String temp = "";
		for (Integer integer : list) {
			temp += integer + "|";
		}
		if (!hash.containsKey(temp)) {
			rs.add(list);
			hash.put(temp, true);
		}
	}
	return rs;
}

void canculate(int[] arr, int n, int element, boolean[] bt,
		List<Integer> list, List<List<Integer>> rs) {
	if (n == 0) {
		rs.add(list);
	} else {
		for (int i = element; i < arr.length; i++) {
			if (!bt[i]) {
				if (n - arr[i] >= 0) {
					List<Integer> con = cloneList(list);
					bt[i] = true;
					con.add(arr[i]);
					canculate(arr, n - arr[i], i + 1, bt, con, rs);
					bt[i] = false;
				}
			}
		}
	}

}

List<Integer> cloneList(List<Integer> list) {
	List<Integer> rs = new ArrayList<Integer>();
	for (Integer integer : list) {
		rs.add(integer);
	}
	return rs;
}

int[][] convert(List<List<Integer>> list) {
	int[][] result = new int[list.size()][];
	for (int i = 0; i < list.size(); i++) {
		List<Integer> temp = list.get(i);
		result[i] = new int[temp.size()];
		for (int j = 0; j < temp.size(); j++) {
			result[i][j] = temp.get(j);
		}
	}
	return result;
}