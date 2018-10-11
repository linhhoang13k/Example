boolean areTrianglesSimilar(int[] coordinates) {

    
     double A1B1 = Math.sqrt(Math.pow(coordinates[2]-coordinates[0],2) + Math.pow(coordinates[3]-coordinates[1],2));
     double A1C1 = Math.sqrt(Math.pow(coordinates[4]-coordinates[0],2) + Math.pow(coordinates[5]-coordinates[1],2));
     double B1C1 = Math.sqrt(Math.pow(coordinates[4]-coordinates[2],2) + Math.pow(coordinates[5]-coordinates[3],2));
    
   double A2B2 = Math.sqrt(Math.pow(coordinates[8]-coordinates[6],2) + Math.pow(coordinates[9]-coordinates[7],2));
     double A2C2 = Math.sqrt(Math.pow(coordinates[10]-coordinates[6],2) + Math.pow(coordinates[11]-coordinates[7],2));
     double B2C2 = Math.sqrt(Math.pow(coordinates[10]-coordinates[8],2) + Math.pow(coordinates[11]-coordinates[9],2));
     

 
    return Math.toDegrees(Math.atan(A1B1/(A1C1))) == Math.toDegrees(Math.atan(A2B2/(A2C2))) &&
        Math.toDegrees(Math.atan(A1C1/(B1C1))) == Math.toDegrees(Math.atan(A2C2/(B2C2)));
}


