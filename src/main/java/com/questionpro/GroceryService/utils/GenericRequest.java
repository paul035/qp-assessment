package com.questionpro.GroceryService.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericRequest<T> {
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	private T t;
}
