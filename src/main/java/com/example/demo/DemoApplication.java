package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Order;
import com.example.demo.services.OrderService;
import com.example.demo.services.ShipmentService;

@SpringBootApplication
public class DemoApplication implements org.springframework.boot.CommandLineRunner {

	@Autowired
	private ShipmentService shipmentService;

	@Autowired
	private OrderService orderService;

	public double checkout(Integer code, Double basic, Double discount) {
		Order order = new Order(code, basic, discount);
		shipmentService.shipment(order);
		return orderService.total(order);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Order order = new Order(1034, 150.0, 20.0);

		System.out.println("Pedido código " + order.getCode());
		System.out.println("Valor total: R$ " + orderService.total(order));
	}

}
