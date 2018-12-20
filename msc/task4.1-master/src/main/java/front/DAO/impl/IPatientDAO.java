package front.DAO.impl;

import front.DAO.ICRUDOperations;
import front.models.Patient;


public interface IPatientDAO extends ICRUDOperations<Patient> {

     Patient findPatientByPhoneNumber(Integer patientPhone);

}

