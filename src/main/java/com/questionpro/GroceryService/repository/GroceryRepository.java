package com.questionpro.GroceryService.repository;

import org.springframework.stereotype.Repository;

import com.questionpro.GroceryService.data.Grocery;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Integer> {

}
