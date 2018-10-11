package com.codefight.challanges;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * You"re a pretty fast typer - each keystroke takes you 75 milliseconds,
 * but if you"re able to use a different hand than the previous key, it only takes you 50.
 *
 * You use your left hand for the Q, W, E, R, T, A, S, D, F, G, Z, X, C, V, and B keys,
 * and you use your right hand for the Y, U, I, O, P, H, J, K, L, N, and M keys.
 * You can use either hand for the spacebar.
 *
 * Note: for the purpose of this challenge, we"ll ignore all other keys.
 *
 * Given a string text, find the shortest time it"ll take for you to type it out (in milliseconds).
 * The first keystroke always takes 50ms.
 *
 * Example
 *
 * For text = "abc", the output should be alternatingKeys(text) = 200.
 *
 * The first keystroke always takes 50ms, but since you need to use your
 * left hand again for the b and c keys, each of those keystrokes will take 75ms,
 * for a total of 50 + 75 + 75 = 200.
 *
 * For text = "land", the output should be alternatingKeys(text) = 200.
 *
 * Again, the first keystroke will take 50ms, but since each key alternates between
 * your left and right hand, they"ll each only take 50ms, for a total of 50 + 50 + 50 + 50 = 200.
 */
public class AlternatingKeys {

    public static void main(String args[]){
        int count = alternatingKeys("nice job");
        System.out.print(count);
    }


    static int alternatingKeys(String in) {
        in = in.toUpperCase();
        Set<Character> ls = "QWERTASDFGZXCVB".chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        Set<Character> rs = "YUIOPHJKLNM".chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        int t = 0;
        char p='o', c = 'o';

        for(int i=0; i < in.length(); i++){
            char m = in.charAt(i);
            if(ls.contains(m)){
                c = 'l'; t += 50;
                if(i==0){p=c='l';}
            }else if(rs.contains(m)){
                c= 'r'; t += 50;
                if(i==0){p=c='r';}
            }else{
                t += 50;
                p = (p == 'r')?'l':'r';
                continue;
            }
            if(i > 0 && p == c) {
                t += 25;
                continue;
            }
            p = c;
        }
        return t;
    }
}
