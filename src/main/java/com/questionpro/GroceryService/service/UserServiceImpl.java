package com.questionpro.GroceryService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionpro.GroceryService.data.BookGrocery;
import com.questionpro.GroceryService.data.Grocery;
import com.questionpro.GroceryService.repository.GroceryRepository;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private GroceryRepository groceryRepository;

	@Override
	public List<Grocery> getAllGrocery() {
		return this.groceryRepository.findAll();
	}

	@Override
	public List<BookGrocery> bookGrocery(List<BookGrocery> grocerylist) {
		List<BookGrocery> groceries = new ArrayList<BookGrocery>();
		for (BookGrocery grocery : grocerylist) {
			Grocery groceryDb = this.groceryRepository.findById(grocery.getGroceryId()).orElse(null);
			if (null != groceryDb) {
				int inventory = groceryDb.getGroceryInventory() - grocery.getRequired();
				if (inventory >= 0) {
					if (grocery.getRequired() <= 0) {
						grocery.setMessage("Please select appropriate required number of Grocery Item");
						groceries.add(grocery);
					} else {
						grocery.setMessage("Grocery Item added to the Cart");
						groceries.add(grocery);
						groceryDb.setGroceryInventory(inventory);
						this.groceryRepository.save(groceryDb);
					}
				} else {
					grocery.setMessage("Sorry, the Grocery Item is Not Available");
					groceries.add(grocery);
				}
			} else {
				grocery.setMessage("No such Grocery Item is Available");
				groceries.add(grocery);
			}
		}
		return groceries;
	}

}
