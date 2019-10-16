package com.bytatech.ayoos.service.mapper;

import com.bytatech.ayoos.domain.*;
import com.bytatech.ayoos.service.dto.MedicalCaseDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity MedicalCase and its DTO MedicalCaseDTO.
 */
@Mapper(componentModel = "spring", uses = {PatientMapper.class})
public interface MedicalCaseMapper extends EntityMapper<MedicalCaseDTO, MedicalCase> {

    @Mapping(source = "patient.id", target = "patientId")
    MedicalCaseDTO toDto(MedicalCase medicalCase);

    @Mapping(source = "patientId", target = "patient")
    @Mapping(target = "dmsRecords", ignore = true)
    MedicalCase toEntity(MedicalCaseDTO medicalCaseDTO);

    default MedicalCase fromId(Long id) {
        if (id == null) {
            return null;
        }
        MedicalCase medicalCase = new MedicalCase();
        medicalCase.setId(id);
        return medicalCase;
    }
}
