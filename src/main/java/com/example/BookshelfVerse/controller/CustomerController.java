package com.example.BookshelfVerse.controller;

import com.example.BookshelfVerse.dto.CustomerDTO;
import com.example.BookshelfVerse.model.Customer;
import com.example.BookshelfVerse.service.serviceImp.CustomerServiceImp;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class CustomerController
{
    CustomerServiceImp customerServiceImp;

    @GetMapping("/all")
    public Page<CustomerDTO> findAllCustomer(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int pageSize)
    {
        Pageable pageable = PageRequest.of(page,pageSize);

        return customerServiceImp.findAllCustomer(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findCustomerById(@PathVariable int id)
    {
        return ResponseEntity.ok(customerServiceImp.findCustomerById(id));
    }

    @PostMapping("/add")
     public ResponseEntity<String> createCustomer(@RequestBody Customer customer)
    {
        customerServiceImp.createCustomer(customer);
        return ResponseEntity.ok("Create");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer)
    {
        customerServiceImp.updateCustomer(customer);
        return ResponseEntity.ok("Update");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable int id)
    {
        customerServiceImp.deleteCustomerById(id);
        return ResponseEntity.ok("Delete");
    }
}
