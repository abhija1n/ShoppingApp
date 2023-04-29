package com.projects.orderservice.service;

import com.projects.orderservice.dto.OrderRequest;

public interface OrderService {

    void placeOrder(OrderRequest orderRequest);

}
