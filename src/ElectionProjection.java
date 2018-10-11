package exercise46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ElectionProjection {

	/*
	 * Elections are in progress!
	 * 
	 * Given an array of the numbers of votes given to each of the candidates so
	 * far, and an integer k equal to the number of voters who haven't cast their
	 * vote yet, find the number of candidates who still have a chance to win the
	 * election.
	 * 
	 * The winner of the election must secure strictly more votes than any other
	 * candidate. If two or more candidates receive the same (maximum) number of
	 * votes, assume there is no winner at all.
	 */


	public int electionsWinners(int[] votes, int k) {
		int possibleOutcomes = 0;
		int currentMax = 0;
		int ties = 0;
		List<Integer> withAddedVotes = new ArrayList<>();
		
		for (int i = 0; i < votes.length; i++) {
			if (isGreaterThanCurrentMax(votes[i], currentMax)) {
				currentMax = votes[i];
			}
			if (withAddedVotes.contains(votes[i])) {
				ties++;
			}
			withAddedVotes.add((votes[i] + k));
		}
		
		for (int current : withAddedVotes) {
			if (isGreaterThanCurrentMax(current, currentMax)) {
				possibleOutcomes++;
			}
		}
		
		if (isPossibleWinnerAndNoAdditionalVotes(votes, k, ties)) {
			possibleOutcomes = 1;
		}
		
		return possibleOutcomes;
	}

	private boolean isGreaterThanCurrentMax(int compare, int max) {
		return compare > max;
	}

	private boolean isPossibleWinnerAndNoAdditionalVotes(int[] votes, int k, int ties) {
		return k == 0 && ties < votes.length - 2;
	}
}
