package com.bytatech.ayoos.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DMSRecord.
 */
@Entity
@Table(name = "dms_record")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "dmsrecord")
public class DMSRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prescription_ref")
    private String prescriptionRef;

    @ManyToOne
    @JsonIgnoreProperties("dmsRecords")
    private MedicalCase medicalCase;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrescriptionRef() {
        return prescriptionRef;
    }

    public DMSRecord prescriptionRef(String prescriptionRef) {
        this.prescriptionRef = prescriptionRef;
        return this;
    }

    public void setPrescriptionRef(String prescriptionRef) {
        this.prescriptionRef = prescriptionRef;
    }

    public MedicalCase getMedicalCase() {
        return medicalCase;
    }

    public DMSRecord medicalCase(MedicalCase medicalCase) {
        this.medicalCase = medicalCase;
        return this;
    }

    public void setMedicalCase(MedicalCase medicalCase) {
        this.medicalCase = medicalCase;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DMSRecord dMSRecord = (DMSRecord) o;
        if (dMSRecord.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), dMSRecord.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DMSRecord{" +
            "id=" + getId() +
            ", prescriptionRef='" + getPrescriptionRef() + "'" +
            "}";
    }
}
