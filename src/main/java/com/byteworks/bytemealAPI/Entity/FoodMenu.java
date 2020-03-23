package com.byteworks.bytemealAPI.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class FoodMenu {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String title;
  private Integer price;


  @ManyToOne
  @JoinColumn(name="vendor_id")
  private Vendor vendor;


  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "order_menu", 
  joinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "id"), 
  inverseJoinColumns = @JoinColumn(name = "order_id", 
  referencedColumnName = "id" ))
  private List<OrderRequest> orderRequests;




  
  public Vendor getSeller() {
    return vendor;
  }
  public void setSeller(Vendor vendor) {
    this.vendor = vendor;
  }

  public String getTitle() {
    return title;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  


  

 
}