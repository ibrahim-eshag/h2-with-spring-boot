package com.ibrahimeshag.h2.customer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer[] getAllCustomers() {
        return customerRepository.findAll().toArray(new Customer[0]);
    }

    public Customer getCustomerById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomerById(String id) {
        customerRepository.deleteById(id);
    }

    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }

    public long getCustomerCount() {
        return customerRepository.count();
    }

    public boolean isCustomerExist(String id) {
        return customerRepository.existsById(id);
    }

}
