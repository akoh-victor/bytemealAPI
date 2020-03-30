package com.byteworks.bytemealAPI.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class OrderRequest {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String title;
  private double totalPrice;
  private Date created;
  private boolean pending;
  private boolean completed;

  OrderRequest() {
  }

  public boolean isPending() {
    return pending;
  }

  public void setPending(boolean pending) {
    this.pending = pending;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  OrderRequest(String title, Double totalPrice) {
    this.title = title;
    this.totalPrice = totalPrice;
    this.created = new Date();
    this.pending = true;
    this.completed = false;
  }



  @ManyToMany(mappedBy = "orderRequests")
  private List<FoodMenu> foodItems;

  @ManyToOne
  @JoinColumn(name = "buyer_id")
  private Developer buyer;
  @ManyToOne
  @JoinColumn(name = "payment_id")
  private PaymentOption paymentOption;
  @ManyToOne
  @JoinColumn(name = "delivery_id")
  private DeliveryOption deliveryOption;

  @ManyToOne
  @JoinColumn(name = "vendor_id")
  private Vendor vendor;



  public Vendor getVendor() {
    return vendor;
  }
  public void setVendor(Vendor vendor) {
    this.vendor = vendor;
  }

  public Developer getBuyer() {
    return buyer;
  }
  public void setBuyer(Developer buyer) {
    this.buyer = buyer;
  }

  public DeliveryOption getDeliveryOption() {
    return deliveryOption;
  }
  public void setDeliveryOption(DeliveryOption deliveryOption) {
    this.deliveryOption = deliveryOption;
  }

  public PaymentOption getPaymentOption() {
    return paymentOption;
  }
  public void setFoodItems(PaymentOption paymentOption) {
    this.paymentOption = paymentOption;
  }

  public List<FoodMenu> getFoodItems() {
    return foodItems;
  }
  public void setFoodItems( List<FoodMenu> foodItems) {
    this.foodItems = foodItems;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
 

  
}