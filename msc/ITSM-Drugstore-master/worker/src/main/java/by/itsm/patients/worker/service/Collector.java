package by.itsm.patients.worker.service;

import by.itsm.patients.common.entity.Sale;
import by.itsm.patients.worker.mapper.ReportsMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public class Collector {

    @Autowired
    private SqlSessionFactory sesFact;

    public List<Sale> getSales(Date dateFrom, Date dateTo) {

        try (SqlSession session = sesFact.openSession()) {
            return session.getMapper(ReportsMapper.class).selectSales(dateFrom, dateTo);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public List<Sale> getSales() {

        try {

            Date dateFrom = Date.valueOf("2000-01-01");
            Date dateTo = Date.valueOf("2100-01-01");

            List<Sale> sales = getSales(dateFrom, dateTo);

            return sales;
        } catch (RuntimeException e) {
            throw e;
        }

    }
}
