package tiendm.codefight.introduction;

public class Level10 {
	String buildPalindrome(String s) {
		char[] arrInput = s.toCharArray();
		StringBuilder builder = new StringBuilder(s);
		for(int i = arrInput.length - 2; i >= 0; i--) {
			builder.append(arrInput[i]);
		}
		String strMax = builder.toString();
		
		int center = s.length() / 2;
		while (center < s.length() - 1) {
			String strAddMax = strMax.substring(center+1);
			StringBuilder sCheck = new StringBuilder();
			for (int count = center ; count >= 0; count--) {
				sCheck.append(arrInput[count]);
			}
			if(strAddMax.indexOf(sCheck.toString()) < strAddMax.lastIndexOf(sCheck.toString())) break;
			center++;
		}
		
		int length = 0;
		if(center == s.length()-1) return strMax;
		else if(arrInput[center] != arrInput[center+1]){
			if(arrInput[center-1] == arrInput[center+1]){
				length = 2 * center + 1;
			}else{
				length = 2 * (center + 1) + 1;
			}
		}else {
			length = 2 * (center + 1);
		}
		
		int nbAdd = length - s.length();
		StringBuilder builderResult = new StringBuilder(s);
		for(int i = nbAdd - 1; i >= 0; i--){
			builderResult.append(arrInput[i]);
		}
		
		return builderResult.toString();
	}
	
	boolean isValidNumber(String s, boolean n, boolean c, boolean d) {
		if(!n && s.startsWith("-")) return false;
		String pattern = "^-?\\.?[0-9]+([\\.,\\,]\\d+)*$";
		if(!s.matches(pattern)) return false;
		if(s.split("\\.").length > 2) return false;
	    if(!d) {
	    	if(s.indexOf('.') >= 0) return false;
	    }
	    if(c){
	    	if(!s.contains(",")) return true;
	    	else {
	    		if(s.indexOf('.') >=0 ){
	    			String[] arr = s.split("\\.");
	    			if(arr.length == 1) return false;
	    			if(arr[1].contains(",")) return false;
	    			s = arr[0];
	    		}
	    		if(s.endsWith(",") || s.startsWith(",")) return false;
	    		String[] arrSplitCommma = s.split(",");
	    		if(arrSplitCommma[0].length() > 3 ) return false;
	    		for(int i = 1; i < arrSplitCommma.length; i++){
	    			if(arrSplitCommma[i].length() != 3) return false;
	    		}
	    	}
	    }
	    return true;
	}
	
	int electionsWinners(int[] votes, int k) {
		int max = Integer.MIN_VALUE, nbMax = 0;
	    for(int i = 0; i < votes.length; i++) {
	        if(votes[i] == max) nbMax++;
	        else if(votes[i] > max) {
	        	max = votes[i];
	        	nbMax = 1;
	        }
	    }
	    if(nbMax > 1 && k==0) return 0;
	    int count = 0;
	    for(int i = 0; i < votes.length; i++) {
	        if(votes[i] + k > max) count++;
	    }
	    return count + (k==0 ? 1: 0);
	}
	
	boolean isMAC48Address(String inputString) {
		if(!checkRange(inputString.charAt(inputString.length()-1))) return false;
		String[] arrInput = inputString.split("-");
		if(arrInput.length != 6) return false;
		for(String s : arrInput){
			if(!checkIp(s)) return false;
		}
		return true;
	}

	boolean checkIp(String s) {
		if(s.length() != 2) return false;
		if(checkRange(s.charAt(0))
				&& (checkRange(s.charAt(1)))) {
			return true;
		}
		return false;
	}
	
	boolean checkRange(char c){
		if((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F')) return true;
		return false;
	}
	
	public static void main(String[] args) {
		Level10 test = new Level10();
		String s = "-123456,123,123.0001";
		System.out.println(test.isValidNumber(s,true,true,true));
//		String s2 = "abcdc";
//		System.out.println(test.buildPalindrome(s2));
//		int[] x = {5, 1, 3, 4, 1};
//		System.out.println(test.electionsWinners(x,0));
	}
}
