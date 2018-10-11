package companyBots.spaceX;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PacketDescrambler {

	public static String EMPTY = "";

	/**
	 * @param seq
	 * @param fragmentData
	 * @param n
	 * @return
	 */
	String packetDescrambler(int[] seq, char[] fragmentData, int n) {
		Map<Integer, Map<Character, Integer>> map = new TreeMap<>();
		for (int i = 0; i < seq.length; i++) {
			int ss = seq[i];
			Map<Character, Integer> charMap = map.get(ss);
			if (charMap == null) {
				charMap = new HashMap<>();
				map.put(ss, charMap);
				charMap.put(fragmentData[i], 1);
			} else {
				Integer counter = charMap.get(fragmentData[i]);
				if (counter == null) {
					charMap.put(fragmentData[i], 1);
				} else {
					charMap.put(fragmentData[i], counter + 1);
				}
			}
		}

		Set<Integer> keys = map.keySet();
		StringBuilder sb = new StringBuilder();
		int lastNumber = -1;
		for (Integer key : keys) {
			if (key != lastNumber + 1) {
				return EMPTY;
			}
			Map<Character, Integer> charMap = map.get(key);
			Set<Character> seqs = charMap.keySet();
			Character result = null;
			int max = -1;
			for (Character ss : seqs) {
				Integer val = charMap.get(ss);
				if (((double)val/n)*100 >50) {
					if (max < val) {
						result = ss;
						max = val;
					}
				}
			}
			if (result == null) {
				return EMPTY;
			} else {
				sb.append(result);
			}
			lastNumber = key;
		}
		String results = sb.toString();
		if (results.endsWith("#")) {
			return results;
		}
		return EMPTY;
	}

	public static void main(String[] args) {
		int[] seq = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		char[] fragmentData = { '+', '+', 'A', 'A', 'B', '#', '#', '#', '#', '#' };

		int n = 3;
		PacketDescrambler test = new PacketDescrambler();
		String result = test.packetDescrambler(seq, fragmentData, n);
		System.out.println(result);

	}

}
