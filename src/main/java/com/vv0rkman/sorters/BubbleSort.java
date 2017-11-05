/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv0rkman.sorters;

/**
 * Provides an implementation of the bubble sort algorithm.<br>
 * <p>
 * In bubble sort, we basically traverse the array from <code>first</code>
 * to <code>array_length - 1</code><br>
 * position and compare the element with the next one.<br> Element is swapped with
 * the next element if the next element is greater.
 * <br>
 * Bubble sort steps are as follows.
 * <ol>
 * <li> Compare array[0] & array[1]
 * <li> If array[0] > array [1] swap it.
 * <li> Compare array[1] & array[2].
 * <li> If array[1] > array[2] swap it.
 * <li> ...
 * <li> Compare array[n-1] & array[n]
 * <li> if [n-1] > array[n] then swap it.
 * </ol>
 * <p>
 * After this step we will have largest element at the last index.<br>
 * <p>
 * Repeat the same steps for array[1] to array[n-1]
 *
 * @author vv0rkman
 */
abstract class BubbleSort extends Sort {

    @Override
    public final int[] sort(int[] array) {
        boolean swapped = true;
        for (int i = array.length - 1; i > 0 && swapped; i--) {//from 0 to array.length
            swapped = false;
            for (int j = 0; j < i; j++) {
                if (compare(array[j], array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
        }
        return array;
    }

    /**
     * Abstract method which is implemented at BubbleSortMinHeap
     * {@link BubbleSortMinHeap#compare(int, int)} and BubbleSortMinHeap
     * {@link BubbleSortMaxHeap#compare(int, int)}
     *
     * @param first  the first object to be compared.
     * @param second the second object to be compared.
     * @see com.vv0rkman.sorters.BubbleSortMinHeap
     * @see com.vv0rkman.sorters.BubbleSortMaxHeap
     */
    abstract int compare(int first, int second);

    /**
     * Swaps the elements at the specified positions in the specified array
     *
     * @param array The array in which to swap elements.
     * @param from  The index of first element to be swapped
     * @param to    The index of second element to be swapped
     * @throws IndexOutOfBoundsException if either i or j is out of range (i &lt
     *                                   0 || i &gt= list.size() || j &lt 0 || j &gt= list.size())
     */
    private static void swap(int[] array, int from, int to) {
        try {
            int temp = array[from];
            array[from] = array[to];
            array[to] = temp;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds " + e.getLocalizedMessage());
        }
    }
}
