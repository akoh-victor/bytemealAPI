package com.byteworks.bytemealAPI.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PaymentOption {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String title;
  private String name;
  PaymentOption() {}

  public PaymentOption(String title, String name) {
    this.title = title;
    this.name = name;
  }


  @OneToMany(mappedBy = "paymentOption")
 private List<OrderRequest> orderRequests;

  public String getTitle() {
    return title;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}