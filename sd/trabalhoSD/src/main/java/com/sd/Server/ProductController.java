package com.sd.Server;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sd.Models.Product;

@RestController 
@RequestMapping("/products")
public class ProductController {
    private final ShopDbConnector shopDbConnector;

    public ProductController (ShopDbConnector shopDbConnector){
        this.shopDbConnector = shopDbConnector;
    }

    // 200 - created
    @PostMapping 
    public ResponseEntity<Integer> createProduct(@RequestBody Product product) throws SQLException{
        int id = shopDbConnector.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    // 201 - found, 404 - not found, 400 - bad request
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) throws SQLException{
        return shopDbConnector.getProductById(id);
    }

    @GetMapping
    public List<Product> list(@RequestParam(required = false) String category, 
                                @RequestParam(required = false) String name)  throws SQLException{
        return shopDbConnector.getProducts(category, name);
    }

    // não tenho a certeza se foi a decisão correta
    // deve devolver 204 - updated successfully
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable int id, @RequestBody Product product) throws SQLException{
        boolean updated = shopDbConnector.updateProduct(id, product);
        if(!updated){
            return ResponseEntity.notFound().build(); // 404 not found   
        }
        return ResponseEntity.noContent().build(); // 204 updated
    }
    
    
}
