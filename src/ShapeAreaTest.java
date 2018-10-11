package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import main.ShapeArea;

public class ShapeAreaTest {

	int n;

	private int shapeAreaResult() {
		return ShapeArea.shapeArea(this.n);
	}

	@Test
	public void shouldReturnAreaForPolygonOneAs1() {
		n = 1;
		assertThat(shapeAreaResult(), is(1));
	}

	@Test
	public void shouldReturnAreaForPolygonTwoAs5() {
		n = 2;
		assertThat(shapeAreaResult(), is(5));
	}

	@Test
	public void shouldReturnAreaForPolygonThreeAs13() {
		n = 3;
		assertThat(shapeAreaResult(), is(13));
	}

	@Test
	public void shouldReturnAreaForPolygonFiveAs41() {
		n = 5;
		assertThat(shapeAreaResult(), is(41));
	}

}
