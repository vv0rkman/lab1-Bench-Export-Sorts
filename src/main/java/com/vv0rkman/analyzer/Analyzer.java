/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv0rkman.analyzer;

import com.vv0rkman.excel.ExportToXLS;
import com.vv0rkman.sorters.*;
import com.vv0rkman.reflectUtils.ReflectUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author vv0rkman
 */
public class Analyzer {
    private static int size = 50;
    private static HashMap<String, Long> resultsData = new HashMap<>();

    public static void analyze() {
        List<Sort> sorters = ReflectUtils.getSorters();
        int countOfFillers = ReflectUtils.getCountOfFillers();
        //String[] fillerNames = new String[ReflectUtils.getCountOfFillers()];
        Results[] results = new Results[ReflectUtils.getCountOfSorters()];
//        for (int i = 0; i < sorters.size(); i++) {
//            Sort sorter = sorters.get(i);
//            for (int j = 0; j < ReflectUtils.getCountOfFillers(); j++) {
//                int[] intArray = ReflectUtils.invokeFiller(j);
//                Long result = getBenchmarkResult(sorter, intArray);
//                results.put(sorter.toString(), result);
//            }
//        }

        for (int j = 0; j < countOfFillers; j++) {
            results[j] = new Results();
            results[j].setFillerName(ReflectUtils.getFillerName(j));
            //fillerNames[j] = (ReflectUtils.getFillerName(j));
            //System.out.println(fillerNames[j]);
            int[] intArray = ReflectUtils.invokeFiller(j, size);
            for (Sort sorter : sorters) {
                Long result = getBenchmarkResult(sorter, intArray);
                resultsData.put(sorter.toString(), result);
            }
            results[j].setResults(resultsData);
            System.out.println(results[j].getResults());
        }
        System.out.println(results[2].getResults());
        executeExportToXLS(results, size, countOfFillers);
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


    public static void executeExportToXLS(Results[] results, int fillerSize,
                                          int countOfFillers) {
        try {
            ExportToXLS.exportToXLS(results, size, countOfFillers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

