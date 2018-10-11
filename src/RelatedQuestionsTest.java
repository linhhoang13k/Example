package com.codefigths.solutions;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.codefights.solutions.RelatedQuestions;

public class RelatedQuestionsTest {

	@Test
	public void test() {
		RelatedQuestions relatedQuestions = new RelatedQuestions();
		int n= 10;
		int t[]={9, 2, 7, 14, 4, 26, 21, 18, 39, 33};
		int edges[][]={{2,7}, {0,9}, {3,5}, {4,7}, {0,2}, {8,5}, {3,6}, {2,1}, {5,0}};
		int answer=relatedQuestions.relatedQuestions(n, t, edges);
		assertTrue(answer==2);
	}

}
