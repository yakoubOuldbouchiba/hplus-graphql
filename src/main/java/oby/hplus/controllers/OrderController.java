package oby.hplus.controllers;

import oby.hplus.data.CustomerRepository;
import oby.hplus.data.Order;
import oby.hplus.data.OrderRepository;
import oby.hplus.data.SalesPeopleRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class OrderController {
    
    private final OrderRepository repository;
    private final CustomerRepository customerRepository;
    private final SalesPeopleRepository salesPeopleRepository;
    
    
    
    
    public OrderController(final OrderRepository repository, CustomerRepository customerRepository, SalesPeopleRepository salesPeopleRepository) {
        this.repository = repository;
        this.customerRepository = customerRepository;
        this.salesPeopleRepository = salesPeopleRepository;
    }
    
    @QueryMapping
    public List<Order> orders() {
        return repository.findAll();
    }
    
    @QueryMapping
    public  Order order(@Argument final String id) {
        return repository.findById(id).orElse(null);
    }
    
    @MutationMapping
    public Order addOrder(@Argument(name = "input") final OrderInput input) {
        Order order = new Order();
        order.setId("M"+System.currentTimeMillis());
        order.setCustomer(customerRepository.findById(input.getCustomerId()).orElse(null));
        order.setSalesPeople(salesPeopleRepository.findById(input.getSalesPersonId()).orElse(null));
        return repository.save(order);
    }
    
    @MutationMapping
    public Order updateOrder(@Argument(name = "id") String id, @Argument(name = "input") final OrderInput input) {
        Order order = repository.findById(id).orElse(null);
        if (order != null) {
            order.setCustomer(customerRepository.findById(input.getCustomerId()).orElse(null));
            order.setSalesPeople(salesPeopleRepository.findById(input.getSalesPersonId()).orElse(null));
            return repository.save(order);
        }
        throw new NoSuchElementException("Order not found");
    }
    
}
