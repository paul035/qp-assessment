package com.questionpro.GroceryService.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse<T> {
	private T t;
	private String message;
	private String response;
	
}
