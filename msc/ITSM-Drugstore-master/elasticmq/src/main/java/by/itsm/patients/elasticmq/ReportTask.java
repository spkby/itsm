package by.itsm.patients.elasticmq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportTask {

    private String fileName;
    private Date dateFrom;
    private Date dateTo;

}
