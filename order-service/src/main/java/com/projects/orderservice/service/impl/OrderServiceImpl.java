package com.projects.orderservice.service.impl;

import com.projects.orderservice.dto.OrderLineItemsDto;
import com.projects.orderservice.dto.OrderRequest;
import com.projects.orderservice.entity.Order;
import com.projects.orderservice.entity.OrderLineItems;
import com.projects.orderservice.repository.OrderRepository;
import com.projects.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    //Inject Order repository to order service
    private final OrderRepository orderRepository;


    //In this way we are reciving order Request from the client to controller
    @Override
    public void placeOrder(OrderRequest orderRequest) {
        Order order= new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList().stream()
                .map(this::mapToDto).toList();
        order.setOrderLineItemsList(orderLineItems);

        orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems= new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItems.getSkuCode());
        return orderLineItems;
    }

}
