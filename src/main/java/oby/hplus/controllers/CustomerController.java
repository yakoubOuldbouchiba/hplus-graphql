package oby.hplus.controllers;


import oby.hplus.data.Customer;
import oby.hplus.data.CustomerRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class CustomerController {
    private final CustomerRepository customerRepository;
    
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }
    
    @QueryMapping
    public Customer customer(@Argument Long id){
        return  customerRepository.findById(id).orElse(null);
    }
    
    
    @QueryMapping
    public Customer customerByEmail(@Argument String email){
        return customerRepository.findCustomerByEmail(email);
    }
    
    
    @MutationMapping
    public Customer addCustomer(@Argument(name = "input") CustomerInput input){
        return customerRepository.save(input.getCustomer());
    }
    
    
    @MutationMapping
    public Customer updateCustomer(@Argument(name = "id") Long id , @Argument(name = "input") CustomerInput input){
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null){
            customer.setFirstName(input.getFirstName());
            customer.setLastName(input.getLastName());
            customer.setEmail(input.getEmail());
            customer.setAddress(input.getAddress());
            customer.setPhoneNumber(input.getPhone());
            customer.setCity(input.getCity());
            customer.setState(input.getState());
            customer.setZipCode(input.getZipCode());
            return customerRepository.save(customer);
            
            
        }
        throw new NoSuchElementException("Customer not found");
        
    }
}
