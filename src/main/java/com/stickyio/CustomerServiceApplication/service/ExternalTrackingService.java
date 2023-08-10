package com.stickyio.CustomerServiceApplication.service;

import org.springframework.stereotype.Service;

@Service
public class ExternalTrackingService {
    public String generateRandomStatus(Long orderNumber) {
        String[] places = {"New Delhi", "Pune", "Chennai", "Rudrapur"};
        String randomCity = places[(int) (Math.random() * places.length)];
        return "Packet arrived at " + randomCity + " hub for order " + orderNumber;
    }
}
