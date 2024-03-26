//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.*;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class Test {
//    public static void main(String[] args) {
//        String fileName = "F:\\EXCELDIR\\Фильтры для воды.xlsx";
//
//        try (FileInputStream fis = new FileInputStream(fileName);
//             Workbook workbook = WorkbookFactory.create(fis)) {
//
//            Sheet sheet = workbook.getSheetAt(0); // Получаем первый лист
//
//            int lastRow = sheet.getLastRowNum(); // Получаем номер последней строки
//
//            System.out.println("Номер последней строки: " + lastRow);
//
//        } catch (IOException | InvalidFormatException e) {
//            e.printStackTrace();
//        }
//    }
//}