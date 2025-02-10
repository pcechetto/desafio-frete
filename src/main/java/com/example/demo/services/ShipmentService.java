package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Order;

@Service
public class ShipmentService {

    public Double shipment(Order order) {

        if (order.getBasic() < 100.00) {
            return 20.00;
        }

        if (order.getBasic() >= 100.00 && order.getBasic() < 200.00) {
            return 12.00;
        }

        if (order.getBasic() >= 200.00) {
            return 0.00;

        } else {
            throw new IllegalArgumentException("Invalid order");
        }

    }
}
