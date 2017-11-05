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
public class BubbleSortMinHeap extends BubbleSort {

    /**
     *
     * @return Description of sorting
     */
    @Override
    public String toString() {
        return "Bubble Sort with Min-Heap";
    }

    @Override
    int compare(int first, int second) {
        return first > second ? 1 : 0;
    }

}
