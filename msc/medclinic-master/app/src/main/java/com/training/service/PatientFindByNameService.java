package com.training.service;

import com.training.Patient;

public interface PatientFindByNameService extends EntityCrudService<Patient> {
    Patient findByName(String name);
}
