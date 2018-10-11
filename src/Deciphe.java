
	String decipher(String cipher) {

		  String result = "";
		  for (int i = 0; i < cipher.length(); ) {
		    int len;
		    if (cipher.charAt(i) != '9') {
		      len = 3;
		    } else {
		      len = 2;
		    }
		    int code = Integer.parseInt(cipher.substring(i, i + len));
		    result += (char) code;
		    i += len;
		  }

		  return result;
		}
