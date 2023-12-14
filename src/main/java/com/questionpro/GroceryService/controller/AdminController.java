package com.questionpro.GroceryService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questionpro.GroceryService.data.Grocery;
import com.questionpro.GroceryService.service.GroceryServiceImpl;
import com.questionpro.GroceryService.utils.GenericRequest;
import com.questionpro.GroceryService.utils.GenericResponse;

@RestController
@RequestMapping("/api/admin/grocery")
public class AdminController {
	
	@Autowired
	private GroceryServiceImpl groceryServiceImpl;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Grocery Services!";
	}
	
	@PostMapping("/add")
	public ResponseEntity<GenericResponse<Grocery>> addGrocery(@RequestBody GenericRequest<Grocery> request){
		Grocery groceryAddedToDb = this.groceryServiceImpl.addGrocery(request.getT());
		return new ResponseEntity<GenericResponse<Grocery>>(new GenericResponse<Grocery>(groceryAddedToDb, "Grocery Added", "OK"), HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<GenericResponse<List<Grocery>>> getAllGrocery(){
		List<Grocery> groceries = this.groceryServiceImpl.getAllGrocery();
		return new ResponseEntity<GenericResponse<List<Grocery>>>(new GenericResponse<List<Grocery>>(groceries, "Grocery List", "OK"), HttpStatus.OK);
	}
	
	@GetMapping("/get/{groceryId}")
	public ResponseEntity<GenericResponse<Grocery>> getGrocery(@PathVariable("groceryId") int groceryId){
		Grocery grocery = this.groceryServiceImpl.getGrocery(groceryId);
		return new ResponseEntity<GenericResponse<Grocery>>(new GenericResponse<Grocery>(grocery, "Grocery Found", "OK"), HttpStatus.OK);
	}
	
	@PutMapping("/update/{groceryId}")
	public ResponseEntity<GenericResponse<Grocery>> updateGrocery(@PathVariable("groceryId") int groceryId, @RequestBody GenericRequest<Grocery> request){
		Grocery updatedGrocery = this.groceryServiceImpl.updateGrocery(groceryId, request.getT());
		return new ResponseEntity<GenericResponse<Grocery>>(new GenericResponse<Grocery>(updatedGrocery, "Grocery Updated", "OK"), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{groceryId}")
	public ResponseEntity<GenericResponse<String>> deleteGrocery(@PathVariable("groceryId") int groceryId){
		this.groceryServiceImpl.deleteGrocery(groceryId);
		return new ResponseEntity<GenericResponse<String>>(new GenericResponse<String>("Grocery Deleted with groceryId " + groceryId, "Grocery Deleted", "OK"), HttpStatus.OK);
	}	

}
