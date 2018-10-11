import org.junit.Assert;
import org.junit.Test;

public class StringRearrangementTest {
    @Test
    public void test1() {
        String[] array = new String[] {"aba", "bbb", "bab"};
        Assert.assertFalse(StringsRearrangement.stringsRearrangementStatic(array));
    }
    @Test
    public void test2() {
        String[] array = new String[] {"ab", "bb", "aa"};
        Assert.assertTrue(StringsRearrangement.stringsRearrangementStatic(array));
    }
    @Test
    public void test3() {
        String[] array = new String[] {"q", "q"};
        Assert.assertFalse(StringsRearrangement.stringsRearrangementStatic(array));
    }
    @Test
    public void test4() {
        String[] array = new String[] {"zzzzab", "zzzzbb", "zzzzaa"};
        Assert.assertTrue(StringsRearrangement.stringsRearrangementStatic(array));
    }
    @Test
    public void test5() {
        String[] array = new String[] {"ab", "ad", "ef", "eg"};
        Assert.assertFalse(StringsRearrangement.stringsRearrangementStatic(array));
    }
    @Test
    public void test6() {
        String[] array = new String[] {"abc", "bef", "bcc", "bec", "bbc", "bdc"};
        Assert.assertTrue(StringsRearrangement.stringsRearrangementStatic(array));
    }
    @Test
    public void test7() {
        String[] array = new String[] {"abc", "abx", "axx", "abc"};
        Assert.assertFalse(StringsRearrangement.stringsRearrangementStatic(array));
    }
    @Test
    public void test8() {
        String[] array = new String[] {"abc", "abx", "axx", "abx", "abc"};
        Assert.assertTrue(StringsRearrangement.stringsRearrangementStatic(array));
    }
    @Test
    public void test9() {
        String[] array = new String[] {"f", "g", "a", "h"};
        Assert.assertTrue(StringsRearrangement.stringsRearrangementStatic(array));
    }


}
