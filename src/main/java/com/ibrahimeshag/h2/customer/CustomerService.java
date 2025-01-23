package com.ibrahimeshag.h2.customer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer[] getAllCustomers(Pageable pageable) {
            // Create a Sort object to sort by field "name" in a case-insensitive manner
            Sort sort = Sort.by(Sort.Order.by("name").ignoreCase());

            // Combine the pageable and sort
            Pageable pageableWithSort = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);

            // Perform the query using the `pageableWithSort`
            return customerRepository.findAll(pageableWithSort)
                    .getContent()
                    .toArray(Customer[]::new);


        // another approach, with sorting done outside the query
        //        return customerRepository.findAll(pageable)
        //                .getContent()
        //                .stream()
        //                .sorted((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()))
        //                .toArray(Customer[]::new);
    }

    public Customer getCustomerById(String id) {
        // TODO: to edit it so that it throw ResourceNotFoundException
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
