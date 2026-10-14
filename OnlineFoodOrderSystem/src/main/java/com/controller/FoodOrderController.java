package com.controller;

//package com.example.foodorder.controller;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.model.FoodOrder;
import com.service.FoodOrderService;

@RestController
@RequestMapping("/api/orders")
@Validated
public class FoodOrderController {

    private final FoodOrderService foodOrderService;

    public FoodOrderController(FoodOrderService foodOrderService) {
        this.foodOrderService = foodOrderService;
    }

    // Create order
    @PostMapping
    public ResponseEntity<FoodOrder> createOrder( @Valid @RequestBody FoodOrder order) {

        FoodOrder savedOrder =  foodOrderService.createOrder(order);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedOrder);
    }

    // Get all orders
    @GetMapping
    public ResponseEntity<List<FoodOrder>> getAllOrders() {
        return ResponseEntity.ok(foodOrderService.getAllOrders());
                
    }

    // Get order by ID
    @GetMapping("/{id}")
    public ResponseEntity<FoodOrder> getOrderById(
            @PathVariable
            @Positive(message = "Order ID must be positive")
            Long id) {

        return ResponseEntity.ok( foodOrderService.getOrderById(id));
               
    }

    // Search by customer name
    @GetMapping("/customer/{name}")
    public ResponseEntity<List<FoodOrder>> getOrdersByCustomer(
            @PathVariable String name) {

        return ResponseEntity.ok( foodOrderService.getOrdersByCustomer(name));
                
    }

    // Delete order
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(
            @PathVariable
            @Positive(message = "Order ID must be positive")
            Long id) {

        foodOrderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
