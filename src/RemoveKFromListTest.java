/**
 * 
 */
package com.ab.cf.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ab.cf.linkedlist.ListNode;
import com.ab.cf.linkedlist.RemoveKFromList;

/**
 * @author berenyia
 *
 */
public class RemoveKFromListTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPrint() {
		ListNode<Integer> l1 = new ListNode<>(3);
		Assert.assertEquals("[3]", l1.toString());
	}

	@Test
	public void testPrint2() {
		ListNode<Integer> l1 = new ListNode<>(3);
		ListNode<Integer> l2 = new ListNode<>(1);
		ListNode<Integer> l3 = new ListNode<>(2);
		ListNode<Integer> l4 = new ListNode<>(3);
		ListNode<Integer> l5 = new ListNode<>(4);
		ListNode<Integer> l6 = new ListNode<>(5);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;

		Assert.assertEquals("[3, 1, 2, 3, 4, 5]", l1.toString());
	}

	@Test
	public void test1() {
		ListNode<Integer> l1 = new ListNode<>(3);
		ListNode<Integer> l2 = new ListNode<>(1);
		ListNode<Integer> l3 = new ListNode<>(2);
		ListNode<Integer> l4 = new ListNode<>(3);
		ListNode<Integer> l5 = new ListNode<>(4);
		ListNode<Integer> l6 = new ListNode<>(5);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;

		RemoveKFromList rk = new RemoveKFromList();
		ListNode<Integer> ln = rk.removeKFromList(l1, 3);
		Assert.assertEquals("[1, 2, 4, 5]", ln.toString());

	}

	@Test
	public void test2() {
		ListNode<Integer> l1 = new ListNode<>(1);
		ListNode<Integer> l2 = new ListNode<>(2);
		ListNode<Integer> l3 = new ListNode<>(3);
		ListNode<Integer> l4 = new ListNode<>(4);
		ListNode<Integer> l5 = new ListNode<>(5);
		ListNode<Integer> l6 = new ListNode<>(6);
		ListNode<Integer> l7 = new ListNode<>(7);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;

		RemoveKFromList rk = new RemoveKFromList();
		ListNode<Integer> ln = rk.removeKFromList(l1, 10);
		Assert.assertEquals("[1, 2, 3, 4, 5, 6, 7]", ln.toString());

	}

	@Test
	public void test3() {
		ListNode<Integer> l1 = new ListNode<>(1000);
		ListNode<Integer> l2 = new ListNode<>(1000);

		l1.next = l2;

		RemoveKFromList rk = new RemoveKFromList();
		ListNode<Integer> ln = rk.removeKFromList(l1, 1000);
		Assert.assertNull(ln);

	}

	@Test
	public void test4() {
		RemoveKFromList rk = new RemoveKFromList();
		ListNode<Integer> ln = rk.removeKFromList(null, -1000);
		Assert.assertNull(ln);

	}

	@Test
	public void test5() {
		ListNode<Integer> l1 = new ListNode<>(123);
		ListNode<Integer> l2 = new ListNode<>(456);
		ListNode<Integer> l3 = new ListNode<>(789);

		l1.next = l2;
		l2.next = l3;

		RemoveKFromList rk = new RemoveKFromList();
		ListNode<Integer> ln = rk.removeKFromList(l1, 10);
		Assert.assertEquals("[123, 456, 789]", ln.toString());

	}

}
