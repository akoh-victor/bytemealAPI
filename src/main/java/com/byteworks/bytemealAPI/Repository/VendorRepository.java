package com.byteworks.bytemealAPI.Repository;



import com.byteworks.bytemealAPI.Entity.Vendor;

import org.springframework.data.repository.PagingAndSortingRepository;



public interface VendorRepository extends PagingAndSortingRepository<Vendor, Long> {
    
   Vendor findByPhone(String phone);
 
}


