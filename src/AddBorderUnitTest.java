package exploringtwo.the.waters;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AddBorderUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		String[] picture = { "abc", "ded" };

		String[] result = addBorder(picture);

		assertTrue(result[0].equals("*****"));
		assertTrue(result[1].equals("*abc*"));
		assertTrue(result[2].equals("*ded*"));
		assertTrue(result[3].equals("*****"));
	}

	String[] addBorder(String[] picture) {

		List<String> pictureList = new ArrayList<>();

		String asterisksBorder = getAsterisksBorder(picture[0].length() + 2);

		pictureList.add(asterisksBorder);

		for (String row : picture) {
			pictureList.add("*" + row + "*");
		}

		pictureList.add(asterisksBorder);

		return pictureList.toArray(new String[pictureList.size()]);
	}

	String getAsterisksBorder(int size) {
		String border = "";

		for (int i = 0; i < size; i++) {
			border += "*";
		}

		return border;
	}

}
