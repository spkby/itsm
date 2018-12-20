package by.itsm.patients.logic.service.domain;

import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.logic.service.ICrudService;

public interface IPatientService extends ICrudService<Patient> {

//    Patient getNew(String phoneNumber, Integer stateId);
//
//    Patient getExist(String phoneNumber);

    Patient findByPhone(String phoneNumber);

}
