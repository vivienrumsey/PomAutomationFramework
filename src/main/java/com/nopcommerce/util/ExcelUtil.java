package com.nopcommerce.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil {

    private static Workbook workbook;
    private static Sheet sheet;

    private static String TEST_DATA_SHEET_PATH ="./src/main/java/com/nopcommerce/testdata/newUserRegister.xlsx";

    public static Object[][] getTestData(String sheetName) {
        Object data[][] = null;
        try {
            FileInputStream fis = new FileInputStream(TEST_DATA_SHEET_PATH);
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);

            data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                    data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
