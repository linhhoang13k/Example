String caesarBoxCipherEncoding(String inputString) {

      int n = (int)Math.sqrt(inputString.length());
		  String ans = "";
		  for (int i = 0; i < n; i++) {
		    for (int j = 0; j < n; j++) {
		      ans +=  inputString.charAt((n*j)+i) ;
		    }
		  }

		  return ans;
}
