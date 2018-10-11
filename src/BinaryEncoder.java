package exercise58;

public class BinaryEncoder {

	/*
	 * You are taking part in an Escape Room challenge designed specifically for
	 * programmers. In your efforts to find a clue, you've found a binary code
	 * written on the wall behind a vase, and realized that it must be an encrypted
	 * message. After some thought, your first guess is that each consecutive 8 bits
	 * of the code stand for the character with the corresponding extended ASCII
	 * code.
	 * 
	 * Assuming that your hunch is correct, decode the message.
	 */
	public String messageFromBinaryCode(String code) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= code.length() - 8; i += 8) {
			char c = (char) Integer.parseInt(code.substring(i, i+8), 2);
			sb.append(c);
		}
		String answer = sb.toString();
		return answer;
	}

}
