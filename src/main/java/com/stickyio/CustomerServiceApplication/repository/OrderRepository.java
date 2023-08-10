package com.stickyio.CustomerServiceApplication.repository;

import com.stickyio.CustomerServiceApplication.dao.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findFirstByCustomerIdOrderByIdDesc(String customerId);
}
