package by.itsm.patients.web.service.converter.impl;

import by.itsm.patients.web.repository.StateRepository;
import by.itsm.patients.web.service.converter.Converter;
import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.common.entity.State;
import by.itsm.patients.web.model.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientConverter implements Converter<Patient, PatientDto> {

    private final StateRepository stateRepository;

    @Autowired
    public PatientConverter(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public PatientDto convert(Patient entity) {
        PatientDto dto = new PatientDto();

        dto.setId(entity.getId());
        dto.setPhone(entity.getPhone());
        dto.setStateId(entity.getState().getId());

        return dto;
    }

    @Override
    public Patient convert(PatientDto dto) {
        State state = stateRepository.findById(dto.getStateId())
                .orElseThrow(() -> new IllegalArgumentException("Can't find state with id = " + dto.getStateId()));

        Patient patient = new Patient();

        patient.setId(dto.getId());
        patient.setPhone(dto.getPhone());
        patient.setState(state);

        return patient;
    }
}
