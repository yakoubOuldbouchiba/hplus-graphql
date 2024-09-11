package oby.hplus.controllers;

import oby.hplus.data.Product;
import oby.hplus.data.ProductRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class ProductController {
    
    private final ProductRepository productRepository;
    
    public ProductController(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    @QueryMapping
    public List<Product> products() {
        return productRepository.findAll();
    }
    
    
    @QueryMapping
    public Product product(@Argument String id) {
        return productRepository.findById(id).orElse(null);
    }
    
    @QueryMapping
    public List<Product> productByName(@Argument String name) {
        return productRepository.findByName(name);
    }
    
    
    @MutationMapping
    public Product addProduct(@Argument("input") ProductInput input) {
        return productRepository.save(input.getProduct());
    }
    
    
    @MutationMapping
    public Product updateProduct(@Argument("id") String id ,@Argument("input") ProductInput input) {
        Product product = productRepository.findById(id).orElse(null);
        if(product != null) {
            product.setName(input.getName());
            product.setPrice(input.getPrice());
            product.setSize(input.getSize());
            product.setStatus(input.getStatus());
            product.setVariety(input.getVariety());
            return productRepository.save(product);
        }
        throw new NoSuchElementException("Product not found");
    }
}
