package interview;

public class ParenthesisPair {

	public static void main(String[] args) {
		String in = "([f{h<sss>}d])";

		ParenthesisPair instance = new ParenthesisPair();
		System.out.println(instance.isPair(in));

	}

	public boolean isPair(String in){
		int i = 0;
		while(i < in.length()){
			if(in.charAt(i) == '(' || in.charAt(i) == '[' || in.charAt(i) == '{' || in.charAt(i) == '<'){
				if(isPair(in.substring(i+1), in.charAt(i)) == -1)
					return false;
				else
					return true;
			}
			i++;
		}
		
		return false;
	}
	
	public int isPair(String in, char a){
		int i = 0;

		switch (a){
		case '(': 
			a = ')';
			break;
		case '[':
			a = ']';
			break;
		case '{':
			a = '}';
			break;
		case '<':
			a = '>';
			break;
		}
		while(i < in.length()){
			if(in.charAt(i) == '(' || in.charAt(i) == '[' || in.charAt(i) == '{' || in.charAt(i) == '<'){
				int tmp = isPair(in.substring(i+1), in.charAt(i));
				if(tmp == -1){
					return -1;
				}else{
					i+=tmp;
				}
			}
			if(in.charAt(i) == a ){
				return i + 2;
			} 
			i++;
		}
		
		
		return -1;
	}


}
