package com.example.ecommerce.service;

import com.example.ecommerce.DTO.mapper.Mapper;
import com.example.ecommerce.DTO.response.OrderItemResponseDTO;
import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.model.OrderItem;
import com.example.ecommerce.repository.CartItemRepository;
import com.example.ecommerce.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final CartItemRepository cartItemRepository;
    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository, CartItemRepository cartItemRepository) {
        this.orderItemRepository = orderItemRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public List<OrderItem> getAllOrderItem(){
        return orderItemRepository.findAll();
    }
    public List<OrderItemResponseDTO> getItemOfAnOrder(Long id){
        List<OrderItem> orderItems = orderItemRepository.findAll();
        return orderItems.stream()
                .map(Mapper::orderItemToOrderItemResponseDTO)
                .collect(Collectors.toList());
    }

    public void cartToOrderItem(Long userId){
        /*
        OrderItem orderItem = new OrderItem();
        for (CartItem cartItem : cartItemRepository.findByUserId(userId)){
            orderItem.setImageUrl(cartItem.getProduct().getImageUrl());
            orderItem.setName(cartItem.getProduct().getName());
            orderItem.setPrice(cartItem.getProduct().getPrice());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setTotalPrice(cartItem.getQuantity() * cartItem.getProduct().getPrice());
            orderItemRepository.save(orderItem);
        }

         */
    }
}
