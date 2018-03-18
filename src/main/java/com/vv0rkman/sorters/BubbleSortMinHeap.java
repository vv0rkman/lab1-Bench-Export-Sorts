/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv0rkman.sorters;

/**
 * @author Victor Shvydkyi
 */
public class BubbleSortMinHeap extends BubbleSort {

    /**
     * @return Description of sorting
     */
    @Override
    public String toString() {
        return "Bubble Sort with Min-Heap";
    }

    @Override
    protected void iterate(int[] res, int pos) {
        for (int j = 0; j < pos; j++) {
            if (compare(res[j], res[j + 1])) {
                swap(res, j, j + 1);
            }
        }
    }

    @Override
    boolean compare(int first, int second) {
        return first > second;
    }

}
