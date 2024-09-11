package oby.hplus.controllers;


import oby.hplus.data.OrderLine;
import oby.hplus.data.OrderLineRepository;
import oby.hplus.data.OrderRepository;
import oby.hplus.data.ProductRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class OrderLineController {
    
    private final OrderLineRepository orderLineRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    
    
    public OrderLineController(OrderLineRepository orderLineRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderLineRepository = orderLineRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }
    
    @QueryMapping
    public List<OrderLine> orderLines() {
        return orderLineRepository.findAll();
    }
    
    
    @QueryMapping
    public OrderLine orderLine(@Argument final Long id) {
        return orderLineRepository.findById(id).orElse(null);
    }
    
    
    @MutationMapping
    public OrderLine addOrderLine(@Argument(name = "input") final OrderLineInput input) {
        OrderLine orderLine = new OrderLine();
        orderLine.setOrder(orderRepository.findById(input.getOrderInputId()).orElse(null));
        orderLine.setProduct(productRepository.findById(input.getProductInputId()).orElse(null));
        orderLine.setQuantity(input.getQuantity());
        return orderLineRepository.save(orderLine);
    }
    
    @MutationMapping
    public OrderLine updateOrderLine(@Argument(name = "id") Long id ,@Argument(name = "input") final OrderLineInput input) {
        OrderLine orderLine = orderLineRepository.findById(id).orElse(null);
        if(orderLine != null) {
            orderLine.setOrder(orderRepository.findById(input.getOrderInputId()).orElse(null));
            orderLine.setProduct(productRepository.findById(input.getProductInputId()).orElse(null));
            orderLine.setQuantity(input.getQuantity());
            return orderLineRepository.save(orderLine);
        }
        throw new NoSuchElementException("Order line not found");
    }
    
    
    @MutationMapping
    public OrderLine deleteOrderLine(@Argument(name = "id") Long id) {
        OrderLine orderLine = orderLineRepository.findById(id).orElse(null);
        if(orderLine != null) {
            orderLineRepository.delete(orderLine);
            return orderLine;
        }
        throw new NoSuchElementException("Order line not found");
    }
    
}
