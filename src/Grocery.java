package codefights.arcade;

import java.util.ArrayList;

public class Grocery {

	private ArrayList<String> grocerylist = new ArrayList<String>();

	public ArrayList<String> getGrocerylist() {
		return grocerylist;
	}

	public void addGroceryItem(String item) {
		grocerylist.add(item);
	}

	public void printGroceryList() {
		System.out.println("You have " + grocerylist.size() + " items in your grocery list");
		for (int i = 0; i < grocerylist.size(); i++) {
			System.out.println((i + 1) + " element is " + grocerylist.get(i));
		}
	}

	public void modifyarray(String current, String old) {
		int position = grocerylist.indexOf(old);
		if (position >= 0) {
			grocerylist.set(position, current);
		}
	}

	public void removeGroceryItem(String item) {
		int position = grocerylist.indexOf(item);
		if (position >= 0) {
			grocerylist.remove(position);
		}

	}


	public boolean search(String searchItem) {
		int position = grocerylist.indexOf(searchItem);
		if (position >= 0) {
			return true;
		} else {
			return false;
		}
	}

}
