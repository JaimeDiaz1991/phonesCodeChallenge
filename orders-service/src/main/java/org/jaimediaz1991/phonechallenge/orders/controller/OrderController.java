package org.jaimediaz1991.phonechallenge.orders.controller;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.jaimediaz1991.phonechallenge.orders.model.dto.OrderRequest;
import org.jaimediaz1991.phonechallenge.orders.service.JsonConverter;
import org.jaimediaz1991.phonechallenge.orders.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private JsonConverter jsonConverter;

    @PostMapping(value = "/orders")
    public ResponseEntity<String> create(@RequestBody @Valid OrderRequest orderRequest) {
        log.info(jsonConverter.convertToJson(orderService.createOrder(orderRequest)));
        return ResponseEntity.ok("OK");
    }

}
