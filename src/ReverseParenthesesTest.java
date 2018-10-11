
import org.junit.Assert;
import org.junit.Test;

public class ReverseParenthesesTest {
    @Test
    public void test1() {
        Assert.assertEquals("acbde", ReverseParentheses.reverseParentheses("a(bc)de"));
    }
    @Test
    public void test2() {
        Assert.assertEquals("apmnolkjihgfedcbq", ReverseParentheses.reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }
    @Test
    public void test3() {
        Assert.assertEquals("cosfighted", ReverseParentheses.reverseParentheses("co(de(fight)s)"));
    }
    @Test
    public void test4() {
        Assert.assertEquals("CodeegnlleahC", ReverseParentheses.reverseParentheses("Code(Cha(lle)nge)"));
    }
    @Test
    public void test5() {
        Assert.assertEquals("Where are the parentheses?", ReverseParentheses.reverseParentheses("Where are the parentheses?"));
    }

    @Test
    public void test6() {
        Assert.assertEquals("abcabcabcabc", ReverseParentheses.reverseParentheses("abc(cba)ab(bac)c"));
    }

    @Test
    public void test7() {
        Assert.assertEquals("The god quick nworb xof jumps over the lazy", ReverseParentheses.reverseParentheses("The ((quick (brown) (fox) jumps over the lazy) dog)"));
    }

    @Test
    public void test8() {
        Assert.assertEquals("abcadcbabcabc", ReverseParentheses.reverseParentheses("abc((cb)(ad))ab(bac)c"));
    }

    @Test
    public void test9() {
        Assert.assertEquals("", ReverseParentheses.reverseParentheses("(()())()((()))"));
    }

    private void fill(StringBuilder str) {
        str.append("new");
    }

    @Test
    public void testRef() {
        StringBuilder str = new StringBuilder();
        fill(str);
        Assert.assertEquals("new", str.toString());
    }
}
