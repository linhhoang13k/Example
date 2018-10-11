package com.codefigths.solutions;

import static org.junit.Assert.*;

import org.junit.Test;

import com.codefights.solutions.DistanceTravelled;

public class DistanceTravelledTest {

	@Test
	public void test() {
		DistanceTravelled object = new DistanceTravelled();
		String[] placesTravelled = { "New York, NY, USA", "Toronto, ONT", "Los Angeles, CA, USA" };
		int distanceTravelled=object.traveledDistance(placesTravelled);
		int minPossibleDistance=4850514-10*4850514/100;
		int maxPossibleDistance=4850514+10*4850514/100;
		assertTrue(distanceTravelled<=maxPossibleDistance && distanceTravelled>=minPossibleDistance);
	}

}
