package Arcade_Intro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _13_reverseParenthesesTest {
    final static _13_reverseParentheses obj = new _13_reverseParentheses();

    @Test
    void reverseParentheses() {
        //assertEquals(obj.reverseParentheses("a(bc)de"), "acbde");
        //assertEquals(obj.reverseParentheses("a(bcdefghijkl(mno)p)q"), "apmnolkjihgfedcbq");
        //assertEquals(obj.reverseParentheses("co(de(fight)s)"), "cosfighted");
        assertEquals(obj.reverseParentheses("abc(cba)ab(bac)c"), "abcabcabcabc");
    }
}