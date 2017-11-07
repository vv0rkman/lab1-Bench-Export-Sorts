package com.vv0rkman.lab01b_shvydkyi;

import com.vv0rkman.analyzer.Analyzer;

/**
 * @author Victor Shvydkyi
 */
public class Main {

    private static final int DEFAULT_SIZE = 10;
    private static int[] sortedArray;

    public static void main(String[] args) {

//        int[] sortedAscArray = FillerA.generateSortedArrayASC(DEFAULT_SIZE);
//        int[] sortedAscXArray = FillerA.generateSortedArrayASC_X(DEFAULT_SIZE);
//        int[] sortedDescArray = FillerA.generateSortedArrayDESC(DEFAULT_SIZE);
//        int[] randomArray = FillerA.generateRandomArray(DEFAULT_SIZE);
//
//        for (int i : randomArray) {
//            System.out.println(i);
//        }
//
//        ArraysSort as = new ArraysSort();
//        BubbleSortMaxHeap bsMaxH = new BubbleSortMaxHeap(); 
//        BubbleSortMinHeap bsMinH = new BubbleSortMinHeap();
//        ShellSort ss = new ShellSort();
//        MergeSort ms = new MergeSort();
//
//        if ((randomArray != null) && (randomArray.length > 0)) {
//            sortedArray = bsMaxH.sort(randomArray);
//            System.out.println("");
//
//            for (int i : sortedArray) {
//                System.out.println(i);
//            }
//
//        } else {
//            System.out.println("You have problem with array");
//        }

        Analyzer.analyze();
    }

}
