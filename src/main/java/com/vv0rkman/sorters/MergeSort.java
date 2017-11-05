/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv0rkman.sorters;

/**
 *
 * @author Victor Shvydkyi
 */
public class MergeSort extends Sort {

    /**
     *
     * @return Description of sorting
     */
    @Override
    public String toString() {
        return "Merge Sort";
    }

    @Override
    public int[] sort(int[] array) {
//        int leftSize = array.length / 2;
//        int rightSize = array.length - leftSize;
        if (array.length <= 1) {
            return array;
        }

        int[] first = new int[array.length / 2];
        int[] second = new int[array.length - first.length];
        System.arraycopy(array, 0, first, 0, first.length);
        System.arraycopy(array, first.length, second, 0, second.length);

//
//        int[] left = Arrays.copyOfRange(array, 0, leftSize);
//        int[] right = Arrays.copyOfRange(array, leftSize, rightSize);
        sort(first);
        sort(second);
        merge(array, first, second);

        return array;
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int n1 = left.length;
        int n2 = right.length;
        int i1 = 0; //Index Position in first array - starting with first element
        int i2 = 0;//Index Position in second array - starting with first element
        for (int i = 0; i < array.length; i++) {
            if (i2 == n2 || (i1 < n1 && left[i1] < right[i2])) {
                array[i] = left[i1];
                i1++;
            } else {
                array[i] = right[i2];
                i2++;
            }
        }
    }

}
