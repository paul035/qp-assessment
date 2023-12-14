package com.questionpro.GroceryService.service;

import java.util.List;

import com.questionpro.GroceryService.data.BookGrocery;
import com.questionpro.GroceryService.data.Grocery;

public interface UserService {
	
	public List<Grocery> getAllGrocery();
	public List<BookGrocery> bookGrocery(List<BookGrocery> groceryToBook);

}
