package com.byteworks.bytemealAPI.Repository;

import java.util.List;
import com.byteworks.bytemealAPI.Entity.Developer;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface DeveloperRepository extends PagingAndSortingRepository<Developer, Long> {

  List<Developer> findByLastName(String lastName);

  Developer findByUsername(String username);

}


