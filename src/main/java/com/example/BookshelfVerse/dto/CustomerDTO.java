package com.example.BookshelfVerse.dto;

import com.example.BookshelfVerse.model.Customer;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerDTO {

    int id;
    String firstName;

    public CustomerDTO(Customer customer)
    {
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
    }
}
