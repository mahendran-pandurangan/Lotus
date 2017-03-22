package com.lotus.datasource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Slf4j
public class ExcelTableProvider {
  public static Workbook workBook;
  private InputStream inputStream;
  public static String[][] readExcelData(String fileName, String sheetName,
      String tableName) {
    String[][] testData = null;
    System.setProperty("sCurrentTestCase", sheetName);
    System.setProperty("sDataSheet", tableName);
    log.info("Reading file, sheet, table: " + fileName + ", " + sheetName + ", " + tableName);
    try {
      if(fileName != null && !fileName.trim().isEmpty()) {
        if (fileName.toLowerCase().endsWith("xlsx")) {
          workBook = new XSSFWorkbook(new FileInputStream(fileName));
        }
        else if (fileName.toLowerCase().endsWith("xls")) {
          workBook = new HSSFWorkbook(new FileInputStream(fileName));
        }
        Sheet sheet =  workBook.getSheet(sheetName);
        Cell[] boundaryCells = findCell(sheet, tableName);
        Cell startCell = boundaryCells[0];
        Cell endCell = boundaryCells[1];
        int startRow = startCell.getRowIndex() + 1;
        int endRow = endCell.getRowIndex();
        int startCol = startCell.getColumnIndex() + 1;
        int endCol = endCell.getColumnIndex() - 1;
        testData = new String[endRow - startRow + 1][endCol - startCol + 1];
        for (int i = startRow; i < endRow + 1; i++) {
          for (int j = startCol; j < endCol + 1; j++) {
            if (sheet.getRow(i).getCell(j).getCellType() ==  XSSFCell.CELL_TYPE_STRING) {
              testData[i - startRow][j - startCol] = sheet.getRow(i)
                  .getCell(j).getStringCellValue();
            } else if (sheet.getRow(i).getCell(j).getCellType() ==  XSSFCell.CELL_TYPE_NUMERIC) {
              Double temp = sheet.getRow(i).getCell(j)
                  .getNumericCellValue();
              testData[i - startRow][j - startCol] = String
                  .valueOf(temp.intValue());
            }
            else if (sheet.getRow(i).getCell(j).getCellType() == HSSFCell.CELL_TYPE_STRING) {
              testData[i - startRow][j - startCol] = sheet.getRow(i)
                  .getCell(j).getStringCellValue();
            } else if (sheet.getRow(i).getCell(j).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
              Double temp = sheet.getRow(i).getCell(j)
                  .getNumericCellValue();
              testData[i - startRow][j - startCol] = String
                  .valueOf(temp.intValue());
            }
          }
        }
      }else {
        throw new IllegalArgumentException("fileName cannot be null/empty");
      }
    }
    catch (FileNotFoundException fnfe) {
      log.info("Could not read the Excel sheet");
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      log.info("Could not read the Excel sheet");
      ioe.printStackTrace();
    }
    return testData;
  }

  public static Cell[] findCell(Sheet sheet, String text) {
    String pos = "start";
    Cell[] cells = new Cell[2];
    for (Row row : sheet) {
      for (Cell cell : row) {
        if (cell.getCellType() == Cell.CELL_TYPE_STRING
            && text.equals(cell.getStringCellValue())) {
          if (pos.equalsIgnoreCase("start")) {
            cells[0] = cell;
            pos = "end";
          } else {
            cells[1] = cell;
          }
        }
      }
    }
    return cells;
  }
}
