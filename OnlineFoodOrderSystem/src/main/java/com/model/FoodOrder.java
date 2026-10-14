package com.model;



//package com.example.foodorder.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class FoodOrder {

    private Long orderId;

    public FoodOrder(Long orderId, @NotBlank(message = "Customer name is required") String customerName,
			@NotBlank(message = "Food item cannot be empty") String foodItem,
			@Min(value = 1, message = "Quantity must be at least 1") int quantity,
			@Positive(message = "Price must be greater than zero") double price) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.foodItem = foodItem;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@NotBlank(message = "Customer name is required")
    private String customerName;

    @NotBlank(message = "Food item cannot be empty")
    private String foodItem;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    @Positive(message = "Price must be greater than zero")
    private double price;
    
}
