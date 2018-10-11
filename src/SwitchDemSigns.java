/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package switchdemsigns;

/**
 *
 * @author epiercy
 */
public class SwitchDemSigns {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwitchDemSigns s = new SwitchDemSigns();
        String out = s.switchDemSigns("a + b - (c + d - {e})");
        System.out.print(out);
    }
    
    public String switchDemSigns(String linEq){
        int numBrs = 0;
        int len = linEq.length();
        StringBuilder resp = new StringBuilder();
        //check the first char...
        //first, is this char a bracket?
        
        char c = linEq.charAt(0);
        //if bracket...
        if(c == '(' || c == '{' || c == '['){
                ++numBrs;
                resp.append("- ");
                resp.append(c);
        }
        else if(c == '-'){
            resp.append("+");
        }
        else if(c != '-'){ //if it's not a minus sign and not a bracket, it's a char, so append...
            resp.append("- ");
            resp.append(c);
        }
        for(int i = 1; i < len; i++){
            c = linEq.charAt(i);
            //is this character a bracket?
            if(c == '(' || c == '{' || c == '['){
                ++numBrs;
                resp.append(c);
            }    
            else if(c == ')' || c == '}' || c == ']'){
                --numBrs;
                resp.append(c);
            }
            //ok, brackets are taken care of, now what about inversions?
            //if I have an uneven amount of brackets and I get a + or a -, I need to switch, ON THE OUTSIDE
            else if(numBrs == 0 && (c == '+' || c == '-')){
                if(c == '+')
                    resp.append('-');
                else
                    resp.append('+');
            }
            //otherwise, just append the original character
            else
                resp.append(c);
        }
        return resp.toString();
    }
    
}
