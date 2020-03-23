package com.byteworks.bytemealAPI.Controller;

import java.util.List;

import com.byteworks.bytemealAPI.Entity.DeliveryOption;
import com.byteworks.bytemealAPI.Entity.Developer;
import com.byteworks.bytemealAPI.Entity.FoodMenu;
import com.byteworks.bytemealAPI.Entity.Location;
import com.byteworks.bytemealAPI.Entity.OrderRequest;
import com.byteworks.bytemealAPI.Entity.PaymentOption;
import com.byteworks.bytemealAPI.Entity.Vendor;
import com.byteworks.bytemealAPI.Repository.OrderRequestRepository;


/* import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.SUM;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
*/
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
            }else{
                //null delivry option
            }

        }else{
            //null payment option
        }


      }else{
          //emty items 
         
      }

    return repository.save(newOrderRequest);


  }

/*

  @GetMapping("/employees")
  List<Employee> all() {
    return repository.findAll();
  }

  @PostMapping("/employees")
  Employee newEmployee(@RequestBody Employee newEmployee) {
    return repository.save(newEmployee);
  }

  // Single item

  @GetMapping("/employees/{id}")Employee one(@PathVariable Long id) {

    return repository.findById(id)
      .orElseThrow(() -> new EmployeeNotFoundException(id));
  }

  @PutMapping("/employees/{id}")
  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

    return repository.findById(id)
      .map(employee -> {
        employee.setName(newEmployee.getName());
        employee.setRole(newEmployee.getRole());
        return repository.save(employee);
      })
      .orElseGet(() -> {
        newEmployee.setId(id);
        return repository.save(newEmployee);
      });
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }

   */

}