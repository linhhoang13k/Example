package tiendm.codefight.tournament.sep;

import java.util.Arrays;

public class Tour0809 {
	boolean checkSameElementExistence(int[] arr1, int[] arr2) {
		Arrays.sort(arr2);
		for (int i : arr1) {
			if (binarySearch(arr2, i, 0, arr2.length - 1))
				return true;
		}
		return false;
	}

	private boolean binarySearch(int[] arr, int i, int begin, int end) {
		if (begin == end) {
			return arr[begin] == i;
		}
		int mid = (begin + end) / 2;
		if (arr[mid] == i)
			return true;
		else if (arr[mid] < i) {
			return binarySearch(arr, i, mid + 1, end);
		} else {
			return binarySearch(arr, i, begin, mid);
		}
	}

	int[] robotPath(String instructions, int bound) {
		int[] r = new int[2];
		for (int i = 0; i < instructions.length(); i++) {
			move(r, instructions.charAt(i), bound);
		}
		return r;
	}

	void move(int[] x, char charAt, int bound) {
		switch (charAt) {
		case 'L':
			if (x[0] > -bound)
				x[0]--;
			break;
		case 'R':
			if (x[0] < bound)
				x[0]++;
			break;
		case 'D':
			if (x[1] > -bound)
				x[1]--;
			break;
		case 'U':
			if (x[1] < bound)
				x[1]++;
			break;
		default:
			break;
		}
	}

	String deleteWhitespaces(String inputStr) {
		String s = "";
		String[] x = inputStr.split(" ");
		for (String a : x) {
			s += a.trim();
		}
		return s;
	}

	String htmlEndTagByStartTag(String startTag) {
		int idx = startTag.indexOf(" ");
		if (idx == -1) {
			idx = startTag.indexOf(">");
		}
		String tag = startTag.substring(0, idx);
		return tag.substring(0, 1) + "/" + tag.substring(1) + ">";
	}

	public static void main(String[] args) {
		Tour0809 t = new Tour0809();
		int[][] x = { { 0, 1, 2, 3 }, { 1, 2, 3, 0 }, { 1, 1, 1 } };
		int[] p = { 7, 5, 4, 4, 8 };
		System.out.println(t.htmlEndTagByStartTag("<li>"));
	}
}
