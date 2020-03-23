package com.byteworks.bytemealAPI.Entity;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;


public class Login {


  private String userName;
  private String password;

  protected Login() {}

  public Login(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }



  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }
}