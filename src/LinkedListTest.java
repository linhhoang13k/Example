/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterviewPracticeProblems;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BigBoss
 */
public class LinkedListTest {
    
    public LinkedListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of printList method, of class LinkedList.
     */
    @Test
    public void testPrintList() {
        System.out.println("printList");
        LinkedList<Integer> list = new LinkedList();
        int[] nums = {1,3,5,4};
        
        for (int i = 0; i < nums.length; i++)
            list.insertAtEnd(nums[i]);
        list.printList();
    }

    /**
     * Test of insertAtBeginning method, of class LinkedList.
     */
    @Test
    public void testInsertAtBeginning() {
        System.out.println("insertAtBeginning");
        Object data = null;
        LinkedList instance = new LinkedList();
        instance.insertAtBeginning(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertAtEnd method, of class LinkedList.
     */
    @Test
    public void testInsertAtEnd() {
        System.out.println("insertAtEnd");
        Object data = null;
        LinkedList instance = new LinkedList();
        instance.insertAtEnd(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeKFromList method, of class LinkedList.
     */
//    @Test
//    public void testRemoveKFromList() {
//        System.out.println("removeKFromList");
//        LinkedList.ListNode l = null;
//        Object k = null;
//        LinkedList instance = new LinkedList();
//        LinkedList.ListNode expResult = null;
//        LinkedList.ListNode result = instance.removeKFromList(l, k);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
