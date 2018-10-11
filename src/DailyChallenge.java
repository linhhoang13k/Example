package CodeFight;

import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tranpham on 2/22/18.
 */
public class DailyChallenge {

    public static void main(String[] args){

    }


    public String swappingLetters(String text) {
        Matcher matcher = Pattern.compile("\\[([a-z]<->[a-z])\\]").matcher(text);
        while (matcher.find()){
            matcher.group(0).charAt(0);//a<->b
            matcher.group(0).charAt(4);
        }
        return "";
    }
    public String swappingLetters2(String text) {
        StringBuffer buff = new StringBuffer();
        char[] code = new char[text.length()];
        char[] decode = new char[text.length()];
        int stkIdx=-1;
        for(int i=0;i<text.length();i++){
            char c = text.charAt(i);
            if(c=='[' && text.charAt(i+2)=='<'
                    && text.charAt(i+3)=='-'
                    && text.charAt(i+4)=='>'
                    && text.charAt(i+6)==']'){
                stkIdx++;
                code[stkIdx]=text.charAt(i+1);
                decode[stkIdx]=text.charAt(i+5);
                i+=6;//[a<->b]
            } else {
                for(int k =stkIdx;k>=0;k--)
                    if (code[k]==c || code[k]==c-'A'+'a'){
                        int ex=0;
                        if (code[k]==c-'A'+'a')
                            ex='A'-'a';
                        c=(char)(decode[k]+ex);

                    } else if (decode[k]==c || decode[k]==c-'A'+'a'){
                        int ex=0;
                        if (decode[k]==c-'A'+'a')
                            ex='A'-'a';
                        c=(char)(code[k]+ex);
                    }
                buff.append(c);
            }

        }
        return buff.toString();
    }

    public static Node reverseList(Node list, int k){
        Stack<Integer> stk = new Stack<>();
        Node current = list;
        int i=1;
        /*X-9-X-7-X-5-X-3-X-1*/
        while (current!=null){
            if(i%k!=0)
                stk.push(current.data);
            i++;
            current=current.nextNode;
        }
        i=1;
        current=list;
        while (!stk.empty()){
            if(i%k!=0){
                current.data=stk.pop();
            }
            i++;
            current=current.nextNode;
        }
        /* 1-2-3-4-5-6-7-8-9-10*/
        /* 9-2-7-4-5-6-3-8-1-10*/

        return list;
    }

    /**
     * Created by tranpham on 2/22/18.
     */

    public static String coolMachine(String tape, String[] program) {
        char[][] prog_matrix = new char[program.length][5];
        HashMap<String,String> hm = new HashMap<>();
        for(String p:program){

            int state = p.charAt(0)-'0';
            int read = p.charAt(2)-'0';
            prog_matrix[state][read]=p.charAt(4);//write;
            prog_matrix[state][2]=p.charAt(6);//move;
            prog_matrix[state][3+read]=p.charAt(8);//next_state;
        }

        int cur_state = 0; // current state
        int tid=0;//tape index
        char[] tapeChars = tape.toCharArray();
        while(cur_state!=9){
            int outValIdx= tapeChars[tid]-'0';
            tapeChars[tid]=prog_matrix[cur_state][outValIdx];
            tid+= prog_matrix[cur_state][2]=='L'?-1:1;
            cur_state = prog_matrix[cur_state][3+outValIdx]-'0';
        }
        return new String(tapeChars);
    }
}