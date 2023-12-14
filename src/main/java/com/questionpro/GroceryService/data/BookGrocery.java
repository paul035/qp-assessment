package com.questionpro.GroceryService.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookGrocery {
	
	private int groceryId;
	private String groceryName;
	private int required;
	private String message;

}
