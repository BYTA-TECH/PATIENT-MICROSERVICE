package com.bytatech.ayoos.client.patient_dms.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ContentInfo
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-10T09:58:46.053+05:30[Asia/Kolkata]")

public class ContentInfo   {
  @JsonProperty("mimeType")
  private String mimeType = null;

  @JsonProperty("mimeTypeName")
  private String mimeTypeName = null;

  @JsonProperty("sizeInBytes")
  private Long sizeInBytes = null;

  @JsonProperty("encoding")
  private String encoding = null;

  public ContentInfo mimeType(String mimeType) {
    this.mimeType = mimeType;
    return this;
  }

  /**
   * Get mimeType
   * @return mimeType
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  public ContentInfo mimeTypeName(String mimeTypeName) {
    this.mimeTypeName = mimeTypeName;
    return this;
  }

  /**
   * Get mimeTypeName
   * @return mimeTypeName
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getMimeTypeName() {
    return mimeTypeName;
  }

  public void setMimeTypeName(String mimeTypeName) {
    this.mimeTypeName = mimeTypeName;
  }

  public ContentInfo sizeInBytes(Long sizeInBytes) {
    this.sizeInBytes = sizeInBytes;
    return this;
  }

  /**
   * Get sizeInBytes
   * @return sizeInBytes
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getSizeInBytes() {
    return sizeInBytes;
  }

  public void setSizeInBytes(Long sizeInBytes) {
    this.sizeInBytes = sizeInBytes;
  }

  public ContentInfo encoding(String encoding) {
    this.encoding = encoding;
    return this;
  }

  /**
   * Get encoding
   * @return encoding
  **/
  @ApiModelProperty(value = "")


  public String getEncoding() {
    return encoding;
  }

  public void setEncoding(String encoding) {
    this.encoding = encoding;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentInfo contentInfo = (ContentInfo) o;
    return Objects.equals(this.mimeType, contentInfo.mimeType) &&
        Objects.equals(this.mimeTypeName, contentInfo.mimeTypeName) &&
        Objects.equals(this.sizeInBytes, contentInfo.sizeInBytes) &&
        Objects.equals(this.encoding, contentInfo.encoding);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mimeType, mimeTypeName, sizeInBytes, encoding);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentInfo {\n");
    
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
    sb.append("    mimeTypeName: ").append(toIndentedString(mimeTypeName)).append("\n");
    sb.append("    sizeInBytes: ").append(toIndentedString(sizeInBytes)).append("\n");
    sb.append("    encoding: ").append(toIndentedString(encoding)).append("\n");
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

