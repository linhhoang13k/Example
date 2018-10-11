package exercise19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualStrength {

	public boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
		
		if (yourLeft==friendsLeft && yourRight == friendsRight) {
			return true;
		} else if (yourLeft==friendsRight && yourRight==friendsLeft) {
			return true;
		}
	
		return false;
	}

}
