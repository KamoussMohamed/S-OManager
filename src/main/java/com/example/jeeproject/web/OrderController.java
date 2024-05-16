package com.example.jeeproject.web;


import com.example.jeeproject.dao.entities.Order;
import com.example.jeeproject.services.OrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class OrderController {

    @Autowired
    private OrderManager orderManager;

    @GetMapping("/orders")
    public String orders(Model model) {
        List<Order> orders = orderManager.getAllOrders();
        Map<Integer, Double> orderTotalAmounts = new HashMap<>();
        for (Order order : orders) {
            double totalAmount = orderManager.totalAmount(order.getOrderId());
            orderTotalAmounts.put(order.getOrderId(), totalAmount);
        }

        model.addAttribute("orders", orders);
        model.addAttribute("orderTotalAmounts", orderTotalAmounts);

        return "orders";
    }

    @GetMapping("/add_order")
    public String addORder(Model model) {
        model.addAttribute("order", new Order());
        return "add_order";
    }

    @PostMapping("add_OrderPost")
    public String addOrderPost(@ModelAttribute("order") Order order) {
        return "redirect:/orders";
    }
}
