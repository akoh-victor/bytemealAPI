package com.byteworks.bytemealAPI.Repository;

import java.util.List;

import com.byteworks.bytemealAPI.Entity.FoodMenu;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface FoodMenuRepository extends PagingAndSortingRepository<FoodMenu, Long> {

  List<FoodMenu> findByTitle(String title);

}


