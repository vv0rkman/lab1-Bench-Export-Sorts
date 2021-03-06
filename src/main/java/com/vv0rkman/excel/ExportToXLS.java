package com.vv0rkman.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import com.vv0rkman.analyzer.Results;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;


/**
 * Modules for creating new or opening and filling existed XLS Document.
 * @author Victor Shvydkyi
 */
public class ExportToXLS {

    /**
     * Creates and fills new XLS Document. Graph isn't included.
     * @param resultsMap data which include names of fillers {@link com.vv0rkman.fillers.Filler}
     * ,sorters {@link com.vv0rkman.sorters} and results {@link com.vv0rkman.analyzer.Results}.
     * @param fillerSize count of numbers in array
     * @see com.vv0rkman.fillers.Filler
     * @see com.vv0rkman.sorters
     * @see com.vv0rkman.analyzer.Results
     */
    private static void fillNewXLS(Map<String, Results[]> resultsMap, int fillerSize) {
        String excelFileName = "Result.xls";

        HSSFWorkbook wb = new HSSFWorkbook();

        for (Map.Entry<String, Results[]> entry : resultsMap.entrySet()) {
            HSSFSheet sheet = wb.createSheet(entry.getKey());
            HSSFRow row = sheet.createRow(0);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue("Sort Name");
            cell = row.createCell(1);
            cell.setCellValue("Elapsed Time");

            int r = 1;
            for (Results results1 : entry.getValue()) {
                row = sheet.createRow(r++);
                cell = row.createCell(0);
                cell.setCellValue(results1.getSorterName());

                cell = row.createCell(1);
                cell.setCellValue(results1.getResult());
            }
            row = sheet.createRow(r++);
            cell = row.createCell(0);
            cell.setCellValue("Count of Elements:");
            cell = row.createCell(1);
            cell.setCellValue(fillerSize);

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
        }

        try (FileOutputStream fileOut = new FileOutputStream(excelFileName)) {
            wb.write(fileOut);
            fileOut.flush();
            System.out.println("Data has been exported");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Opens and fills existed XLM Document. Graph is included.
     * @param resultsMap data which include names of fillers {@link com.vv0rkman.fillers.Filler}
     * ,sorters {@link com.vv0rkman.sorters} and results {@link com.vv0rkman.analyzer.Results}.
     * @param fillerSize count of numbers in array
     * @see com.vv0rkman.fillers.Filler
     * @see com.vv0rkman.sorters
     * @see com.vv0rkman.analyzer.Results
     */
    public static void fillExistXLS(Map<String, Results[]> resultsMap, int fillerSize) {
        try {
            FileInputStream fileIn = new FileInputStream("Template.xls");
            HSSFWorkbook wb = new HSSFWorkbook(fileIn);
            Row row;
            Cell cell;

            int i = 0;
            for (Map.Entry<String, Results[]> entry : resultsMap.entrySet()) {
                HSSFSheet sheet = wb.getSheetAt(i++);

                int r = 1;
                for (Results results1 : entry.getValue()) {
                    row = sheet.getRow(r++);
                    cell = row.createCell(0);
                    cell.setCellValue(results1.getSorterName());

                    cell = row.createCell(1);
                    cell.setCellValue(results1.getResult());
                }
                row = sheet.getRow(r++);
                cell = row.createCell(0);
                cell.setCellValue("Count of Elements:");
                cell = row.createCell(1);
                cell.setCellValue(fillerSize);

                sheet.autoSizeColumn(0);
                sheet.autoSizeColumn(1);
            }

            FileOutputStream fileOut = new FileOutputStream("Result.xls");
            wb.write(fileOut);
            fileOut.flush();
            fileOut.close();
            fileIn.close();
            System.out.println("Data has been exported");
        }catch (FileNotFoundException e){
            fillNewXLS(resultsMap,fillerSize);
            System.out.println("Template file is not exist. Created new xls document.");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}


