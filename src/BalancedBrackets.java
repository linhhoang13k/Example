import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedBrackets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            Stack<Character> stack = new Stack<Character>();
            int i = 0;
            for( ; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == '}'){
                    try{
                        if (stack.peek() == '{')
                            stack.pop();
                        else
                            break;
                    }
                    catch (Exception e){
                        break;
                    }
                }
                else if (c == ']'){
                     try{
                        if (stack.peek() == '[')
                            stack.pop();
                        else
                            break;
                    }
                    catch (Exception e){
                        break;
                    }
                }
                else if (c == ')'){
                     try{
                        if (stack.peek() == '(')
                            stack.pop();
                        else
                            break;
                    }
                    catch (Exception e){
                        break;
                    }
                }
                else
                    stack.push(c);
            }
            
            
            if(stack.size() == 0 && i == s.length())
                System.out.println("YES");
            else 
                System.out.println("NO");
                     
            
            
        }
    }
}
