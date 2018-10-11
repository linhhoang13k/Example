package tiendm.codefight.challenge.april;

public class SimplePresent {
	String simplePresent(String[] elements) {
		StringBuilder sb = new StringBuilder();
		String sub = elements[0];
		String verb = elements[1];
		String oth = elements[2];
		if (verb.toLowerCase().equals("be")) {
			if (sub.toLowerCase().equals("i"))
				sb.append(sub + " am " + oth);
			else if (noNeedCon(sub) || sub.charAt(sub.length() - 1) == 's')
				sb.append(sub + " are " + oth);
			else
				sb.append(sub + " is " + oth);
		} else if (verb.toLowerCase().equals("have")) {
			if (noNeedCon(sub) || sub.charAt(sub.length() - 1) == 's')
				sb.append(sub + " have " + oth);
			else
				sb.append(sub + " has " + oth);
		}

		else if (noNeedCon(sub) || sub.charAt(sub.length() - 1) == 's')
			sb.append(sub + " " + verb + " " + oth);
		else
			sb.append(sub + " " + verb+(checkES(verb) ? "es": "s") + " " + oth);
		return sb.toString();
	}

	boolean noNeedCon(String sub) {
		String s = sub.toLowerCase();
		if (s.equals("i"))
			return true;
		String[] arr = { "and", "these", "those", "we", "they", "you" };
		for (int i = 0; i < arr.length; i++)
			if (s.contains(arr[i]))
				return true;
		return false;
	}

	boolean ifIs(String s) {
		String[] a = { "he", "she", "it", "that", "this" };
		for (int i = 0; i < a.length; i++)
			if (s.toLowerCase().equals(a[i]))
				return true;
		return false;
	}

	boolean checkES(String s) {
		String[] arrEnds = { "o", "s", "x", "z", "ch" };
		for (String x : arrEnds) {
			if (s.endsWith(x))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		SimplePresent sp = new SimplePresent();
		String[] s = { "John", "match", "socks" };
		System.out.println(sp.simplePresent(s));
	}
}
