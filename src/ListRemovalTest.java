package com.paigeruppel.interviewpractice.linkedlists;

import java.util.LinkedList;

import javax.xml.soap.Node;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ListRemovalTest {

	private ListRemoval underTest;
	
	@Before
	public void setup() {
		underTest = new ListRemoval();
	}
	
	@Test
	public void testCase1() {
		int[] arrayL = {3, 1, 2, 3, 4, 5};
		ListNode<Integer> l = new ListNode(arrayL);
		int[] arrayWithoutK = {1,2,4,5};
		assertThat(underTest.removeKFromList(l, 3), is(l));
	}
}
