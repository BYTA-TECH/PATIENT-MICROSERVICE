package com.bytatech.ayoos.client.patient_dms.model;

import java.util.Objects;
import com.bytatech.ayoos.client.patient_dms.model.AuditEntry;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AuditEntryEntry
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-10T09:58:46.053+05:30[Asia/Kolkata]")

public class AuditEntryEntry   {
  @JsonProperty("entry")
  private AuditEntry entry = null;

  public AuditEntryEntry entry(AuditEntry entry) {
    this.entry = entry;
    return this;
  }

  /**
   * Get entry
   * @return entry
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AuditEntry getEntry() {
    return entry;
  }

  public void setEntry(AuditEntry entry) {
    this.entry = entry;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuditEntryEntry auditEntryEntry = (AuditEntryEntry) o;
    return Objects.equals(this.entry, auditEntryEntry.entry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entry);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuditEntryEntry {\n");
    
    sb.append("    entry: ").append(toIndentedString(entry)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

