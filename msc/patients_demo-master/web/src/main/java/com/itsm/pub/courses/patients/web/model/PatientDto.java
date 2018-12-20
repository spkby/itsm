package com.itsm.pub.courses.patients.web.model;

import lombok.Data;

@Data
public class PatientDto implements IDto {
    private Integer id;
    private String phone;
    private Integer stateId;
}
