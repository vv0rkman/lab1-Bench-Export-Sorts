/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv0rkman.fillers;

import java.util.Random;

/**
 * @author Victor Shvydkyi
 */
public class Filler {

    private static final Random RANDOM_NUMBER = new Random();
    private static int[] array;
    private static final int UPPER_BOUND = 100;
    private static final int DEFAULT_SIZE = 8;

    /**
     * ASC
     *
     * @param size
     * @return
     */
    @FillerA
    public static int[] generateSortedArrayASC(int size) {
        if (size <= 0) {
            size = DEFAULT_SIZE;
        }

        array = new int[size];
        //array[0] = (int) (Math.random() * 10) + 1;
        array[0] = RANDOM_NUMBER.nextInt(UPPER_BOUND);

        for (int i = 1; i < size; i++) {
            //array[i] = array[i - 1] + (int) (Math.random() * 12) + 2;
            array[i] = array[i - 1] + RANDOM_NUMBER.nextInt(UPPER_BOUND / 2);
        }
        return array;
    }

    /**
     * @param size
     * @return
     */
    @FillerA
    public static int[] generateSortedASCArrayASC_X(int size) {
        array = generateSortedArrayASC(size);
        array[size - 1] = RANDOM_NUMBER.nextInt(UPPER_BOUND);

        return array;
    }

    /**
     * @param size
     * @return
     */
    @FillerA
    public static int[] generateSortedArrayDESC(int size) {
        if (size <= 0) {
            size = DEFAULT_SIZE;
        }

        array = new int[size];
        array[0] = RANDOM_NUMBER.nextInt(UPPER_BOUND);

        for (int i = 1; i < size; i++) {
            //array[i] = array[i - 1] + (int) (Math.random() * 12) + 2;
            array[i] = array[i - 1] - RANDOM_NUMBER.nextInt(UPPER_BOUND / 2);
        }
        return array;
    }

    /**
     * @param size
     * @return
     */
    @FillerA
    public static int[] generateRandomArray(int size) {
        if (size <= 0) {
            size = DEFAULT_SIZE;
        }

        array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = RANDOM_NUMBER.nextInt(UPPER_BOUND);
        }
        return array;
    }

}
