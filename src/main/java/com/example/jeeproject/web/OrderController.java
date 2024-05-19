package com.example.jeeproject.web;



import com.example.jeeproject.dao.entities.Order;
import com.example.jeeproject.dao.entities.Product;
import com.example.jeeproject.services.CustomerManager;
import com.example.jeeproject.services.OrderManager;
import com.example.jeeproject.services.ProductManager;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class OrderController {

    @Autowired
    private OrderManager orderManager;
    @Autowired
    private CustomerManager customerManager;
    @Autowired
    private ProductManager productManager;

    @GetMapping("/orders")
    public String orders(Model model) {
        List<Order> orders = orderManager.getAllOrders();
        Map<Integer, Double> orderTotalAmounts = new HashMap<>();
        Map<Integer, String> productOccurrencesDisplay = new HashMap<>();

        for (Order order : orders) {
            double totalAmount = orderManager.totalAmount(order.getOrderId());
            orderTotalAmounts.put(order.getOrderId(), totalAmount);

            String productDisplay = orderManager.productsDisplay(order.getOrderId());
            productOccurrencesDisplay.put(order.getOrderId(), productDisplay);
        }

        model.addAttribute("orders", orders);
        model.addAttribute("orderTotalAmounts", orderTotalAmounts);
        model.addAttribute("productOccurrencesDisplay", productOccurrencesDisplay);

        return "orders";
    }


    @GetMapping("/add_order")
    public String showAddOrderForm(Model model) {
        model.addAttribute("orderCreated", new Order());
        model.addAttribute("products", productManager.getAllProducts());
        model.addAttribute("customers", customerManager.getAllCustomers());
        return "add_order";
    }





    @PostMapping("/add_orderPost")
    public String addOrder(Model model, @ModelAttribute("orderCreated") Order order,
                           @RequestParam("orderDescription") String orderDescription,
                           @RequestParam("customer") Long customerId,
                           @RequestParam("productsJson") String productsJson) throws Exception {
        order.setOrderDescription(orderDescription);
        order.setCustomer(customerManager.getCustomerById(customerId));

        ObjectMapper objectMapper = new ObjectMapper();
        List<Long> productIds = objectMapper.readValue(productsJson, new TypeReference<List<Long>>() {});

        List<Product> products = new ArrayList<>();
        for (Long productId : productIds) {
            products.add(productManager.getProductById(productId));
        }

        order.setProducts(products);

        for (Product product : products) {
            product.setQuantity(product.getQuantity() - 1);
        }
        orderManager.addOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/delete_order")
    public String deleteOrder(@RequestParam("id") Integer orderId) {
        orderManager.deleteOrderByOrderId(orderId);
        return "redirect:/orders";
    }

}
