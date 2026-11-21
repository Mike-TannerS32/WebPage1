package com.sd.Server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.PostMapping;

public class ShopController {
    @Autowired
    private ShopDBConnector shopDbConnector;
}
