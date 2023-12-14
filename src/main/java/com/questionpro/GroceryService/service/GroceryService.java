package com.questionpro.GroceryService.service;

import java.util.List;

import com.questionpro.GroceryService.data.Grocery;

public interface GroceryService {
	public Grocery addGrocery(Grocery grocery);
	public List<Grocery> getAllGrocery();
	public Grocery getGrocery(int groceryId);
	public Grocery updateGrocery(int groceryId, Grocery grocery);
	public void deleteGrocery(int groceryId);
	
}
