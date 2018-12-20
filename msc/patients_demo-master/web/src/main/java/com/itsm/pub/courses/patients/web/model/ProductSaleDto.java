package com.itsm.pub.courses.patients.web.model;

import lombok.Data;

import java.util.Date;

@Data
public class ProductSaleDto implements IDto {
    private Integer id;
    private Integer patientId;
    private Integer productId;
    private Date date;
}
