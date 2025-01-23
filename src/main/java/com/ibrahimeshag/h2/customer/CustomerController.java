package com.ibrahimeshag.h2.customer;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private  final CustomerService customerService;

    /**
     * Retrieves a paginated and sorted list of customers.
     * Example usage:
     * GET http://localhost:8080/api/v1/customers?page=1&size=10&sort=name,asc
     *
     * @param pageable contains pagination and sorting information provided by Spring Data.
     * @return a paginated collection of customers.
     */

    @GetMapping
    public Customer[] getAllCustomers(Pageable pageable) {
        return customerService.getAllCustomers(pageable);
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
