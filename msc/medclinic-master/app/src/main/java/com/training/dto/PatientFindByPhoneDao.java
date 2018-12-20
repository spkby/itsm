package com.training.dto;

import com.training.Patient;

public interface PatientFindByPhoneDao extends EntityCrudDao<Patient> {
    Patient findByPhone(String phone);
}
