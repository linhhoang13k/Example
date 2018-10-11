package Dropbot;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCases {

    String o1 = "same_prefix_1233_same_suffix";
    String n1 = "same_prefix23123_same_suffix";
    String a1 = "same_prefix(_1)23[12]3_same_suffix";

    String o2 = "a";
    String n2 = "b";
    String a2 = "(a)[b]";

    String o3 = "a";
    String n3 = "a";
    String a3 = "a";

    String o4 = "ab";
    String n4 = "bb";
    String a4 = "(a)b[b]";

    String o5 = "a2_3b42c_78d";
    String n5 = "a_34c27_8ed";
    String a5 = "a(2)_3(b)4(2)c(_)[2]7[_]8[e]d";

    String o6 = "same_prefix_12533_same_suffix";
    String n6 = "same_prefix23123_same_suffix";
    String a6 = "same_prefix(_1)2(5)3[12]3_same_suffix";

    String o7 = "same_prefix_1233_same_suffix";
    String n7 = "same_prefix231233_same_suffix";
    String a7 = "same_prefix(_)[23]1233_same_suffix";

    void _test(String o, String n, String a)
    {
        System.out.printf("\n*********************DEBUG************************");
        String actual = DiffString.displayDiff(o, n);
        System.out.printf("*********************END DEBUG************************\n");
        System.out.printf("Old:      %s\nNew:      %s\nActual:   %s\nExpected: %s\n\n", o, n, actual, a);
        assertTrue("Expected: " + a, actual.equals(a));

    }

    //test to check appraisal
    @Test
    public void test1() {
        _test(o1, n1, a1);
    }

    //test to check appraisal
    @Test
    public void test2() {
        _test(o2, n2, a2);
    }

    //test to check appraisal
    @Test
    public void test3() {
        _test(o3, n3, a3);
    }

    //test to check appraisal
    @Test
    public void test4() {
        _test(o4, n4, a4);
    }

    //test to check appraisal
    @Test
    public void test5() {
        _test(o5, n5, a5);
    }

    //test to check appraisal
    @Test
    public void test6() {
        _test(o6, n6, a6);
    }

    //test to check appraisal
    @Test
    public void test7() {
        _test(o7, n7, a7);

    }

    //test to check appraisal
    @Test
    public void GoPeace_test1() {
        String o = "_1233_same_suffix";
        String n = "231233_same_suffix";
        int[] a_peace = {2, 0};
        int[] a_peace_greedy =  {1, 2};

        int[] actual_a_peace = DiffString.goUntilPeaceTradition(o, n);
        int[] actual_a_peace_greedy = DiffString.goUntilPeaceGreedy(o, n);

        assertTrue(Arrays.equals(a_peace, actual_a_peace));
        assertTrue(Arrays.equals(a_peace_greedy, actual_a_peace_greedy));
    }

    //test to check appraisal
    @Test
    public void GoPeace_test2() {
        String o = "same_prefix_";
        String n = "same_prefix23";
//        int[] a_peace = {2, 0};
        int[] a_peace_greedy =  {0, 0};

//        int[] actual_a_peace = DiffString.goUntilPeaceTradition(o, n);
        int[] actual_a_peace_greedy = DiffString.goUntilPeaceGreedy(o, n);

//        assertTrue(Arrays.equals(a_peace, actual_a_peace));
        assertTrue(Arrays.equals(a_peace_greedy, actual_a_peace_greedy));
    }
}