package com.vv0rkman.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import com.vv0rkman.analyzer.Results;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;


/**
 * @author Victor
 */
public class ExportToXLS {

    public static void exportToXLS(Map<String, Results[]> resultsMap, int fillerSize) {
        //String excelFileName = "E://Test.xls"; //name of excel file Laptop-Win
        String excelFileName = "/mnt/120CA0D50CA0B4DF/Test.xls"; //Laptop-Ubuntu
        //String excelFileName = "/mnt/64B605AAA5746577/Test.xls"; //PC-Win

        HSSFWorkbook wb = new HSSFWorkbook();

        for (Map.Entry<String, Results[]> entry : resultsMap.entrySet()) {
            HSSFSheet sheet = wb.createSheet(entry.getKey());
            HSSFRow row = sheet.createRow(0);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue("Sort Name");
            cell = row.createCell(1);
            cell.setCellValue("Count Of Numbers");
            cell = row.createCell(2);
            cell.setCellValue("Elapsed Time");

            int r = 1;
            for (Results results1 : entry.getValue()) {
                row = sheet.createRow(r++);
                cell = row.createCell(0);
                cell.setCellValue(results1.getSorterName());

                cell = row.createCell(1);
                cell.setCellValue(fillerSize);

                cell = row.createCell(2);
                cell.setCellValue(results1.getResult());
            }
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

}


