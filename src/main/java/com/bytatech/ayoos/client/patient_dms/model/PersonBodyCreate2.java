package com.bytatech.ayoos.client.patient_dms.model;

import java.util.Objects;
import com.bytatech.ayoos.client.patient_dms.model.Company;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PersonBodyCreate
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-10T09:58:46.053+05:30[Asia/Kolkata]")

public class PersonBodyCreate2   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("skypeId")
  private String skypeId = null;

  @JsonProperty("googleId")
  private String googleId = null;

  @JsonProperty("instantMessageId")
  private String instantMessageId = null;

  @JsonProperty("jobTitle")
  private String jobTitle = null;

  @JsonProperty("location")
  private String location = null;

  @JsonProperty("company")
  private Company company = null;

  @JsonProperty("mobile")
  private String mobile = null;

  @JsonProperty("telephone")
  private String telephone = null;

  @JsonProperty("userStatus")
  private String userStatus = null;

  @JsonProperty("enabled")
  private Boolean enabled = true;

  @JsonProperty("emailNotificationsEnabled")
  private Boolean emailNotificationsEnabled = true;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("aspectNames")
  @Valid
  private List<String> aspectNames = null;

  @JsonProperty("properties")
  @Valid
  private Map<String, Object> properties = null;

  public PersonBodyCreate2 id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PersonBodyCreate2 firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public PersonBodyCreate2 lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  **/
  @ApiModelProperty(value = "")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public PersonBodyCreate2 description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PersonBodyCreate2 email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public PersonBodyCreate2 skypeId(String skypeId) {
    this.skypeId = skypeId;
    return this;
  }

  /**
   * Get skypeId
   * @return skypeId
  **/
  @ApiModelProperty(value = "")


  public String getSkypeId() {
    return skypeId;
  }

  public void setSkypeId(String skypeId) {
    this.skypeId = skypeId;
  }

  public PersonBodyCreate2 googleId(String googleId) {
    this.googleId = googleId;
    return this;
  }

  /**
   * Get googleId
   * @return googleId
  **/
  @ApiModelProperty(value = "")


  public String getGoogleId() {
    return googleId;
  }

  public void setGoogleId(String googleId) {
    this.googleId = googleId;
  }

  public PersonBodyCreate2 instantMessageId(String instantMessageId) {
    this.instantMessageId = instantMessageId;
    return this;
  }

  /**
   * Get instantMessageId
   * @return instantMessageId
  **/
  @ApiModelProperty(value = "")


  public String getInstantMessageId() {
    return instantMessageId;
  }

  public void setInstantMessageId(String instantMessageId) {
    this.instantMessageId = instantMessageId;
  }

  public PersonBodyCreate2 jobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
    return this;
  }

  /**
   * Get jobTitle
   * @return jobTitle
  **/
  @ApiModelProperty(value = "")


  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public PersonBodyCreate2 location(String location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(value = "")


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public PersonBodyCreate2 company(Company company) {
    this.company = company;
    return this;
  }

  /**
   * Get company
   * @return company
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public PersonBodyCreate2 mobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  /**
   * Get mobile
   * @return mobile
  **/
  @ApiModelProperty(value = "")


  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public PersonBodyCreate2 telephone(String telephone) {
    this.telephone = telephone;
    return this;
  }

  /**
   * Get telephone
   * @return telephone
  **/
  @ApiModelProperty(value = "")


  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public PersonBodyCreate2 userStatus(String userStatus) {
    this.userStatus = userStatus;
    return this;
  }

  /**
   * Get userStatus
   * @return userStatus
  **/
  @ApiModelProperty(value = "")


  public String getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(String userStatus) {
    this.userStatus = userStatus;
  }

  public PersonBodyCreate2 enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  /**
   * Get enabled
   * @return enabled
  **/
  @ApiModelProperty(value = "")


  public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public PersonBodyCreate2 emailNotificationsEnabled(Boolean emailNotificationsEnabled) {
    this.emailNotificationsEnabled = emailNotificationsEnabled;
    return this;
  }

  /**
   * Get emailNotificationsEnabled
   * @return emailNotificationsEnabled
  **/
  @ApiModelProperty(value = "")


  public Boolean isEmailNotificationsEnabled() {
    return emailNotificationsEnabled;
  }

  public void setEmailNotificationsEnabled(Boolean emailNotificationsEnabled) {
    this.emailNotificationsEnabled = emailNotificationsEnabled;
  }

  public PersonBodyCreate2 password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public PersonBodyCreate2 aspectNames(List<String> aspectNames) {
    this.aspectNames = aspectNames;
    return this;
  }

  public PersonBodyCreate2 addAspectNamesItem(String aspectNamesItem) {
    if (this.aspectNames == null) {
      this.aspectNames = new ArrayList<String>();
    }
    this.aspectNames.add(aspectNamesItem);
    return this;
  }

  /**
   * Get aspectNames
   * @return aspectNames
  **/
  @ApiModelProperty(value = "")


  public List<String> getAspectNames() {
    return aspectNames;
  }

  public void setAspectNames(List<String> aspectNames) {
    this.aspectNames = aspectNames;
  }

  public PersonBodyCreate2 properties(Map<String, Object> properties) {
    this.properties = properties;
    return this;
  }

  public PersonBodyCreate2 putPropertiesItem(String key, Object propertiesItem) {
    if (this.properties == null) {
      this.properties = new HashMap<String, Object>();
    }
    this.properties.put(key, propertiesItem);
    return this;
  }

  /**
   * Get properties
   * @return properties
  **/
  @ApiModelProperty(value = "")


  public Map<String, Object> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, Object> properties) {
    this.properties = properties;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonBodyCreate2 personBodyCreate = (PersonBodyCreate2) o;
    return Objects.equals(this.id, personBodyCreate.id) &&
        Objects.equals(this.firstName, personBodyCreate.firstName) &&
        Objects.equals(this.lastName, personBodyCreate.lastName) &&
        Objects.equals(this.description, personBodyCreate.description) &&
        Objects.equals(this.email, personBodyCreate.email) &&
        Objects.equals(this.skypeId, personBodyCreate.skypeId) &&
        Objects.equals(this.googleId, personBodyCreate.googleId) &&
        Objects.equals(this.instantMessageId, personBodyCreate.instantMessageId) &&
        Objects.equals(this.jobTitle, personBodyCreate.jobTitle) &&
        Objects.equals(this.location, personBodyCreate.location) &&
        Objects.equals(this.company, personBodyCreate.company) &&
        Objects.equals(this.mobile, personBodyCreate.mobile) &&
        Objects.equals(this.telephone, personBodyCreate.telephone) &&
        Objects.equals(this.userStatus, personBodyCreate.userStatus) &&
        Objects.equals(this.enabled, personBodyCreate.enabled) &&
        Objects.equals(this.emailNotificationsEnabled, personBodyCreate.emailNotificationsEnabled) &&
        Objects.equals(this.password, personBodyCreate.password) &&
        Objects.equals(this.aspectNames, personBodyCreate.aspectNames) &&
        Objects.equals(this.properties, personBodyCreate.properties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, description, email, skypeId, googleId, instantMessageId, jobTitle, location, company, mobile, telephone, userStatus, enabled, emailNotificationsEnabled, password, aspectNames, properties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonBodyCreate {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    skypeId: ").append(toIndentedString(skypeId)).append("\n");
    sb.append("    googleId: ").append(toIndentedString(googleId)).append("\n");
    sb.append("    instantMessageId: ").append(toIndentedString(instantMessageId)).append("\n");
    sb.append("    jobTitle: ").append(toIndentedString(jobTitle)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
    sb.append("    telephone: ").append(toIndentedString(telephone)).append("\n");
    sb.append("    userStatus: ").append(toIndentedString(userStatus)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    emailNotificationsEnabled: ").append(toIndentedString(emailNotificationsEnabled)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    aspectNames: ").append(toIndentedString(aspectNames)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
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

