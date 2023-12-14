package com.questionpro.GroceryService.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity class for Grocery Items
 * 
 * Inventory: number of grocery items available
 * 
 * 
 * @author ankurpal1997@gmail.com
 */

@Entity
@Table(name = "tbl_grocery")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Grocery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "grocery_id")
	private int groceryId;
	@Column(name = "grocery_name")
	private String groceryName;
	@Column(name = "grocery_price")
	private double groceryPrice;
	@Column(name = "grocery_inventory")
	private int groceryInventory;

}
