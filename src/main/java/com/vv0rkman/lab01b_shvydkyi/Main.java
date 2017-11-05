/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv0rkman.lab01b_shvydkyi;

import com.vv0rkman.analyzer.Analyzer;
import com.vv0rkman.fillers.Filler;
import com.vv0rkman.reflectUtils.ReflectUtils;
import com.vv0rkman.sorters.Sort;

import java.util.List;

/**
 * @author Victor Shvydkyi
 */
public class Main {

    private static final int DEFAULT_SIZE = 10;
    private static int[] sortedArray;

    public static void main(String[] args) {

//        int[] sortedAscArray = FillerA.generateSortedArrayASC(DEFAULT_SIZE);
//        int[] sortedAscXArray = FillerA.generateSortedASCArrayASC_X(DEFAULT_SIZE);
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
