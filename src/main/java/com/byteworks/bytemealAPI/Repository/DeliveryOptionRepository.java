package com.byteworks.bytemealAPI.Repository;

import java.util.List;

import com.byteworks.bytemealAPI.Entity.DeliveryOption;


import org.springframework.data.repository.PagingAndSortingRepository;

//import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface DeliveryOptionRepository extends PagingAndSortingRepository<DeliveryOption, Long> {

  List<DeliveryOption> findByTitle(String title);

}


