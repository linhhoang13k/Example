package tiendm.codefight.challenge.may;

public class ReversesreveR {
	int reversesreveR(String inputString) {
		int idx = 1;
		while (isDigit(inputString.substring(0, idx))) {
			idx++;
		}
		idx--;
		int num1 = Integer.parseInt(new StringBuilder(inputString.substring(0,idx)).reverse().toString());
		int num2 = Integer.parseInt(new StringBuilder(inputString.substring(0,idx)).reverse().toString());
		char oprator = inputString.charAt(idx);
		switch (oprator) {
		case '+':
			return num1+num2;
		case '-':
			return num1-num2;
		case '*':
			return num1*num2;
		case '/':
			return num1/num2;
		case '%':
			return num1%num2;
		case '^':
			return (int) Math.pow(num1, num2);
		default:
			return 0;
		}
	}
	boolean isDigit(String x){
		try {
			Integer.parseInt(x);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	 public static void main(String[] args) {
		ReversesreveR test = new ReversesreveR();
		System.out.println(test.reversesreveR("80^40"));
	}
}
