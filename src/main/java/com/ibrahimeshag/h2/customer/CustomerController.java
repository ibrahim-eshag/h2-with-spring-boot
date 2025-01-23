package com.ibrahimeshag.h2.customer;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private  final CustomerService customerService;

    @GetMapping
    public Customer[] getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById( @PathVariable String id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer saveCustomer(@Valid @RequestBody Customer customer) {
        System.out.println("customerrrr: "+ customer);
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable String id) {
        customerService.deleteCustomerById(id);
    }

    @DeleteMapping
    public void deleteAllCustomers() {
        customerService.deleteAllCustomers();
    }

    @GetMapping("/count")
    public long getCustomerCount() {
        return customerService.getCustomerCount();
    }

    @GetMapping("/exist/{id}")
    public boolean isCustomerExist(@PathVariable String id) {
        return customerService.isCustomerExist(id);
    }

}
