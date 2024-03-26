package com.ivanov;

import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//.getCell(2).getStringCellValue().isEmpty();
public class Main {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        String pathExcel = "F:\\EXCELDIR\\Фильтры для воды.xlsx";
        String pathDirectory = "F:\\WORKDIR\\PREPARE";
        String nameExcel = pathExcel.substring(12, pathExcel.indexOf("."));
        String pathCategory = pathDirectory.concat("\\" + nameExcel);
        String directoryCols = pathCategory.concat("\\cols.txt");

        System.out.println(nameExcel);

        FileInputStream fis = new FileInputStream(pathExcel);
        Workbook wb = WorkbookFactory.create(fis);
        //////////
        int numberOfCols = wb.getSheetAt(0).getRow(2).getLastCellNum();

        File directoryCategory = new File(pathCategory);
        if (!directoryCategory.exists()) {
            directoryCategory.mkdir();
        }
        File colsCategory = new File(directoryCols);
        if (!colsCategory.exists()) {
            colsCategory.createNewFile();
        }

        PrintWriter writerColsCategory = new PrintWriter(colsCategory);
        for (int num = 3; num < numberOfCols; num++) {

            String valueParameter = wb.getSheetAt(0).getRow(2).getCell(num).getStringCellValue();
            writerColsCategory.println(valueParameter);
        }

        fis.close();
        writerColsCategory.close();
        ////////////


        //////////
        int numberofRows = wb.getSheetAt(0).getLastRowNum();
//        System.out.println(s);
        System.out.println(wb.getSheetAt(0).getRow(numberofRows).getCell(1));

        String date = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH.mm.ss").format(LocalDateTime.now());
        String directoryDate = pathCategory + "\\" + date + ".txt";
        File fileNames = new File(directoryDate);
        if (!fileNames.exists()) {
            fileNames.createNewFile();
        }
        PrintWriter writerNames = new PrintWriter(fileNames);
        for (int numOfRow = 3; numOfRow <= numberofRows; numOfRow++) {

            String str = wb.getSheetAt(0).getRow(numOfRow).getCell(1).getStringCellValue();
            writerNames.println(str);
        }

        fis.close();
        writerNames.close();
        //////////
    }
}
