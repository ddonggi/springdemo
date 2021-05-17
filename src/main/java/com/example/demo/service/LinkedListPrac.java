package com.example.demo.service;

import java.util.*;

public class LinkedListPrac {

    public void printList(){
        int[] array = {4,10,55,6,2,4};
        System.out.println("original array : "+ Arrays.toString(array));

        int temp=0;
        for(int i=0; i<array.length;i++){
            for(int k=i+1; k<array.length; k++){
                if (array[i] > array[k]) {
                    temp = array[i];
                    array[i]=array[k];
                    array[k]=temp;
                }
            }
        }
        System.out.println("array after for : "+ Arrays.toString(array));
        System.out.println();

        array = new int[]{4,10,55,6,2,4};
        System.out.println("original array : "+ Arrays.toString(array));
//        for (int i : array) {
//            System.out.println("arr element : "+i);
//        }
        Arrays.sort(array);
        System.out.println("sorted finish!!");
        System.out.println("sorted array : "+ Arrays.toString(array));
    }
    public void printLinkedList() {
        LinkedList<String> strList = new LinkedList<>();
        strList.add("hi");
        strList.add("hello");
        strList.addLast("last");
        strList.addFirst("first");
        strList.add("apple");
        strList.add("zip");
        strList.add("middle");

        //for문 변경
//        for(int x =0; x<strList.size(); x++){
//            System.out.println("elem"+(x+1)+" : "+strList.get(x));
//        }

//        for (String x : strList) { //인덱스 번호가 필요할 경우 쓰자
//            System.out.println("Linked list element >> " + x);
//        }

        strList.forEach(x->System.out.println("Linked List element : "+x));
//        strList.forEach(System.out::println);

        System.out.println("Linked list >>" + strList);
//        strList.sort(String::compareTo);
        Collections.sort(strList);
        System.out.println("Sorted Linked list >>" + strList);
        System.out.println("================== linked list ======================");

    }

    public void printArrayList() {
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(5, 30, 3, 2, 7, 7));
        intList.add(12);
        intList.forEach(x->System.out.println("Array List element : "+x));
        System.out.println("Arraylist >>" + intList);
//        intList.sort(Integer::compareTo);
        Collections.sort(intList);
        System.out.println("Sorted Arraylist >>" + intList);
        System.out.println("================== Array list ======================");
    }

    public void printTreeSet() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(7);
        treeSet.add(4);
        treeSet.add(9);
        treeSet.add(1);
        treeSet.add(5);
        System.out.println("treeSet >> " + treeSet);

        System.out.println("================== Tree Set======================");
    }
}
