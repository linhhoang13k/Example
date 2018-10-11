/*
After they became famous, the CodeBots all decided to move to a new building and live together. The building is represented by a rectangular matrix of rooms. Each cell in the matrix contains an integer that represents the price of the room. Some rooms are free (their cost is 0), but that's probably because they are haunted, so all the bots are afraid of them. That is why any room that is free or is located anywhere below a free room in the same column is not considered suitable for the bots to live in.
Help the bots calculate the total price of all the rooms that are suitable for them.

[input] array.array.integer matrix
A 2-dimensional array of integers representing a rectangular matrix of the building.
Guaranteed constraints:
1 ≤ matrix.length ≤ 5,
1 ≤ matrix[i].length ≤ 5,
0 ≤ matrix[i][j] ≤ 10.


[output] integer
The total price of all the rooms that are suitable for the CodeBots to live in.
*/

int matrixElementsSum(int[][] matrix) {
    //declare variables
    int[][] rooms = matrix.clone();
    int rowNum = matrix.length;
    int columnNum = matrix[0].length;
    int row = 0;
    int column = 0;
    int totalPrice=0;
    
    //set the uninhabitable rooms, calculate the price
    for(row = 0; row < rowNum; row++){
        for(column = 0; column < columnNum; column++){ 
            if(rooms[row][column] == 0){
                for(int unsuitRow = row; unsuitRow < rowNum; unsuitRow++){
                    rooms[unsuitRow][column]=0;
                }
            }
            totalPrice+= rooms[row][column];
        }
    }

    return totalPrice;
}