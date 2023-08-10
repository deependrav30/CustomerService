package com.stickyio.CustomerServiceApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackingService {
    @Autowired
    ExternalTrackingService externalTrackingService;
    public String processOrderStatusRequest(Long orderId)
    {
        return externalTrackingService.generateRandomStatus(orderId);
    }
}
