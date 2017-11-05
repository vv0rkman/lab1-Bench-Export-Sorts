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
public class ShellSort extends Sort {
    /**
     *
     * @return Description of sorting
     */
    @Override
    public String toString() {
        return "Shell Sort";
    }

    @Override
    public int[] sort(int[] array) {
        int i1, i, j, increment, temp, number_of_elements = array.length;
        /* Shell Sort Program */
        for (increment = number_of_elements / 2; increment > 0; increment /= 2) {
            for (i = increment; i < number_of_elements; i++) {
                temp = array[i];
                for (j = i; j >= increment; j -= increment) {
                    if (temp < array[j - increment]) {
                        array[j] = array[j - increment];
                    } else {
                        break;
                    }
                }
                array[j] = temp;
            }

        }
        return array;

    }
}
