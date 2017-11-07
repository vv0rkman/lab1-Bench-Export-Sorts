package com.vv0rkman.sorters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    private Sort sorter;
    private int[] unsortedArray = new int[9];
    private int[] sortedArray = new int[9];
    private int[] nullArray = new int[1];

    @BeforeEach
    void setUp() {
        sorter = new MergeSort();
        this.unsortedArray = new int[]{20, 34, 167, 11, 24, 1, -7, 123, -30};
        this.sortedArray = new int[]{-30, -7, 1, 11, 20, 24, 34, 123, 167};
        this.nullArray = null;
    }

    @Test
    void sort() {
        int[] result = sorter.sort(unsortedArray);
        Assertions.assertArrayEquals(sortedArray, result);
    }

    @Test
    void sort_Null() {
        Assertions.assertThrows(NullPointerException.class, ()->{sorter.sort(nullArray);}, "Input array is null");
    }
}