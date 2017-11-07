package com.vv0rkman.analyzer;

import com.vv0rkman.sorters.*;
import com.vv0rkman.excel.ExportToXLS;
import com.vv0rkman.reflectUtils.ReflectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vv0rkman
 */
public class Analyzer {
    private static int size = 50;

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

        ExportToXLS.exportToXLS(resultsMap, size);
    }

    public static void setArraySize(int size) {
        Analyzer.size = size;
    }

    public static int getArraySize() {
        return Analyzer.size;
    }


    public static Long getBenchmarkResult(Sort sorter, int[] inputArray) {
        long startTime = System.nanoTime();
        sorter.sort(inputArray);
        return System.nanoTime() - startTime;
    }
}

