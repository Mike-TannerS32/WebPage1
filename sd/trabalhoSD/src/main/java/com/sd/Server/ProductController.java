package com.sd.Server;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sd.Models.Product;

@RestController 
@RequestMapping("/products")
public class ProductController {
    private final ShopDbConnector shopDbConnector;

    public ProductController (ShopDbConnector shopDbConnector){
        this.shopDbConnector = shopDbConnector;
    }

    @PostMapping 
    public ResponseEntity<Integer> createProduct(@RequestBody Product product) throws SQLException{
        int id = shopDbConnector.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
}
