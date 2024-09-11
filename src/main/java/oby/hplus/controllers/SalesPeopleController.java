package oby.hplus.controllers;

import oby.hplus.data.SalesPeople;
import oby.hplus.data.SalesPeopleRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class SalesPeopleController {
    
    private final SalesPeopleRepository repository;
    
    public SalesPeopleController(SalesPeopleRepository repository) {
        this.repository = repository;
    }
    
    
    @QueryMapping
    public List<SalesPeople> salesPeople(){
        return  repository.findAll();
    }
    
    @QueryMapping
    public SalesPeople salesPerson(@Argument final Long id){
        return repository.findById(id).get();
    }
    
    @MutationMapping
    public SalesPeople addSalesPerson(@Argument(name = "input") final SalesPeopleInput input){
        return repository.save(input.getSalesPeople());
    }
    
    
    @MutationMapping
    public SalesPeople updateSalesPerson(@Argument(name = "id") Long id , @Argument(name = "input") final SalesPeopleInput input){
        SalesPeople salesPeople = repository.findById(id).orElse(null);
        if(salesPeople != null){
            salesPeople.setAddress(input.getAddress());
            salesPeople.setCity(input.getCity());
            salesPeople.setEmail(input.getEmail());
            salesPeople.setFirstName(input.getFirstName());
            salesPeople.setLastName(input.getLastName());
            salesPeople.setPhone(input.getPhone());
            salesPeople.setState(input.getState());
            salesPeople.setZipCode(input.getZipCode());
            return repository.save(salesPeople);
        }
        throw new NoSuchElementException("SalesPeople not found");
    }
}
