package com.training.web.service.converter.impl;

import com.training.Patient;
import com.training.State;
import com.training.web.model.PatientIDto;
import com.training.web.repository.StateRepository;
import com.training.web.service.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PatientConverter implements Converter<Patient, PatientIDto> {

    private final StateRepository stateRepository;

    public PatientConverter(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public PatientIDto convert(Patient entity) {
        PatientIDto dto = new PatientIDto();
        dto.setId(entity.getId());
        dto.setPhone(entity.getPhone());
        dto.setState_id(entity.getState_id().getId());
        return dto;
    }

    @Override
    public Patient convert(PatientIDto dto) {
        State state = stateRepository.findById(dto.getState_id())
                .orElseThrow(()->new IllegalArgumentException("Can't find state with id = " + dto.getState_id()));
        Patient patient = new Patient();
        patient.setId(dto.getId());
        patient.setPhone(dto.getPhone());
        patient.setState_id(state);
        return null;
    }
}
