package tiendm.codefight.challenge.april;

public class MeaningOfLife {
	long meaningOfLife2(String n) {
		long base = 42, x = 0;
		long sum = 0;
		for(int i = 0; i < n.length(); i++){
			char c = n.charAt(i);
			if(c >= '0' && c <= '9'){
				x = c - '0';
			}
			else if(c >= 'A' && c <= 'Z'){
				x = c - 'A' + 10;
			}
			else if(c >= 'a' && c <= 'z'){
				x = c - 'a' + 36;
			}
			sum += x * Math.pow(base, n.length()-1-i);
		}
		return sum;
	}
	
	long meaningOfLife(String n) {
		long b = 42, x = 0, s = 0;
		for(int i = 0; i < n.length(); i++) {
			char c = n.charAt(i);
				x = (c >= '0' && c <= '9') ? c - '0' : ((c >= 'A' && c <= 'Z') ? c - 'A' + 10 : c - 'a' + 36);
			s += x * Math.pow(b, n.length()-1-i);
		}
		return s;
	}
	public static void main(String[] args) {
		MeaningOfLife mean = new MeaningOfLife();
		String n = "ABC";
		System.out.println(mean.meaningOfLife(n));
	}
}
