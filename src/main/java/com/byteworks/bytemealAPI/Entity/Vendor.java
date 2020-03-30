package com.byteworks.bytemealAPI.Entity;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Vendor {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;
  private String phone;


  Vendor() {}

  public Vendor(String name, String phone) {
    this.name = name;
    this.phone = phone;
  }

  @OneToOne
  @JoinColumn(name = "location_id")
  private Location location;

  @OneToMany(mappedBy = "vendor")
  private List<FoodMenu> menu;
  
  
  @OneToMany(mappedBy = "vendor")
  private List<OrderRequest> orderRequests;


  public Location getLocation() {
    return location;
  }
  public void setLocation(Location location) {
    this.location = location;
  }


  

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setName(String name) {
    this.name = name;
  }
  

 
}