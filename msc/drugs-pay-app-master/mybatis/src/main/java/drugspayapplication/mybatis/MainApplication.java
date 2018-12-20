package drugspayapplication.mybatis;

import drugspayapplication.mybatis.config.DaoConfig;
import drugspayapplication.mybatis.dao.TransactionDao;
import drugspayapplication.mybatis.model.Transaction;
import drugspayapplication.mybatis.model.XlsWriter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "drugspayapplication.mybatis")
@MapperScan(basePackages = "drugspayapplication.mybatis.dao.mapper")
public class MainApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApplication.class, args);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
        TransactionDao transactionDao = ctx.getBean(TransactionDao.class);
        List<String> headers = new ArrayList<>();
        headers.add("Patient ID");
        headers.add("Phone");
        headers.add("State");
        headers.add("Product");
        headers.add("Count");
        headers.add("Last Transaction");
        Timestamp dateFrom = Timestamp.valueOf("1999-01-01 00:00:00");
        Timestamp dateTo = Timestamp.valueOf("2001-01-01 00:00:00");
//		Timestamp dateFrom = Timestamp.valueOf(args[1]);
//		Timestamp dateTo = Timestamp.valueOf(args[2]);
        List<Transaction> result = transactionDao.getTransactions(dateFrom, dateTo);
        System.out.println(result);
        XlsWriter xlsWriter = new XlsWriter(headers);
        result.stream().forEach(it -> {
            xlsWriter.writeRow(it.toList());
        });

//		Path path = Paths.get(args[0]);
        Path path = Paths.get("result.xlsx");
        Files.write(path, xlsWriter.toByteArray());
    }
}
