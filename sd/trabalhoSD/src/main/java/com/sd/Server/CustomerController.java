package com.sd.Server;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sd.Models.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    private final ShopDbConnector shopDbConnector;

    //inicializar o controller com o connector
    public CustomerController (ShopDbConnector shopDbConnector){
        this.shopDbConnector = shopDbConnector;
    }

    @PostMapping 
    public ResponseEntity<Integer> createCustomer(@RequestBody Customer customer) throws SQLException{
        int id = shopDbConnector.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Integer id) throws SQLException{
        return shopDbConnector.getCustomerById(id);
    }
}
