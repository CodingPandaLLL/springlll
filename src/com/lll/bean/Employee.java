package com.lll.bean;

import java.io.Serializable;

public class Employee implements Serializable {

  private int id;
  
  private String lastName;
  
  private String email;
  
  private String gender;
  
  private String dId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getDId() {
    return dId;
  }

  public void setDId(String dId) {
    this.dId = dId;
  }
  
  
}
