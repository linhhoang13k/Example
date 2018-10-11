
//https://codefights.com/challenge/TrQgtxWgu6pArX7ui

package com.codefights.solutions;

import java.util.HashMap;
import java.util.Map;

public class AtomicCannon {

	public String atomicCannon(String message) {
		// Get array with Element length with optimum solution
		int lengthOfMinimum[] = min(message);

		StringBuilder result = new StringBuilder();

		for (int index = 0; index < message.length();) {
			// if element length at any index is 0, it means it's an invalid
			// element
			if (lengthOfMinimum[index] == 0) {
				return "Invalid";
			}

			// Convert the first char of Element to UpperCase
			result.append((message.charAt(index) + "").toUpperCase());

			// if the length of the element symbol is 2, append second character
			// in lowercase
			if (lengthOfMinimum[index] > 1)
				result.append(message.charAt(index + 1));

			// after each element symbol append one space
			result.append(" ");

			index = index + lengthOfMinimum[index];
		}
		// remove the extra space at last
		return result.deleteCharAt(result.length() - 1).toString();
	}

	private int[] min(String message) {
		int[] lengthOfMinimum = new int[message.length() + 1];
		int first = 0, second = 0;
		String[] E = { "H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl",
				"Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se",
				"Br", "Kr", "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb",
				"Te", "I", "Xe", "Cs", "Ba", "La", "Ce", "Pr", "Nd", "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er",
				"Tm", "Yb", "Lu", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At",
				"Rn", "Fr", "Ra", "Ac", "Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md", "No",
				"Lr", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Nh", "Fl", "Mc", "Lv", "Ts", "Og" };

		int atomicNumber = 1, defaultWeightForInvalidElementName = 10000000;

		// Hashmap to access element symbol in 0(1)
		Map<String, Integer> elementAtomicNumberMap = new HashMap();

		for (String p : E)
			elementAtomicNumberMap.put(p, atomicNumber++);

		// for each character from end check if it results in optimum length,
		// if it result store the length of the symbol in dp table
		for (int start = message.length() - 1; start >= 0; start--) {
			int l = defaultWeightForInvalidElementName, r = l;
			String name = (char) (message.charAt(start) - 32) + "", name2 = "";
			if (start < message.length() - 1) {
				name2 = name + message.charAt(start + 1);
			}
			if (elementAtomicNumberMap.containsKey(name)) {
				l = elementAtomicNumberMap.get(name) + first;
			}
			if (elementAtomicNumberMap.containsKey(name2)) {
				r = elementAtomicNumberMap.get(name2) + second;
			}
			second = first;
			first = Math.min(l, r);
			if (first < defaultWeightForInvalidElementName) {
				if (first == l)
					lengthOfMinimum[start] = 1;
				else {
					lengthOfMinimum[start] = 2;
				}
			}

		}
		return lengthOfMinimum;

	}
}
