package exercise38;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PlantGrowthTrackerTest {

	
	@Test
	public void shouldReturnGrowthForOneDay90() {
		PlantGrowthTracker underTest = new PlantGrowthTracker();
		assertThat(underTest.calculateTotalGrowth(100,10), is(90));
	}
	
	@Test
	public void shouldReturnGrowthForOneDay100() {
		PlantGrowthTracker underTest = new PlantGrowthTracker();
		assertThat(underTest.calculateTotalGrowth(110,10), is(100));
	}
	
	@Test
	public void shouldReturn10DaysTestCase1() {
		PlantGrowthTracker underTest = new PlantGrowthTracker();
		assertThat(underTest.growingPlant(100, 10, 910), is(10));
	}

	
	@Test
	public void shouldReturn1DayTestCase2() {
		PlantGrowthTracker underTest = new PlantGrowthTracker();
		assertThat(underTest.growingPlant(10, 9, 4), is(1));
	}
}
