package com.training.service;

import com.training.User;
import com.training.mapper.UserMapper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class UserService {

    private static String[] COLUMNS = {"Id", "Login", "Email", "Password", "CreatedUser", "CreatedDate",
            "UpdateUser", "UpdateDate" };

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void doReport() throws IOException {

        List<User> users = userMapper.findAllUsers();

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Users");

        Row headerRow = sheet.createRow(0);

        //header
        for (int col = 0; col < COLUMNS.length; col++) {
            Cell cell = headerRow.createCell(col);
            cell.setCellValue(COLUMNS[col]);
        }

        DataFormat format = workbook.createDataFormat();
        CellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));

        int rowIdx = 1;
        for (User user : users){
            Row row = sheet.createRow(rowIdx++);

            row.createCell(0).setCellValue(user.getId());
            row.createCell(1).setCellValue(user.getLogin());
            row.createCell(2).setCellValue(user.getEmail());
            row.createCell(3).setCellValue(user.getLogin());
            row.createCell(4).setCellValue(user.getCreatedBy());
            row.createCell(5).setCellStyle(dateStyle);
            row.getCell(5).setCellValue(user.getCreatedAt());
            row.createCell(6).setCellValue(user.getModifiedBy());
            row.createCell(7).setCellStyle(dateStyle);
            row.getCell(7).setCellValue(user.getModifiedAt());
        }

        FileOutputStream fileOut = new FileOutputStream("users.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }
}
