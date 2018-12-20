package com.training.service;

import com.training.Transaction;
import com.training.mapper.TransactionMapper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class TransactionService {

    private static String[] COLUMNS = {"Id", "Date", "Phone", "Product"};

    private final TransactionMapper transactionMapper;

    @Autowired
    public TransactionService(TransactionMapper transactionMapper) {
        this.transactionMapper = transactionMapper;
    }

    public void doReport() throws IOException {

        List<Transaction> transactions = transactionMapper.getListTransaction();

        Workbook workbook = new XSSFWorkbook();

        CreationHelper createHelper = workbook.getCreationHelper();

        Sheet sheet = workbook.createSheet("Transactions");

        Row headerRow = sheet.createRow(0);

        //header
        for (int col = 0; col < COLUMNS.length; col++) {
            Cell cell = headerRow.createCell(col);
            cell.setCellValue(COLUMNS[col]);
        }

        DataFormat format = workbook.createDataFormat();
        CellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));

        for (int i = 0; i < transactions.size(); i++) {
            Row row = sheet.createRow(i + 1);
            Transaction transaction = transactions.get(i);

            Cell idDataCell = row.createCell(0);
            idDataCell.setCellValue(transaction.getId());

            Cell dateDataCell = row.createCell(1);
            dateDataCell.setCellStyle(dateStyle);
            dateDataCell.setCellValue(transaction.getDate());

            Cell phoneDataCell = row.createCell(2);
            phoneDataCell.setCellValue(transaction.getPatient_id().getPhone());

            Cell productDataCell = row.createCell(3);
            productDataCell.setCellValue(transaction.getProduct_id().getName());
        }

        sheet.autoSizeColumn(1);
        FileOutputStream fileOut = new FileOutputStream("transactions.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }
}
