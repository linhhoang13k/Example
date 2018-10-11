package Interview;

import CodeFight.MinHeap;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by tranpham on 3/26/18.
 */
public class InterviewGeneralTest {
    @Test
    public void retrieveMostFrequentlyUsedWords() throws Exception {
        String input = "romeo romeo wherefore art thou romeo";
        List<String> exception = Arrays.asList(new String[]{"art", "thou"});
        //List<String> expected = Arrays.asList(new String[]{"romeo"});
        List<String> actual = interviewBot.retrieveMostFrequentlyUsedWords(input,exception);
        Assert.assertTrue(actual.get(0).equals("romeo"));
    }

    @Test
    public void runningMedian() throws Exception {
        int[] input = {12,4,5,3,8,7};
        float[] expected = {12.0f,8.0f,5.0f,4.5f,5.0f,6.0f};
        float[] actual = interviewBot.runningMedian(input);
        Assert.assertArrayEquals(expected,actual,0.01f);
    }

    @Test
    public void contacts() throws Exception {
        String[][] input = {{"add","hack"},
                            {"add","hackerrank"},
                            {"find","hac"},
                            {"find","hak"}};
        int[] expected = {2,0};
        int[] actual= interviewBot.contacts(input);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void chessKnight() throws Exception {
        Assert.assertEquals(2,interviewBot.chessKnight("a8"));
//        Assert.assertEquals(2,interviewBot.chessKnight("h8"));
    }

    @Test
    public void treeBottom() throws Exception {
        String input = "(2 (7 (2 () ()) (6 (5 () ()) (11 () ()))) (5 () (9 (4 () ()) ())))";
        int[] expected = {5,11,4};
        int[] actual= interviewBot.treeBottom(input);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void bankRequests() throws Exception {

    }

    @Test
    public void groupingDishes() throws Exception {
        String[][]  dishes= {{"Salad","Tomato","Cucumber","Salad","Sauce"},
                             {"Pizza","Tomato","Sausage","Sauce","Dough"},
                             {"Quesadilla","Chicken","Cheese","Sauce"},
                             {"Sandwich","Salad","Bread","Tomato","Cheese"}};
        String[][] expected = {{"Cheese","Quesadilla","Sandwich"},
                            {"Salad","Salad","Sandwich"},
                            {"Sauce","Pizza","Quesadilla","Salad"},
                            {"Tomato","Pizza","Salad","Sandwich"}};

        String[][] actual= interviewBot.groupingDishes(dishes);

        Assert.assertArrayEquals(expected,actual);
    }

    InterviewGeneral interviewBot = new InterviewGeneral();

    @Test
    public void swap() throws Exception {
        Integer n1=6,n2=9;
        interviewBot.swap(n1,n2);
    }

    @Test
    public void swap1() throws Exception {
        int n1=6,n2=9;
        interviewBot.swap(n1,n2);

    }

    @Test
    public void generateSubsets() throws Exception {
        int[] inputSet = {1,2};
        int[][] expected = {{},{1},{2},{1,2}};
        int[][] actual  = interviewBot.generateSubsets(inputSet);
        Assert.assertArrayEquals(expected,actual);
    }

}