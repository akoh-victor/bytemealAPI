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
import org.springframework.web.bind.annotation.RestController;

@RestController

class OrderController {

  private final OrderRequestRepository repository;

  OrderController(OrderRequestRepository repository) {
    this.repository = repository;
  }

  // Aggregate root

 

  @PostMapping("/order/create")
  OrderRequest newOrderRequest(@RequestBody OrderRequest newOrderRequest) {
      //validate the received data
      List<FoodMenu> items = newOrderRequest.getFoodItems();
      PaymentOption paymentOption = newOrderRequest.getPaymentOption();
      DeliveryOption deliveryOption = newOrderRequest.getDeliveryOption();
      Developer  buyer = newOrderRequest.getBuyer();

  try {
      if(!items.isEmpty()){

        if(paymentOption != null){
            if(deliveryOption != null){
                double foodPrice =0;
                Vendor seller = null;
              for (FoodMenu foodMenu : items) {
                 foodPrice += foodMenu.getPrice();
                 if(seller == null){ seller= foodMenu.getSeller(); }
                }             
              if(deliveryOption.getName() == "office_delivery"){
                 // office delivery will charge N10/meter for logistics if the developer requests for 
     
                 Location buyerLocation = buyer.getLocation();
             
                 double distance = seller.getLocation().distanceTo(buyerLocation);
                  //charges is 10 per meter so multiply the value of 
                  double distanceCost = distance *10;
                  //add distanceCost to current food price
                  foodPrice += distanceCost;
                 
            }
              if(paymentOption.getName() == "card_payment"){
             
               //if its card payment deduct 0.025 from cost  discount 2.5% total cost if the developer is paying with a card.
               double bonus = foodPrice * 0.025;
     
              //subtract bonus from food price
               foodPrice -= bonus;
     
            }
     
          
             newOrderRequest.setTotalPrice(foodPrice);
             newOrderRequest.setTitle(foodPrice +" order for "+ seller.getName());
     
             repository.save(newOrderRequest);
             
             // return foodPrice;
            }else{
                //null delivry option
                throw new ResourceNotFoundException("could not find the delivery Options  ");
            }

        }else{
            //null payment option
            throw new ResourceNotFoundException("could not find the payment Options  ");
        }

      }else{
 
          throw new ResourceNotFoundException("could not find vendor with phone 08081477456 ");
      }

   } catch (Exception e) {
     
      e.printStackTrace();
     }
     return newOrderRequest;


  }


  //get venodor pending order request
  @GetMapping("order/vendor/pending/{vendor_id}")
  List<OrderRequest> vendorsPendingOrderRequest(@PathVariable Long vendor_id) {
    return repository.findVendorPendingRequests(vendor_id,true);
  }
  //get venodor completed order
  @GetMapping("order/vendor/completed/{vendor_id}")
  List<OrderRequest> vendorsCpmpletedOrderRequest(@PathVariable Long vendor_id) {
    return repository.findVendorCompletedRequests(vendor_id,true);
  }
  //get list venodor order by payment option
  @GetMapping("order/vendor/paymentOption/{vendor_id}/{payment_id}")
  List<OrderRequest> vendorOrderRequestsByPaymentOption(@PathVariable Long vendor_id, Long payment_id) {
    return repository.findVendorOrderRequestsByPaymentOption(vendor_id,payment_id);
  }
    //get list venodor order by delivery option
  @GetMapping("order/vendor/deliveryOption/{vendor_id}/{delivery_id}")
  List<OrderRequest> vendorOrderRequestsByDeliveryOption(@PathVariable Long vendor_id,Long delivery_id) {
    return repository.findVendorOrderRequestsByDeliveryOption(vendor_id,delivery_id);
  }
}