package com.itsm.pub.courses.patients.worker.report;

import com.itsm.pub.courses.patients.common.entities.ProductSale;
import com.itsm.pub.courses.patients.worker.mapper.SaleMapper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class SaleReport {

    private final SaleMapper saleMapper;

    @Autowired
    public SaleReport(SaleMapper saleMapper) {
        this.saleMapper = saleMapper;
    }

    public void doReport() throws IOException {
        List<ProductSale> saleList = saleMapper.getSaleList();

        XSSFWorkbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Sales");

        Row titleRow = sheet.createRow(0);

        //id cell
        Cell idCell = titleRow.createCell(0);
        idCell.setCellValue("Id");


        //date cell
        Cell dateCell = titleRow.createCell(1);

        dateCell.setCellValue("date");

        //phone cell
        Cell phoneCell = titleRow.createCell(2);
        phoneCell.setCellValue("phone");

        //product cell
        Cell productCell = titleRow.createCell(3);
        productCell.setCellValue("product");

        DataFormat format = book.createDataFormat();
        CellStyle dateStyle = book.createCellStyle();
        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));

        for (int i = 0; i < saleList.size(); i++) {
            Row row = sheet.createRow(i + 1);
            ProductSale sale = saleList.get(i);

            Cell idDataCell = row.createCell(0);
            idDataCell.setCellValue(sale.getId());

            Cell dateDataCell = row.createCell(1);
            dateDataCell.setCellStyle(dateStyle);
            dateDataCell.setCellValue(sale.getDate());

            Cell phoneDataCell = row.createCell(2);
            phoneDataCell.setCellValue(sale.getPatient().getPhone());

            Cell productDataCell = row.createCell(3);
            productDataCell.setCellValue(sale.getProduct().getName());
        }

        sheet.autoSizeColumn(1);
        book.write(new FileOutputStream("sales.xlsx"));
        book.close();
    }
}