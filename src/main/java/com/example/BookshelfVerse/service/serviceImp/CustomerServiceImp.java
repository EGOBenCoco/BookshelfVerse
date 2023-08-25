package com.example.BookshelfVerse.service.serviceImp;

import com.example.BookshelfVerse.dto.CustomerDTO;
import com.example.BookshelfVerse.model.Customer;
import com.example.BookshelfVerse.repository.CustomerRepository;
import com.example.BookshelfVerse.service.BookCollectionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerServiceImp {
    CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public Page<CustomerDTO> findAllCustomer(Pageable pageable) {
        Page<Customer> customerPage = customerRepository.findAll(pageable);
        return customerPage.map(CustomerDTO::new);
    }


    @Transactional(readOnly = true)
    public CustomerDTO findCustomerById(int id) {
        Customer customer = customerRepository.findById(id);
        return new CustomerDTO(customer);
    }


    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }


    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);
    }

}
