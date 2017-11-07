package com.vv0rkman.fillers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class FillerTest {
    private final static int DEFAULT_SIZE = 8;

    @Test
    void generateSortedArrayASC_Null() {
        int[] test = Filler.generateSortedArrayASC(128);
        Assertions.assertNotNull(test);
    }

    @Test
    void generateSortedArrayASC_Size() {
        int[] test = Filler.generateSortedArrayASC(256);
        Assertions.assertEquals(256, test.length);
    }

    @Test
    void generateSortedArrayASC_Order() {
        int[] test = Filler.generateSortedArrayASC(64);
        boolean check = true;
        for (int i = 1; i < test.length; i++) {
            if ((test[i] < test[i - 1])) {
                check = false;
                break;
            }
        }
        Assertions.assertTrue(check);
    }

    @Test
    void generateSortedArrayASC_Wrong_Size() {
        int[] test = Filler.generateSortedArrayASC(-2048);
        Assertions.assertEquals(DEFAULT_SIZE, test.length);
        test = Filler.generateSortedArrayASC(0);
        Assertions.assertEquals(DEFAULT_SIZE, test.length);
    }

    @Test
    void generateSortedArrayASC_X_Null() {
        int[] test = Filler.generateSortedArrayASC_X(128);
        Assertions.assertNotNull(test);
    }

    @Test
    void generateSortedArrayASC_X_Size() {
        int[] test = Filler.generateSortedArrayASC_X(256);
        Assertions.assertEquals(256, test.length);
    }

    @Test
    void generateSortedArrayASC_X_Order() {
        int[] test = Filler.generateSortedArrayASC_X(64);
        boolean check = true;
        for (int i = 1; i < test.length - 1; i++) {
            if ((test[i] < test[i - 1])) {
                check = false;
                break;
            }
        }
        Assertions.assertTrue(check);
    }

    @Test
    void generateSortedArrayASC_X_Wrong_Size() {
        int[] test = Filler.generateSortedArrayASC_X(-1024);
        Assertions.assertEquals(DEFAULT_SIZE, test.length);
        test = Filler.generateSortedArrayASC_X(0);
        Assertions.assertEquals(DEFAULT_SIZE, test.length);
    }

    @Test
    void generateSortedArrayDESC_Null() {
        int[] test = Filler.generateSortedArrayDESC(128);
        Assertions.assertNotNull(test);
    }

    @Test
    void generateSortedArrayDESC_Size() {
        int[] test = Filler.generateSortedArrayDESC(256);
        Assertions.assertEquals(256, test.length);
    }

    @Test
    void generateSortedArrayDESC_Order() {
        int[] test = Filler.generateSortedArrayDESC(64);
        boolean check = true;
        for (int i = test.length - 1; i >= 1; i--) {
            if ((test[i] > test[i - 1])) {
                check = false;
                break;
            }
        }
        Assertions.assertTrue(check);
    }

    @Test
    void generateSortedArrayDESC_Wrong_Size() {
        int[] test = Filler.generateSortedArrayDESC(-256);
        Assertions.assertEquals(DEFAULT_SIZE, test.length);
        test = Filler.generateSortedArrayDESC(0);
        Assertions.assertEquals(DEFAULT_SIZE, test.length);
    }

    @Test
    void generateRandomArray_Null() {
        int[] test = Filler.generateRandomArray(128);
        Assertions.assertNotNull(test);
    }

    @Test
    void generateRandomArray_Size() {
        int[] test = Filler.generateRandomArray(256);
        Assertions.assertEquals(256, test.length);
    }

    @Test
    void generateRandomArray_Wrong_Size() {
        int[] test = Filler.generateRandomArray(-128);
        Assertions.assertEquals(DEFAULT_SIZE, test.length);
        test = Filler.generateRandomArray(0);
        Assertions.assertEquals(DEFAULT_SIZE, test.length);
    }

}