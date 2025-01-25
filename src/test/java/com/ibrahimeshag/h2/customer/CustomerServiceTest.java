package com.ibrahimeshag.h2.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;

    @MockitoBean
    private CustomerRepository customerRepository;

    @Test
    void testGetAllCustomers() {
        // Mock Pageable input
        Pageable pageable = PageRequest.of(0, 10);

        // Mock data
        List<Customer> customers = List.of(
                new Customer("1", "John Doe", "john.doe@gmail.com", "123456789"),
                new Customer("2", "Jane Doe", "jane.doe@gmail.com", "987654321")
        );

        // Mock repository behavior
        when(customerRepository.findAll(any(Pageable.class)))
                .thenReturn(new PageImpl<>(customers, pageable, customers.size()));

        // Perform test
        Customer[] result = customerService.getAllCustomers(pageable);

        // Validate results
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals("John Doe", result[0].getName());
        assertEquals("Jane Doe", result[1].getName());
    }
}