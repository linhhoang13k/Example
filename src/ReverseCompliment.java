"""
ReverseComplement
Daniel Cox

https://codefights.com/challenge/revx6ws9h53DS9KFF

DNA is a double stranded molecule that is composed four repeating building blocks (a.k.a. bases). These are commonly denoted by the first letter for their chemical names (A, T, C and G). DNA is also a double stranded molecule that looks, for example, like this:
strand A :: AAATTTGGGCCC,
strand B :: TTTAAACCCGGG.

The complete molecule can be regenerated if only one "strand" is known. The process of obtaining the other strand is called complementation. B is complement to A and A is complement to B.

The pairing patterns are: A - T and C - G.
The base N denotes and unknown value and complements to N.
S denotes an ambiguous strong base. G and C are strong bases.
W denotes an ambiguous weak base. A and T are weak bases.

Given a strand, return the complement.

Example
For strand = "AAA", the output should be
reverseComplement(strand) = "TTT".
"""
String ReverseComplement(String strand) {
    StringBuilder sb = new StringBuilder();
    sb.append(strand);
    sb.reverse();
    char[] ans = sb.toString().toCharArray();
    for(int i =0; i < strand.length(); i++){
        if(Character.toUpperCase(ans[i])=='A'){
            ans[i] = 'T';
        }
        else if(Character.toUpperCase(ans[i])=='T'){
            ans[i] = 'A';
        }
        else if(Character.toUpperCase(ans[i])=='C'){
            ans[i] = 'G';
        }
        else if (Character.toUpperCase(ans[i])=='G'){
            ans[i] = 'C';
        }
        else if(Character.toUpperCase(ans[i])=='S'){
            ans[i] = 'W';
        }
        else if (Character.toUpperCase(ans[i])=='W'){
            ans[i] = 'S';
        }
        else{
            ans[i] = Character.toUpperCase(ans[i]);
        }
    }
    return new String(ans);
}
