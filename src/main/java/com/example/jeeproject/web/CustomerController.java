package com.example.jeeproject.web;

import com.example.jeeproject.dao.entities.Customer;
import com.example.jeeproject.services.CustomerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class CustomerController {

    @Autowired
    private CustomerManager customerManager;


    @GetMapping("/customers")
    public String getCustomers(Model model) {
        List<Customer> customers = customerManager.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("/add_customer")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "add_customer";
    }

    @PostMapping("/add_customerPost")
    public String addCustomerPost(Model model, @RequestParam(name = "customerName") String name, @RequestParam(name = "customerEmail") String email, @RequestParam(name = "customerAddress") String address) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        customerManager.addCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete_customer")
    public String deleteCustomer(Model model, @RequestParam(name = "customerId") Long customerId) {
        if(customerManager.deleteCustomerByCustomerId(customerId)){
            return "redirect:customers";
        }
        else{
            return "redirect:error";
        }
    }

    @GetMapping("update_customer")
    public String updateCustomer(Model model, @RequestParam(name = "customerId") Long customerId) {
        Customer customer = customerManager.getCustomerById(customerId);
        model.addAttribute("customerToBeUpdated", customer);
        return "update_customer";
    }

    @PostMapping("/save_updated_customer")
    public String saveUpdatedCustomer(@ModelAttribute("customerToBeUpdated") Customer customer) {
        customerManager.updateCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/customer_details")
    public String getCustomerDetails(Model model, @RequestParam(name = "customerId") Long customerId) {
        Customer customer = customerManager.getCustomerById(customerId);
        model.addAttribute("customerToBeDetailed", customer);
        return "customer_details";
    }


}
