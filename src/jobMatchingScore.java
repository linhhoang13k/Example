/*
This is a working solution for codefights challenge jobMatchingScore 

You're given a list of candidate locations in the following form "city, state, country", for example:

   San Francisco, California, United States
   ..., ..., ...
   ..., ..., ...

**Note:** Return the number of candidates matching the given job location criteria. The criteria can have one of the following 3 forms:

            San Francisco, California, United States - candidates from the given city
            California, United States - candidates from the given state
            United States - candidates from the given country

Note that there can be multiple cities with the same name in different states, and there can be multiple states with the same name in different countries.

**Example**

   * For

      locations = ["San Francisco, California, United States",
 `                  "San Mateo, California, United States",
                    "Columbia, South Carolina, United States",
                    "Columbia, California, United States"]

         and criteria = "United States", the output should be jobMatchingScore(locations, criteria) = 4.
*/


public class challengeDay1{


/*function to find the job match score*/
static int jobMatchingScore(String[] locations, String criteria) {
   
   /*First Split the criteria into array, this will make us sure about matching criteria*/
String[] criteriaSplit = criteria.split(", ");
   
   /*The score will be saved in this int variable res*/
int res = 0;
   
   /*We created a new 2d array locationsSplit*/
String[][] locationsSplit = new String[locations.length][3];

   /*We know in locations, evry three consecutive values need to match with the criteria so why not just save every three locations i.e, city, state, country*/
    for(int i=0; i<locations.length; i++){
        locationsSplit[i] = locations[i].split(", ");
    }
    
    /*Now again we will loop through the array*/
    for(int i = 0; i < locations.length; i++){
       
       /*If criteria has one value like United States so we will match according to it. If it matches add one to res*/
        if(criteriaSplit.length == 1){
            if(locationsSplit[i][2].equals(criteria))res++;   
        }
       
       /*Now if we have two match criteria based on country name and State and again based on condition if its true add one to res*/
        else if(criteriaSplit.length == 2){
if(locationsSplit[i][1].equals(criteriaSplit[0]) && locationsSplit[i][2].equals(criteriaSplit[1]))res++;
        }
       /*Now it will look for city also and add 1 to res if true*/
        else if(criteriaSplit.length == 3){
if(locationsSplit[i][0].equals(criteriaSplit[0]) && locationsSplit[i][1].equals(criteriaSplit[1]) && locationsSplit[i][2].equals(criteriaSplit[2]))res++;
        }
    }
    /*Return answer at last*/
    return res;
}
   
   public static void main(String[] Args){
      String[] locations = ["San Francisco, California, United States",
             "San Mateo, California, United States",
             "Columbia, South Carolina, United States",
             "Columbia, California, United States"];
      String criteria = "United States";
      
      System.out.println(jobMatchingScore(locations, criteria));
   }
}
