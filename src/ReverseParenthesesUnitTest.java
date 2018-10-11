package smooth.saling;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ReverseParenthesesUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		String s = "a(bc)de";

		String result = reverseParentheses(s);

		assertTrue("acbde".equals(result));
	}

	@Test
	public void test2() {
		String s = "a(bcdefghijkl(mno)p)q";

		String result = reverseParentheses(s);

		assertTrue("apmnolkjihgfedcbq".equals(result));
	}

	@Test
	public void test7() {
		String s = "The ((quick (brown) (fox) jumps over the lazy) dog)";

		String result = reverseParentheses(s);


		assertTrue("The god quick nworb xof jumps over the lazy".equals(result));
	}



	String reverseParentheses(String s) {
		while (s.lastIndexOf("(") > -1) {
			int beginIndex = s.lastIndexOf("(");
			int endIndex = s.indexOf(")", beginIndex);
			String target = s.substring(beginIndex, endIndex + 1);

			StringBuilder sb = new StringBuilder(target);

			sb.reverse();
			String replacement = sb.toString().substring(1, sb.toString().length() - 1);

			s = s.replace(target, replacement);

		}

		return s;

	}

}
