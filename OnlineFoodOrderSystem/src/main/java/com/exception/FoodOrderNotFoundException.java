package com.exception;

//package com.example.foodorder.exception;

public class FoodOrderNotFoundException
        extends RuntimeException {

    public FoodOrderNotFoundException(String message) {
        super(message);
        
        throw new FoodOrderNotFoundException( "Order not found with ID: 99");
        	    
    }
    
    
}
