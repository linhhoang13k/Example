/*bishobAndPawn.java
 *codefights
 *Arcade
 *Introduction
 *Dark Wilderness
 *#42
 *Created by Ian Feekes December 6th 2017
 */

/*Due to the knight's l-shape movement there are only a few possibilities for being in threat range, so rather than doing a 2-d array, which is totally a viable solution, I used if statements to solve this one. While the code may not look particularly elegant it's worst case run-time isn't bad(not that this algorithm involves n indices or anything of the sort */ 

boolean bishopAndPawn(String bishop, String pawn) 
{
 int xCoordBish = (int)bishop.charAt(0)-97;
 int yCoordBish = Character.getNumericValue(bishop.charAt(1))-1;
 int xCoordPawn = (int)pawn.charAt(0)-97;
 int yCoordPawn = Character.getNumericValue(pawn.charAt(1))-1;
 //if(xCoordBish==xCoordPawn) return false;
 //if(yCoordBish==yCoordPawn) return false; 
 int xTemp = xCoordBish;
 int yTemp = yCoordBish;
 //System.out.println("before winding "+xTemp+" "+yTemp);
 while(xTemp>0)
 {
  if(yTemp==0) break;
  yTemp--;
  xTemp--;
  if((yTemp==yCoordPawn)&&(xTemp==xCoordPawn))return true;
 }
 //System.out.println("winded back "+xTemp+" "+yTemp);
 xTemp = xCoordBish;
 yTemp = yCoordBish;
 while(xTemp<8)
 {
  if(yTemp==7) break;
  yTemp++;
  xTemp++;
  if((yTemp==yCoordPawn)&&(xTemp==xCoordPawn))return true;
 }
 xTemp = xCoordBish;
 yTemp = yCoordBish;
 while(xTemp<8)
 {
  if(yTemp==0) break;
  yTemp--;
  xTemp++;
  if((yTemp==yCoordPawn)&&(xTemp==xCoordPawn))return true;
 }
 xTemp = xCoordBish;
 yTemp = yCoordBish;
 while(xTemp>0)
 {
  if(yTemp==7) break;
  yTemp++;
  xTemp--;
  if((yTemp==yCoordPawn)&&(xTemp==xCoordPawn))return true;
 }
 return false; 
}


