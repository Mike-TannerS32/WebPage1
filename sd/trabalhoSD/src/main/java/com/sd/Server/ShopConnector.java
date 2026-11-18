package com.sd.Server;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.sd.Models.Order;
import com.sd.Models.Product;
import com.sd.Models.Customer;
import com.sd.Models.CartItem;
import com.sd.Models.OrderItem;

@Component
public class ShopConnector {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ShopConnector(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
}