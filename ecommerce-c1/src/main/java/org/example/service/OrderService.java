package org.example.service;
import org.example.model.Order;
import org.example.model.Product;

import org.example.model.Sale;
import org.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> updateOrder(Long id, Order updatedOrder) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            updatedOrder.setId(id);
            return Optional.of(orderRepository.save(updatedOrder));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteOrder(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            orderRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Sale> getSalesByProduct() {
        List<Order> orders = orderRepository.findAll();
        Map<Product, Integer> productSalesMap = new HashMap<>();

        for (Order order : orders) {
            Product product = order.getProduct();
            int quantity = order.getQuantity();

            // Actualizar el total de ventas por producto
            productSalesMap.put(product, productSalesMap.getOrDefault(product, 0) + quantity);
        }

        List<Sale> sales = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : productSalesMap.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            Sale sale = new Sale(product, quantity);
            sales.add(sale);
        }

        return sales;
    }
}