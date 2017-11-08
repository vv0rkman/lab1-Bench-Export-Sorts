package com.vv0rkman.fillers;

import java.util.Random;

/**
 * @author Victor Shvydkyi
 */
public class Filler {

    private static final Random RANDOM_NUMBER = new Random();
    private static int[] array;
    /**
     * Upper bound of random-generated number
     */
    private static final int UPPER_BOUND = 100;
    /**
     * Default size of array. Used in exceptional situations.
     */
    private static final int DEFAULT_SIZE = 8;

    /**
     * Generates sorted array.<br>
     * Order: ASC.
     *
     * @param size of array
     * @return array with sorted numbers
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
     * Generates sorted array.<br>
     * Last element is random.<br>
     * Order: ASC.
     *
     * @param size of array
     * @return array with sorted numbers
     */
    @FillerA
    public static int[] generateSortedArrayASC_X(int size) {
        if (size <= 0) {
            size = DEFAULT_SIZE;
        }
        array = generateSortedArrayASC(size);
        array[size - 1] = RANDOM_NUMBER.nextInt(UPPER_BOUND);

        return array;
    }

    /**
     * Generates sorted array.<br>
     * Order: DESC.
     *
     * @param size of array
     * @return array with sorted numbers
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
     * Generates random array.<br>
     *
     * @param size of array
     * @return array with sorted numbers
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
