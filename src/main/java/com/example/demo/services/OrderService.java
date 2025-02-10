package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Order;

@Service
public class OrderService {

    @Autowired
    private ShipmentService shipment;

    public Double total(Order order) {
        return order.getBasic() - order.getBasic() * order.getDiscount() * 0.01 + shipment.shipment(order);
    }
}
