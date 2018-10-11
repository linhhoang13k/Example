package Aston;

import java.util.HashSet;

public class Elevator {
    public static void main(String[] args) {

        int[] weight = {60, 80, 40};
        int[] floor = {3, 2, 5};
        int maxWeight = 200;
        int maxCapacity = 2;

        System.out.println("Stops: " + elevator(weight, floor, maxWeight, maxCapacity));
    }

    private static int elevator(int[] weight, int[] floor, int maxWeight, int maxCapacity) {

        int currentPerson = 0;
        int stopCount = 0;
        int lastPerson = floor.length;
        int currentWeight = 0;
        int currentCapacity = 0;
        HashSet<Integer> floorSelection = new HashSet<>();

        for (int person: floor) {
            currentPerson++;
            currentCapacity++;
            currentWeight = currentWeight + weight[currentPerson-1];
            if (floorSelection.add(person)) {
                stopCount++; //(add stop for each floor selected)
            }
            if (currentPerson == lastPerson) {
                break; //(don't check for max load on last person)
            }
            if (currentCapacity >= maxCapacity || currentWeight >= maxWeight) {
                floorSelection.clear();
                currentCapacity = 0;
                currentWeight = 0;
                stopCount++; //(add stop for returning to floor 1 to pickup more people)
            }
        }
        return ++stopCount; //(add stop for final return to floor 1)
    }
}



//tests

//original
//            stopCount++;
//            if (floorSelection.add(person)) {
//            } else {
//                stopCount--;
//            }

// stopCount++; //before return

//    int maxWeight2 = 200;
//    int maxCapacity2 = 3;
//
//    int[] weight2 = {60, 80, 40, 60};
//    int[] floor2 = {3, 2, 5, 4};
//    int[] weight3 = {60, 80, 40, 60, 50};
//    int[] floor3 = {3, 2, 5, 4, 2};
//    int[] weight4 = {60, 80, 40, 60};
//    int[] floor4 = {2, 2, 2, 2};
//    int[] weight5 = {60, 80, 40, 60};
//    int[] floor5 = {2, 2, 2, 3};
//
//        System.out.println(elevator(weight2, floor2, maxWeight, maxCapacity)); //expected 6
//                System.out.println(elevator(weight3, floor3, maxWeight, maxCapacity)); //expected 8
//                System.out.println(elevator(weight4, floor4, maxWeight, maxCapacity)); //expected 4
//                System.out.println(elevator(weight5, floor5, maxWeight2, maxCapacity2)); //expected 4


