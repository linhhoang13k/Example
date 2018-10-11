package codefighters;

public class BookMarket {
	static String properNounCorrection(String noun) {
		noun = noun.toLowerCase();
		return noun.substring(0, 1).toUpperCase() + noun.substring(1);
	}

	static boolean isTandemRepeat(String inputString) {
		if(inputString.substring(0, inputString.length()/2).equals(inputString.substring(inputString.length()/2))){
			return true;
		}
		return false;
	}

	static boolean isCaseInsensitivePalindrome(String inputString) {
		char[]tmp = inputString.toUpperCase().toCharArray();
		for(int i = 0; i<tmp.length/2;i++){
			if(tmp[i] != tmp[tmp.length-1-i]){
				return false;
			}
		}
		return true;
	}


	static String findEmailDomain(String address) {
		return address.substring(address.lastIndexOf("@")+1);
	}

	static String htmlEndTagByStartTag(String startTag) {
		if(startTag.indexOf(" ") >= 0){
			return "</" + startTag.substring(1, startTag.indexOf(" ")) + ">";
		}
		return "</" + startTag.substring(1, startTag.indexOf(">")) + ">";
	}

	static boolean isMAC48Address(String inputString) {
		if(inputString.matches("^[A-F0-9][A-F0-9](-[A-F0-9][A-F0-9]){5}"))
			return true;
		return false;
	}

	static boolean isUnstablePair(String filename1, String filename2) {
		if((filename1.compareTo(filename2) < 0 && filename1.compareToIgnoreCase(filename2) < 0) || (filename1.compareTo(filename2) > 0 && filename1.compareToIgnoreCase(filename2) > 0)){
			return false;
		}
		return true;
	}



}
