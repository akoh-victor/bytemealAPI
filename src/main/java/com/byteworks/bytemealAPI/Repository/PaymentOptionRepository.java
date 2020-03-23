package com.byteworks.bytemealAPI.Repository;

import java.util.List;


import com.byteworks.bytemealAPI.Entity.PaymentOption;

import org.springframework.data.repository.PagingAndSortingRepository;




public interface PaymentOptionRepository extends PagingAndSortingRepository<PaymentOption, Long> {

  List<PaymentOption> findByTitle(String title);

}


