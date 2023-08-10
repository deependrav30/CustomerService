package com.stickyio.CustomerServiceApplication.controller;

import com.stickyio.CustomerServiceApplication.dao.Order;
import com.stickyio.CustomerServiceApplication.dto.OrderRequestDTO;
import com.stickyio.CustomerServiceApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/order")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/{orderId}")
    ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        Optional<Order> orderOptional=customerService.getOrderById(orderId);
        return orderOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{orderId}/tracking-details")
    String getOrderTrackingDetails(@PathVariable Long orderId) {
        return customerService.processOrderStatusReply(orderId);
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderRequestDTO orderRequest) {
        Long orderId=customerService.createOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Order created with orderId: "+orderId);
    }
}
