package com.byteworks.bytemealAPI;

import lombok.extern.slf4j.Slf4j;


import com.byteworks.bytemealAPI.Entity.DeliveryOption;
import com.byteworks.bytemealAPI.Entity.FoodMenu;
import com.byteworks.bytemealAPI.Entity.Location;
import com.byteworks.bytemealAPI.Entity.PaymentOption;
import com.byteworks.bytemealAPI.Entity.Vendor;

import com.byteworks.bytemealAPI.Repository.DeliveryOptionRepository;
import com.byteworks.bytemealAPI.Repository.FoodMenuRepository;
import com.byteworks.bytemealAPI.Repository.LocationRepository;
import com.byteworks.bytemealAPI.Repository.PaymentOptionRepository;
import com.byteworks.bytemealAPI.Repository.VendorRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(FoodMenuRepository foodMenuRepo,VendorRepository vendorRepo,LocationRepository locationRepo,PaymentOptionRepository paymentOptionRepo,DeliveryOptionRepository deliveryOptionRepo ) {
    return args -> {
       //create records
       
          foodMenuRepo.save(new FoodMenu("Fried Rice and stew", 500));
          foodMenuRepo.save(new FoodMenu("Fried Rice  stew and plantain", 600));
          vendorRepo.save(new Vendor("Tastee MAMA","08081477456"));
          locationRepo.save(new Location("lekki, Lagos",6.4535213,3.2812111));
          locationRepo.save(new Location("victoria Island, Lagos",6.3535555,3.2912111));
          paymentOptionRepo.save(new PaymentOption("Card payment","card_payment"));
          paymentOptionRepo.save(new PaymentOption("Pay on delivery","pay_on_delivery"));
          deliveryOptionRepo.save(new DeliveryOption("Office  delivery","office_delivery"));
         deliveryOptionRepo.save(new DeliveryOption("Self pickup","self_pickup"));

    

  
    };
  }
}
 