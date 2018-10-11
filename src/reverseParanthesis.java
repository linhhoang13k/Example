import java.util.Stack;

public class reverseParanthesis 
{
	public static void main (String v[])
	{
		String input = "a(bc)de";
		String r = reverseParenthesis(input);
		System.out.println(r);
	}
	static String reverseParenthesis(String s) 
	{
		char temp;
		char[] s1 = s.toCharArray();
		int count = 0;
		Stack<Integer> st = new Stack();
		for(int i=0;i<s1.length;i++)
		{
			if(s1[i]=='(')
			{
				st.push(i);
				count++;
			}
			if(s1[i]==')')
			{
				int end = (i-1);
				int begin = st.pop()+1;
				while(end>begin)
				{
					temp = s1[begin];
			        s1[begin]=s1[end];
			        s1[end] = temp;
			        end--;
			        begin++;
				}
				count++;
			}
		}
		char[] result = new char[s1.length-count];
		int j=0;
		for(int i=0;i<(s1.length);i++)
		{
			if(s1[i]!=')' && s1[i] != '(')
			{
				
				if(j<(s1.length-count))
				{
					System.out.println(i);
					result[j]=s1[i];
					j++;
				}
			}
		}
		String res = new String(result);
		return res;
	}
}
