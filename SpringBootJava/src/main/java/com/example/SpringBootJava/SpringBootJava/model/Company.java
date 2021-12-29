
package com.example.SpringBootJava.SpringBootJava.model;


public class Company {
    private long id;
    private String companyName;
    private String basedOn;
    
    public Company() {

  }
    
    public Company(String companyName, String basedOn) {
    this.companyName = companyName;
    this.basedOn = basedOn;
    
  }
    public void setId(long id) {
    this.id = id;
  }
  
  public long getId() {
    return id;
  }
  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }
  
  public void setBasedOn(String basedOn) {
    this.basedOn = basedOn;
  }
  public String getBasedOn() {
    return basedOn;
  }
  
  @Override
  public String toString() {
    return "Tutorial [id=" + id + ", company_name=" + companyName + ", based_on=" + basedOn + "]";
  }
  
}
