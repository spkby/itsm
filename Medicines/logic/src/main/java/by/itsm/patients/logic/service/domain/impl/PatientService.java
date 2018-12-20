package by.itsm.patients.logic.service.domain.impl;

import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.logic.exception.DatabaseException;
import by.itsm.patients.logic.repository.domain.IPatientRepository;
import by.itsm.patients.logic.service.AbstractCrudService;
import by.itsm.patients.logic.service.domain.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService extends AbstractCrudService<Patient> implements IPatientService {

    @Autowired
    private IPatientRepository patientRepository;

    @Override
    @Transactional
    public Patient findByPhone(final String phoneNumber) {
        try {

            return patientRepository.findByPhone(phoneNumber);

        } catch (DatabaseException e) {
            throw e;
        }
    }

//    @Override
//    @Transactional
//    public Patient getExist(String phoneNumber) {
//        try {
//            Patient patient = findByPhone(phoneNumber);
//            if (patient == null) {
//                throw new NotFoundException(Constants.PATIENT + Constants.WITH_PHONE_NUMBER + phoneNumber + Constants.NOT_FOUND);
//            }
//            return patient;
//        } catch (DatabaseException e) {
//            throw e;
//        }
//    }
//
//    @Override
//    @Transactional
//    public Patient getNew(String phoneNumber, Integer stateId) {
//        try {
//            if (findByPhone(phoneNumber) != null) {
//                throw new IncorrectlyEnteredDataException(Constants.PATIENT + Constants.WITH_PHONE_NUMBER + phoneNumber + Constants.ALREADY_EXISTS);
//            }
//
//            Patient patient = new Patient(phoneNumber, stateRepository.find(stateId));
//
//            return patient;
//        } catch (DatabaseException e) {
//            throw e;
//        }
//    }

}
