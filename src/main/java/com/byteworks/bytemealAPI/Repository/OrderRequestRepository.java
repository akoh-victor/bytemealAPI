package com.byteworks.bytemealAPI.Repository;

import java.util.List;

import com.byteworks.bytemealAPI.Entity.OrderRequest;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;



public interface OrderRequestRepository extends PagingAndSortingRepository<OrderRequest, Long> {


    @Query("select u from OrderRequest u where u.vendor = :vendorId")
    List<OrderRequest>  findByVendor(@Param("vendorId") Long vendorId);
   
    @Query("select u from OrderRequest u where u.vendor = :vendorId and u.pending = :value")
    List<OrderRequest>  findVendorPendingRequests(@Param("vendorId") Long vendorId, @Param("value") Boolean value );

    @Query("select u from OrderRequest u where u.vendor = :vendorId and u.completed = :value")
    List<OrderRequest>  findVendorCompletedRequests(@Param("vendorId") Long vendorId, @Param("value") Boolean value );
   
    @Query("select u from OrderRequest u where u.vendor = :vendorId and u.paymentOption = :paymentId")
    List<OrderRequest>  findVendorOrderRequestsByPaymentOption(@Param("vendorId") Long vendorId, @Param("paymentId") Long paymentId );
  
    @Query("select u from OrderRequest u where u.vendor = :vendorId and u.deliveryOption = :deliveryOptionId")
    List<OrderRequest>  findVendorOrderRequestsByDeliveryOption(@Param("vendorId") Long vendorId, @Param("deliveryOptionId") Long deliveryOptionId );

  
}


