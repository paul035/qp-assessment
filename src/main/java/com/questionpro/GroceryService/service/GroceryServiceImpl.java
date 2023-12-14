package com.questionpro.GroceryService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionpro.GroceryService.data.Grocery;
import com.questionpro.GroceryService.exception.ResourceNotFoundException;
import com.questionpro.GroceryService.repository.GroceryRepository;

@Service
public class GroceryServiceImpl implements GroceryService {

	@Autowired
	private GroceryRepository groceryRepository;
	
	@Override
	public Grocery addGrocery(Grocery grocery) {
		return this.groceryRepository.save(grocery);
	}
	
	@Override
	public List<Grocery> getAllGrocery() {
		List<Grocery> groceries = this.groceryRepository.findAll();
		for(Grocery grocery : groceries) {
			if(grocery.getGroceryInventory() <= 0) {
				groceries.remove(grocery);
			}
		}
		return groceries;
	}

	@Override
	public Grocery getGrocery(int groceryId) {
		Grocery grocery = this.groceryRepository.findById(groceryId).orElseThrow(() -> new ResourceNotFoundException("Grocery", "GroceryId", groceryId));
		return grocery;
	}

	@Override
	public Grocery updateGrocery(int groceryId, Grocery grocery) {
		Grocery groceryDetail = this.groceryRepository.findById(groceryId).orElseThrow(() -> new ResourceNotFoundException("Grocery", "GroceryId", groceryId));
		groceryDetail.setGroceryName(grocery.getGroceryName());
		groceryDetail.setGroceryPrice(grocery.getGroceryPrice());
		groceryDetail.setGroceryInventory(grocery.getGroceryInventory());
		return this.groceryRepository.save(groceryDetail);
	}

	@Override
	public void deleteGrocery(int groceryId) {
		Grocery grocery = this.groceryRepository.findById(groceryId).orElseThrow(() -> new ResourceNotFoundException("Grocery", "GroceryId", groceryId));
		this.groceryRepository.delete(grocery);
	}

}
