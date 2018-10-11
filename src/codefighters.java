package codefighters;

public class codefighters {

	public static void main(String[] args) throws Exception{


		//		String[] pros= {"Michael", "Mary","Ann","Nick","Dan","Mark"};
		//		int[] distances= {12, 10, 19, 15, 5, 20};
		//		int[] travelPreferences= {12, 8, 25, 10, 3, 10};


		//		String[] pros= {"Ann", "Michael","Mary"};
		//		int[] distances= {5, 5, 5};
		//		int[] travelPreferences= {3, 10, 7};

		String[] pros= {"Ann",  "Anna", "Hanna"};
		int[] distances= {5, 3, 2};
		int[] travelPreferences= {5, 4, 2};

		//		String[] pros= {"Ann"};
		//		int[] distances= {3};
		//		int[] travelPreferences= {3};	

		//		String[] pros= {"Margaret", "Kate","Darel"};
		//		int[] distances= {3, 3 , 4};
		//		int[] travelPreferences= {2,1,4};	

		//		String[] pros= {"Ann", "Anna"};
		//		int[] distances= {3, 5};
		//		int[] travelPreferences= {2,4};

		//		String resultados[] = requestMatching(pros, distances, travelPreferences);
		//		for(int j = 0; j < resultados.length; j ++){
		//			System.out.println(resultados[j]);
		//		}


				
		System.out.println(SpringOfIntegration.christmasTree(1, 3));
		System.out.println(SpringOfIntegration.christmasTree(2, 4));
		System.out.println(SpringOfIntegration.christmasTree(4, 8));

		System.out.println(SpringOfIntegration.christmasTree(2, 1));
		
	}


	private static String[] requestMatching(String[] pros, int[] distances, int[] travelPreferences) {
		int length = pros.length>5 ? 5 : pros.length;

		String results[] = new String[length];
		int resultsDistance[] = new int [length];
		String noResults[] = new String[pros.length];
		int noResultsDistance[] = new int [pros.length];
		int j = 0, k = 0;

		for(int i = 0; i < pros.length; i++){
			if(distances[i] <= travelPreferences[i]){
				results[j] = pros[i];
				resultsDistance[j] = distances[i];
				sortArray(results, resultsDistance);
				j++;
			}else{
				noResults[k] = pros[i];
				noResultsDistance[k] = distances[i] - travelPreferences[i];
				sortArray(noResults, noResultsDistance);
				k++;
			}
		}

		for(int i = 0;j < length; i++, j ++){
			results[j] = noResults[i];
		}

		return results;
	}

	private static void sortArray(String names[], int distance[]){
		for(int x = 0; x <= names.length; x++){
			for(int y = x + 1; y < names.length; y++){
				if(names[x] != null && names[y] != null){
					System.out.println(names[x] + " + " + x + " - " + names.length);
					if(distance[x] > distance[y] || (distance[x] == distance[y] && names[x].compareTo(names[y]) > 0)){
						String temp = names[x];
						names[x] = names [y];
						names[y] = temp;

						int tempDistance = distance[x];
						distance[x] = distance[y];
						distance[y] = tempDistance;
					}
					System.out.println(names[x] + " + " + x + " - " + names.length);
				}else{
					break;
				}
			}
		}
	}

}
