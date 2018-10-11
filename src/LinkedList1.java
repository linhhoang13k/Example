package com.taidev198.game.CodingInterview.LinkedList;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * @author traig on 7/21/2018.
 * @project Codefights
 */
public class LinkedList1 {

    // Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
     static LinkedList.ListNode<Integer> addTwoHugeNumbers(LinkedList.ListNode<Integer> li, LinkedList.ListNode<Integer> la) {
         BigInteger  NumberA = new BigInteger(String.valueOf(0));
         BigInteger  NumberB = new BigInteger(String.valueOf(0));
         while(li != null){
             NumberA = NumberA.multiply(BigInteger.valueOf(10000)).add(BigInteger.valueOf(li.value));
             li = li.next;
         }
         while(la != null){
             NumberB = NumberB.multiply(BigInteger.valueOf(10000)).add(BigInteger.valueOf(la.value));
             la = la.next;
         }
         NumberA  = NumberA.add(NumberB);
         StringBuilder temp  = new StringBuilder(NumberA.toString());
         int size  = temp.length() /4;
         LinkedList.ListNode<Integer> result = new LinkedList.ListNode<>(0);
         LinkedList.ListNode<Integer> list =result;
         if (temp.length() % 4 != 0){
             result.next = new LinkedList.ListNode<>(Integer.parseInt(temp.substring(0,temp.length()-size*4)));
             temp.delete(0,temp.length()-size*4);
         }
         else{
             result.next = new LinkedList.ListNode<>(Integer.parseInt(temp.substring(0,4)));
             temp.delete(0,4);
         }
         int i =0;
         while (i + 4 <=temp.length() ){
             list = list.next;
             list.next = new LinkedList.ListNode<>(Integer.parseInt(temp.substring(i,i +4)));
             i += 4;
             size--;
         }
         while (result != null){
             System.out.println(result.value);
             result = result.next;
         }
    return result.next;
    }


   static char firstDigit(String inputString) {
        int n = inputString.length();
        char ch = inputString.charAt(0);
        int i = 0;
        while(!Character.toString(ch).matches("[0-9]") ){
            ch = inputString.charAt(i);
            i++;
        }
        return  ch;
    }


    static LinkedList.ListNode<Integer> reverseNode(LinkedList.ListNode<Integer> root){

        LinkedList.ListNode<Integer> p1= root;
        LinkedList.ListNode<Integer> p2 = root.next;
        LinkedList.ListNode<Integer> fake = new LinkedList.ListNode<>(0);
        fake.next = root;
        while (p1 != null && p2 != null){
            p1.next = p2.next;
            p2.next = p1;
            fake.next = p2;
            p2 = p1.next;
            p1 = p2.next;
        }

         return fake.next;
    }
    public static void main(String...args){


        LinkedList.ListNode<Integer> li = new LinkedList.ListNode<>(123);
        li.next = new LinkedList.ListNode<>(4);
        li.next.next = new LinkedList.ListNode<>(5);
        li.next.next.next = new LinkedList.ListNode<>(4);
//        li.next.next.next.next = new LinkedList.ListNode<>(5);
//        li.next.next.next.next.next = new ListNode<>(6);
//        li.next.next.next.next.next.next = new ListNode<>(7);
//        li.next.next.next.next.next.next.next = new ListNode<>(8);

        LinkedList.ListNode<Integer> la = new LinkedList.ListNode<>(100);
        la.next = new LinkedList.ListNode<>(100);
        la.next.next = new LinkedList.ListNode<>(100);
//        la.next.next.next = new LinkedList.ListNode<>(9999);
        BigInteger d= new BigInteger("1");
        BigDecimal b = new BigDecimal("1");


    }


}
