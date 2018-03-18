package com.vv0rkman.analyzer;

import com.vv0rkman.sorters.*;
import com.vv0rkman.excel.ExportToXLS;
import com.vv0rkman.reflectUtils.ReflectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Analyzes time of sorting array
 * @author Victor Shvydkyi
 */
public class Analyzer {
    /**
     * Default value of array size
     */
    private static int size = 10_000;

    /**
     * Invokes fillers and sorters.<br>
     * Executes benchmark and saves result into XLS.
     */
    public static void analyze() {
        Map<String, Results[]> resultsMap = new HashMap<>();
        List<Sort> sorters = ReflectUtils.getSorters();
        int countOfSorters = sorters.size();
        int countOfFillers = ReflectUtils.getCountOfFillers();

        for (int i = 0; i < countOfFillers; i++) {
            Results[] results = new Results[countOfSorters];
            int[] intArray = ReflectUtils.invokeFiller(i, size);

            for (int j = 0; j < countOfSorters; j++) {
                results[j] = new Results();
                results[j].setSorterName(sorters.get(j).toString());
                Long result = getBenchmarkResult(sorters.get(j), intArray);
                results[j].setResult(result);
            }
            resultsMap.put(ReflectUtils.getFillerName(i), results);
        }

        ExportToXLS.fillExistXLS(resultsMap, size);
    }

    /**
     * Sets new size of filled-arrays
     * @param size of array
     */
    public static void setArraySize(int size) {
        Analyzer.size = size;
    }

    /**
     * Return value of parameter <code>size</code>
     * @return size of filled arrays
     */
    public static int getArraySize() {
        return Analyzer.size;
    }


    /**
     * Benchmark of sorting
     * @param sorter object of Class <code>Sort</code>
     * @param inputArray array which be used in sorting
     * @return elapsed time of sorting
     */
    public static Long getBenchmarkResult(Sort sorter, int[] inputArray) {
        long startTime = System.nanoTime();
        sorter.sort(inputArray);
        return System.nanoTime() - startTime;
    }
}

