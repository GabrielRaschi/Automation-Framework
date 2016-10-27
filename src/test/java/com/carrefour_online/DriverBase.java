package com.carrefour_online;

import com.carrefour_online.config.DriverFactory;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DriverBase {

    private static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<DriverFactory>());
    private static ThreadLocal<DriverFactory> driverFactory;

    //define an Excel Work Book
    public HSSFWorkbook workbook;
    //define an Excel Work sheet
    public HSSFSheet sheet;
    //define a test result data object
    public Map<String, Object[]> testresultdata;

    @BeforeSuite(alwaysRun = true)
    public void suiteSetUp() {
        //create a new work book
        workbook = new HSSFWorkbook();
        //create a new work sheet
        sheet = workbook.createSheet("Test Results");
        testresultdata = new LinkedHashMap<String, Object[]>();
        //add test result excel file column header
        //write the header in the first row
        testresultdata.put("1", new Object[] {"Test ID", "Action made", "Expected Result", "Actual Result"});

    }

    @BeforeMethod(alwaysRun = true)
    public void instantiateDriverObject() {
        driverFactory = new ThreadLocal<DriverFactory>() {
            @Override
            protected DriverFactory initialValue() {
                DriverFactory driverFactory = new DriverFactory();
                webDriverThreadPool.add(driverFactory);
                return driverFactory;
            }
        };
    }

    public void outputToExcel (String rowNumber, String id, String actionMade, String expectedResult, String actualResult) {
        testresultdata.put(rowNumber, new Object[] {id, actionMade, expectedResult, actualResult});
    }

    public WebDriver getDriver() throws Exception {
        return driverFactory.get().getDriver();
    }

    /*

        @AfterMethod(alwaysRun = true)
        public static void clearCookies() throws Exception {
            getDriver().manage().deleteAllCookies();
        }



    @AfterMethod(alwaysRun = true)
    public void closeDriverObjects() {
        //write excel file and file name is TestResult.xls
        Set<String> keyset = testresultdata.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = testresultdata.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof Date)
                    cell.setCellValue((Date)obj);
                else if(obj instanceof Boolean)
                    cell.setCellValue((Boolean)obj);
                else if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Double)
                    cell.setCellValue((Double)obj);
            }
        }
        try {
            File f = new File("TestResults.xls");
            if (!f.exists()) {
                f.createNewFile();
                FileOutputStream out =new FileOutputStream(f);
                workbook.write(out);
            } else {
                FileOutputStream out = new FileOutputStream(f);
                workbook.write(out);
                out.close();
                System.out.println("Excel written successfully..");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (DriverFactory driverFactory : webDriverThreadPool) {
            driverFactory.quitDriver();
        }
    }
      */
}
