import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveElementFromListTest {

    @Test
    public void testRemoveKFromList() {
        int[] inputArray = new int[]{3, 1, 2, 3, 4, 5};
        int valueToRemove = 3;

        int[] outputArray = new int[]{1, 2, 4, 5};
        ListNode<Integer> expectedOutputListNode = initializeListNodeFromArray(outputArray);

        RemoveElementFromList instance = new RemoveElementFromList();
        ListNode<Integer> testListNode = initializeListNodeFromArray(inputArray);
        ListNode<Integer> actualOutputListNode = instance.removeKFromList1(testListNode, valueToRemove);

        assertEquals(expectedOutputListNode, actualOutputListNode);
    }

    @Test
    public void secondTestRemoveKFromList() {
        int[] inputArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        int valueToRemove = 10;

        int[] outputArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        ListNode<Integer> expectedOutputListNode = initializeListNodeFromArray(outputArray);

        RemoveElementFromList instance = new RemoveElementFromList();
        ListNode<Integer> testListNode = initializeListNodeFromArray(inputArray);
        ListNode<Integer> actualOutputListNode = instance.removeKFromList1(testListNode, valueToRemove);

        assertEquals(expectedOutputListNode, actualOutputListNode);
    }


    @Test
    public void thirdTestRemoveKFromList() {
        int[] inputArray = new int[]{123, 456, 789, 0};
        int valueToRemove = 0;

        int[] outputArray = new int[]{123, 456, 789};
        ListNode<Integer> expectedOutputListNode = initializeListNodeFromArray(outputArray);

        RemoveElementFromList instance = new RemoveElementFromList();
        ListNode<Integer> testListNode = initializeListNodeFromArray(inputArray);
        ListNode<Integer> actualOutputListNode = instance.removeKFromList1(testListNode, valueToRemove);

        assertEquals(expectedOutputListNode, actualOutputListNode);
    }

    private ListNode<Integer> initializeListNodeFromArray(int[] inputArray) {
        ListNode<Integer> listNode = new ListNode<>(0);
        for (int currentValue : inputArray
                ) {
            listNode = new ListNode<Integer>(currentValue, listNode);
        }

        return listNode;
    }
}
