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
public class BubbleSortMaxHeap extends BubbleSort {

    /**
     *
     * @return Description of sorting
     */
    @Override
    public String toString() {
        return "Bubble Sort with Max-Heap";
    }

    @Override
    protected void iterate(int[] res, int pos) {
        for (int j = res.length - 1; j >=res.length-pos; j--) {
            if (compare(res[j-1],res[j])) {
                swap(res,j-1,j);
            }
        }
    }

    @Override
    boolean compare(int first, int second) {
        return first > second;
    }

}
