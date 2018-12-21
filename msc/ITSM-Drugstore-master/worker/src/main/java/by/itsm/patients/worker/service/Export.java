package by.itsm.patients.worker.service;

import by.itsm.patients.common.entity.Sale;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Component
public class Export {

    @Value("${ext.excel}")
    private String extExcel;

    public void export(String fileName, List<Sale> list) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        CreationHelper createHelper = workbook.getCreationHelper();

        XSSFSheet sheet = workbook.createSheet("Sales");

        Row row;
        int rowNum = 0;

        //create head
        row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue("id");
        row.createCell(1).setCellValue("Date");
        row.createCell(2).setCellValue("Patient");
        row.createCell(3).setCellValue("Product");

        CellStyle cellDateStyle = workbook.createCellStyle();
        cellDateStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-mm-dd"));

        Cell cell;

        for (Sale sale : list) {
            row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(sale.getId());

            cell = row.createCell(1);
            cell.setCellStyle(cellDateStyle);
            cell.setCellValue(convertLocalDateTimeToDate(sale.getDate()));

            row.createCell(2).setCellValue(sale.getPatient().getPhone());
            row.createCell(3).setCellValue(sale.getProduct().getName());
        }

        // date
        sheet.autoSizeColumn(1);

        try {
            FileOutputStream outputStream = new FileOutputStream(fileName + "." + extExcel);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (
                IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {

        LocalTime time = localDateTime.toLocalTime();

        Instant instant = time.atDate(localDateTime.toLocalDate())
                .atZone(ZoneId.systemDefault())
                .toInstant();
        return Date.from(instant);
    }


}
