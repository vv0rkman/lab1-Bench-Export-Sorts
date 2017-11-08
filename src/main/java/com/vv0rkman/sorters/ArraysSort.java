/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv0rkman.sorters;

import java.util.Arrays;

/**
 * @author Victor Shvydkyi
 */
public class ArraysSort extends Sort {

    /**
     * @return Description of sorting
     */
    @Override
    public String toString() {
        return "Arrays.sort";
    }

    /**
     * Method which sorts array
     * @param array unsorted array
     * @return sorted array
     */
    @Override
    public int[] sort(int[] array) {
        if (!(array == null)) {
            Arrays.sort(array);
            return array;
        } else {
            throw new NullPointerException("Input array is null");
        }
    }

}
