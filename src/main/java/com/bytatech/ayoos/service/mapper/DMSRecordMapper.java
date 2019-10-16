package com.bytatech.ayoos.service.mapper;

import com.bytatech.ayoos.domain.*;
import com.bytatech.ayoos.service.dto.DMSRecordDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity DMSRecord and its DTO DMSRecordDTO.
 */
@Mapper(componentModel = "spring", uses = {MedicalCaseMapper.class})
public interface DMSRecordMapper extends EntityMapper<DMSRecordDTO, DMSRecord> {

    @Mapping(source = "medicalCase.id", target = "medicalCaseId")
    DMSRecordDTO toDto(DMSRecord dMSRecord);

    @Mapping(source = "medicalCaseId", target = "medicalCase")
    DMSRecord toEntity(DMSRecordDTO dMSRecordDTO);

    default DMSRecord fromId(Long id) {
        if (id == null) {
            return null;
        }
        DMSRecord dMSRecord = new DMSRecord();
        dMSRecord.setId(id);
        return dMSRecord;
    }
}
