package com.amazon.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataProducts {

    public static ArrayList<Map<String, String>> extractTo() {
        ArrayList<Map<String, String>> nameProducts = new ArrayList<>();

        try (FileInputStream file = new FileInputStream("src/main/resources/data/DataSearchProducts.xlsx")) {
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet("Products");

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Map<String, String> product = new HashMap<>();

                product.put("ProductList", row.getCell(0).getStringCellValue());
                nameProducts.add(product);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer la hoja de cálculo", e);
        }
        return nameProducts;
    }
}

