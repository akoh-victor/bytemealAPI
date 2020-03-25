package com.byteworks.bytemealAPI.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Developer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "username", nullable = false, unique = true)
  private String username;
  @Column(name = "password", nullable = false)
  private String password;
  private String firstName;
  private String lastName;

 


   @OneToMany(mappedBy = "buyer")
   private List<OrderRequest> orderRequests;

  @OneToOne
  @JoinColumn(name = "location_id")
  private Location location;

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public Location getLocation() {
    return location;
  }
  public void setLocation(Location location) {
    this.location = location;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

 


}