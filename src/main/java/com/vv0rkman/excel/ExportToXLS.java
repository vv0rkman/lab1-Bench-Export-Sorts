package com.vv0rkman.excel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileOutputStream;
import java.io.IOException;

import com.vv0rkman.analyzer.Results;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;


/**
 * @author Victor
 */
public class ExportToXLS {

    public static void exportToXLS(Results[] results, int fillerSize, int countOfFillers) throws IOException {
        //String excelFileName = "E://Test.xls";//name of excel file
        //String excelFileName = "/mnt/120CA0D50CA0B4DF/Test.xls";
        String excelFileName = "/mnt/64B605AAA5746577/Test.xls";

        HashMap<String, Long> resultsData;

//        Iterator<Long> keySetIterator = results.keySet().iterator();
//        while (keySetIterator.hasNext()) {
//            Long k = keySetIterator.next();
//            System.out.println(results.get(k));
//            System.out.println(k);
//
//        }
//        System.out.println(results.keySet());

        HSSFWorkbook wb = new HSSFWorkbook();

        for (int i = 0; i < countOfFillers; i++) {
            HSSFSheet sheet = wb.createSheet(results[i].getFillerName());
            HSSFRow row = sheet.createRow(0);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue("Sort Name");
            cell = row.createCell(1);
            cell.setCellValue("Count Of Numbers");
            cell = row.createCell(2);
            cell.setCellValue("Elapsed Time");

            int r = 1;
            resultsData = results[i].getResults();
            for (String k : resultsData.keySet()) {
                row = sheet.createRow(r++);
                cell = row.createCell(0);
                cell.setCellValue(k);

                cell = row.createCell(1);
                cell.setCellValue(fillerSize);

                cell = row.createCell(2);
                cell.setCellValue(resultsData.get(k));
            }

        }

        try (FileOutputStream fileOut = new FileOutputStream(excelFileName)) {
            wb.write(fileOut);
            fileOut.flush();
        }
    }

}


