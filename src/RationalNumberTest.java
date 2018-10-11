package com.paigeruppel.interviewpractice.numbertheory;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class RationalNumberTest {

	private RationalNumber underTest;

	

	@Test
	public void simplifyShouldReturnReduced1Over2FromNumerator3AndDenominator6() {
		underTest = new RationalNumber(3, 6);
		int[] simplified = { 1, 2 };
		assertThat(underTest.simplifyRational(), is(simplified));
	}

	@Test
	public void simplifyShouldReturnUnchanged5Over8FromNumerator5AndDenominator8() {
		underTest = new RationalNumber(5, 8);
		int[] simplified = { 5, 8 };
		assertThat(underTest.simplifyRational(), is(simplified));
	}
	
	@Test
	public void simplifyShouldReturnFlippedNegative8Over5FromNumerator8AndDenominatorNegative5() {
		underTest = new RationalNumber(8, -5);
		int[] simplified = { -8, 5 };
		assertThat(underTest.simplifyRational(), is(simplified));
	} 
	

	@Test
	public void simplifyShouldReturn0Over1FromNumerator0AndDenominatorNegative239() {
		underTest = new RationalNumber(0, -239);
		int[] simplified = { 0, 1 };
		assertThat(underTest.simplifyRational(), is(simplified));
	} 
}
