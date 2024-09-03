package com.automationpractice.utils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataProviderUtils {


    @DataProvider
    public Object[] getData() throws IOException {
        FileInputStream fs = new FileInputStream("./src/test/resources/testdata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet("sheet1");
        int row =sheet.getLastRowNum();
        int column = sheet.getRow(0).getLastCellNum();

        Object[] data = new Object[row];
        Map<String,String> map;

        for(int i =1;i<=row;i++)
        {
            map=new HashMap<>();
            for (int j=0;j<column;j++)
            {
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key,value);
                data[i-1]=map;
            }
        }
        return data;



    }
}
