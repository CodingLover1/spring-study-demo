package com.ws;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class Customer {
    private String firstName;
    private String lastName;

    public Customer(){}

    public Customer(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

}
