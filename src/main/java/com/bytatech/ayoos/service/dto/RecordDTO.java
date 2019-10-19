package com.bytatech.ayoos.service.dto;

public class RecordDTO {
	private byte[] file;
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public String getIdpCode() {
		return idpCode;
	}
	public void setIdpCode(String idpCode) {
		this.idpCode = idpCode;
	}
	public Long getMedicalCaseId() {
		return medicalCaseId;
	}
	public void setMedicalCaseId(Long medicalCaseId) {
		this.medicalCaseId = medicalCaseId;
	}
	private String idpCode;
	private Long medicalCaseId;

}
