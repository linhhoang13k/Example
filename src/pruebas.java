package codefighters;

public class pruebas {

	
	public static void main(String[] args) {


		String[] pros= {"Michael", 
				"Mary", 
				"Ann", 
				"Nick", 
				"Dan", 
		"Mark"};
		int[] distances= {12, 10, 19, 15, 5, 20};
		int[] travelPreferences= {12, 8, 25, 10, 3, 10};

		String resultados[] = requestMatching(pros, distances, travelPreferences);
		for(int j = 0; j < resultados.length; j ++){
			System.out.println(resultados[j]);
		}

	}
	
	static String[] requestMatching(String[] pros, int[] distances, int[] travelPreferences) {
	    String results[] = new String[5];
	    String noResults[] = new String[pros.length]; 
	    int noResultsDistance[] = new int[pros.length];
	    int j = 0, k = 0;
	    
	    for(int i = 0; i < pros.length; i++){
	        if(distances[i] <= travelPreferences[i]){
	            results[j] = pros[i];
	            j++;
	        }else{
	            noResults[k] = pros[i];
	            noResultsDistance[k] = distances[i] - travelPreferences[i];
	            sortArray(noResults, noResultsDistance);
	            k++;
	        }
	    }
	    
	    for(int i = 0; j < 5; i++, j++){
	        results[j] = noResults[i];
	    }
	    return results;
	}

	static void sortArray (String names[], int distance[]){
	    for(int x = 0; x <= names.length; x++){
	        for(int y = x+1; y<=names.length; y++){
	            if(names[x] != null && names[y] != null){
	                if(distance[x]>distance[y] || (distance[x] == distance[y] && names[x].compareTo(names[y]) > 0)){
	                    String temp = names[x];
	                    names[x] = names[y];
	                    names[y] = temp;
	                    int tempDistance = distance[x];
	                    distance[x] = distance[y];
	                    distance[y] = tempDistance;
	                }
	            }else{
	                break;
	            }
	        }
	    }
	}

}
