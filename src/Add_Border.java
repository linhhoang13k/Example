package CodeFights.Intro.Exploring_The_Waters;

/*** 
---Pergunta/ Question---
Given a rectangular matrix of characters, add a border of asterisks(*) to it.

Dada uma matriz retangular de caracteres, adicione uma borda de asteriscos (*) a ela.
---Comentários/ Comments---
Make an algorithm that adds * into a matrix forming an edge

Faça um algoritmo que adicione * em uma matriz formando uma borda
***/

import java.util.Arrays;

public class Add_Border {
    public static void main(String[] args){
        System.out.println(addBorder(new String[]{"abcde",
                "fghij",
                "klmno",
                "pqrst",
                "uvwxy"}));
    }

    static String[] addBorder(String[] picture){
        String[] strArr = new String[picture.length+2];
        strArr[0] = "*";
        strArr[strArr.length-1] = "*";
        int a;

        for(int i = 0; i < strArr.length; i++){
            a = picture[0].length();
            if(i == 0 || i == strArr.length-1)
                while(a-- >= 0) strArr[i] += "*";
            else strArr[i] = "*" + picture[i-1] + "*";
        }

        return strArr;
    }
}
