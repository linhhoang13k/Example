String RemoveAdjacentLetters(String N) {
	String res = "";
	char current = N.charAt(0);
		for(int i=1; i<N.length(); i++) {
			if(!(N.charAt(i)==current)) {
				res = res+current;
				current = N.charAt(i);
			}
		}
	return res+current;
}
