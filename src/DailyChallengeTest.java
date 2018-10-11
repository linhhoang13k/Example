package CodeFight;

import Testing.Testing;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by tranpham on 2/22/18.
 */
public class DailyChallengeTest {

    DailyChallenge challenge = new DailyChallenge();
    @Test
    public void swappingLetters() throws Exception {
        String text = "[b<->c][a<->b]ABC";
        String expected = "CAB";
        String actual = challenge.swappingLetters(text);
        Assert.assertEquals(expected,actual);

        String text2 = "[y<->n]Nes/Yo: Do nou like this challeyge?[y<->n] ";
        expected = "Yes/No: Do you like this challenge? ";
        actual = challenge.swappingLetters(text2);
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void coolMachineTest() throws Exception {
        String tape="00010000";
        String[] program={"0,0,0,R,0", "0,1,0,R,1","1,0,1,R,9"};
        String output=DailyChallenge.coolMachine(tape,program);
        String expect_output="00001000";
        Assert.assertEquals("Test 1 fail",expect_output,output);

        tape="001100110011001100117";
        program=new String[]{"0,0,1,R,1", "1,0,2,R,2", "2,1,3,R,3","3,1,4,R,0","0,7,0,R,9"};
        output=DailyChallenge.coolMachine(tape,program);
        expect_output="123412341234123412340";
        Assert.assertEquals("Test 1 fail",expect_output,output);

    }

    @Test
    public void reverseListTest() throws Exception {
        Node head = new Node(1);
        Node currNode = head;

        int[] list = {2,3,4,5,6,7,8,9,10};
        for (int i:list){
            currNode.nextNode = new Node(i);
            currNode = currNode.nextNode;
        }
        int k=2;
        //the result should be like {9,2,7,4,5,6,3,8,1,10}
        int[] targetlist = {2,7,4,5,6,3,8,1,10};
        Node targetReverseNode = new Node(9);
        currNode = targetReverseNode;
        for (int i:targetlist){
            currNode.nextNode = new Node(i);
            currNode = currNode.nextNode;
        }

        Node result = DailyChallenge.reverseList(head,k);
        assertTrue("Wrong reversed list",targetReverseNode.isEqual(result));
    }
}