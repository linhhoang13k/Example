/*
Your boss likes to prank you by sending you the sentence he wants to say as a list of words, with each word given as a list of characters. You are already tired of a such low level prank, and decide to write a program that would turn the sentences your boss sends to you into a readable form.

Remember to put a space between two words and put a period in the end of the sentence. Your boss is weird but kind enough not to send you sentences with other punctuation.

Note: if you want an additional challenge, try solving this challenge locally without using STL and C Runtime Library with the only exception being malloc(). Therefore the function you should the implement has the following format:


*/

String makeSentence(char[][] words) {
   
    String s ="";
    for (int row = 0; row < words.length; row++) 
    {
        for (int col = 0; col < words[row].length; col++)
        { 
            s += words[row][col];
        }
        if(row == words.length-1)
        {
            break;
        }
        s += " ";
    }

 return s+".";
}
