package by.itsm.patients.web.model;

import lombok.Data;

import java.util.Date;

@Data
public class SaleDto implements IDto {
    private Integer id;
    private Integer patientId;
    private Integer productId;
    private Date date;
}
