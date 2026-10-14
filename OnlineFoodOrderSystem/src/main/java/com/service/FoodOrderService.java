package com.service;

//package com.example.foodorder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.model.FoodOrder;
import com.exception.FoodOrderNotFoundException;

@Service
public class FoodOrderService {

    private final List<FoodOrder> orders = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    // Create an order
    public FoodOrder createOrder(FoodOrder order) {
        order.setOrderId(idGenerator.getAndIncrement());
        orders.add(order);
        return order;
    }

    // Get all orders
    public List<FoodOrder> getAllOrders() {
        return new ArrayList<>(orders);
    }

    // Get order by ID
    public FoodOrder getOrderById(Long id) {
        return orders.stream()
                .filter(order -> order.getOrderId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                    new FoodOrderNotFoundException(
                        "Order not found with ID: " + id
                    )
                );
    }

    // Search orders by customer name using Streams
    public List<FoodOrder> getOrdersByCustomer(String name) {
        return orders.stream()
                .filter(order -> order.getCustomerName()
                        .equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // Delete an order
    public void deleteOrder(Long id) {
        FoodOrder order = getOrderById(id);
        orders.remove(order);
    }
}
