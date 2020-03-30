package com.byteworks.bytemealAPI.Controller;

import java.util.List;

import com.byteworks.bytemealAPI.Entity.DeliveryOption;
import com.byteworks.bytemealAPI.Entity.Developer;
import com.byteworks.bytemealAPI.Entity.FoodMenu;
import com.byteworks.bytemealAPI.Entity.Location;
import com.byteworks.bytemealAPI.Entity.OrderRequest;
import com.byteworks.bytemealAPI.Entity.PaymentOption;
import com.byteworks.bytemealAPI.Entity.Vendor;
import com.byteworks.bytemealAPI.Exception.ResourceNotFoundException;
import com.byteworks.bytemealAPI.Repository.OrderRequestRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class VendorController {

  private final OrderRequestRepository repository;

  VendorController(OrderRequestRepository repository) {
    this.repository = repository;
  }


}