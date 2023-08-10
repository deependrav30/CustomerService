package com.stickyio.CustomerServiceApplication.service;

import com.stickyio.CustomerServiceApplication.Exception.OrderNotFoundException;
import com.stickyio.CustomerServiceApplication.dao.Order;
import com.stickyio.CustomerServiceApplication.dao.OrderStatus;
import com.stickyio.CustomerServiceApplication.dto.OrderRequestDTO;
import com.stickyio.CustomerServiceApplication.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    TrackingService trackingService;
    @Autowired
    OrderRepository orderRepository;
    public String processOrderStatusReply(Long orderId) {
        if(orderRepository.findById(orderId).isPresent()) {
            return trackingService.processOrderStatusRequest(orderId);
        }
        throw new OrderNotFoundException(orderId);
    }

    public Long createOrder(OrderRequestDTO orderRequest) {
        Order order=new Order();
        order.setCustomerId(orderRequest.getCustomerId());
        order.setStatus(OrderStatus.PENDING);
        orderRepository.save(order);
        order=orderRepository.findFirstByCustomerIdOrderByIdDesc(
                orderRequest.getCustomerId());
        return order.getId();
    }

    public Optional<Order> getOrderById(Long orderId)
    {
        return orderRepository.findById(orderId);
    }
}