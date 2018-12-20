package com.itsm.pub.courses.patients.worker;

import com.itsm.pub.courses.patients.common.entities.ProductSale;
import com.itsm.pub.courses.patients.common.entities.State;
import com.itsm.pub.courses.patients.worker.configuration.WorkerConfig;
import com.itsm.pub.courses.patients.worker.mapper.SaleMapper;
import com.itsm.pub.courses.patients.worker.mapper.StateMapper;
import com.itsm.pub.courses.patients.worker.report.SaleReport;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.io.IOException;
import java.util.List;

public class WorkerMain {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WorkerConfig.class);
//        StateMapper stateMapper = context.getBean(StateMapper.class);
//        SaleMapper  saleMapper  = context.getBean(SaleMapper.class);
//
//        State state = stateMapper.getStateById(1);
//        ProductSale sale = saleMapper.getSale(1);
//
//        List<ProductSale> saleList = saleMapper.getSaleList();
//
//        System.out.println(state);
//        System.out.println(sale);
//
//        saleList.forEach(System.out::println);
//
//        SaleReport report = context.getBean(SaleReport.class);
//        report.doReport();

//        Jedis jedis = new Jedis("localhost", 6379);
//
//        jedis.lpush("queue_name", "value");
//
//        String value = jedis.rpop("queue_name");
//
//        System.out.println(value);


    }
}
