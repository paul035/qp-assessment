package com.questionpro.GroceryService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questionpro.GroceryService.data.BookGrocery;
import com.questionpro.GroceryService.data.Grocery;
import com.questionpro.GroceryService.service.UserServiceImpl;
import com.questionpro.GroceryService.utils.GenericRequest;
import com.questionpro.GroceryService.utils.GenericResponse;

@RestController
@RequestMapping("/api/user/grocery")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/getAll")
	public ResponseEntity<GenericResponse<List<Grocery>>> getAllGrocery(){
		List<Grocery> groceries = this.userServiceImpl.getAllGrocery();
		return new ResponseEntity<GenericResponse<List<Grocery>>>(new GenericResponse<List<Grocery>>(groceries, "Grocery List", "OK"), HttpStatus.OK);
	}
	
	@PostMapping("/bookGrocery")
	public ResponseEntity<GenericResponse<List<BookGrocery>>> bookGrocery(@RequestBody GenericRequest<List<BookGrocery>> request){
		List<BookGrocery> groceries = request.getT();
		List<BookGrocery> bookedGrocery = this.userServiceImpl.bookGrocery(groceries);
		return new ResponseEntity<GenericResponse<List<BookGrocery>>>(new GenericResponse<List<BookGrocery>>(bookedGrocery, "Grocery Booked", "OK"), HttpStatus.OK);	
	}
}
