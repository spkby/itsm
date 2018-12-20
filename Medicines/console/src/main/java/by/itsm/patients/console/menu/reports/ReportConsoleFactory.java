package by.itsm.patients.console.menu.reports;

import by.itsm.patients.elasticmq.ReportTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Scanner;

@Component
public class ReportConsoleFactory {

    @Autowired
    private Scanner scanner;

    public ReportTask create() {

        System.out.print("Enter Date From (YYYY-MM-DD) = ");
        Date dateFrom = getDate();

        System.out.print("Enter Date To (YYYY-MM-DD) = ");
        Date dateTo = getDate();

        System.out.print("Enter Filename = ");
        String fileName = scanner.nextLine();

        if (fileName == null || "".equals(fileName)) {
            throw new IllegalArgumentException("Invalid Filename");
        }

        return new ReportTask(fileName, dateFrom, dateTo);
    }

    private Date getDate() {
        try {
            return Date.valueOf(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Date Format");
        }
    }

}
