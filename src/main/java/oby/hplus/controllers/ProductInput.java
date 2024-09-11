package oby.hplus.controllers;


import oby.hplus.data.Product;

public class ProductInput {
    

    private String id;
    

    private String name;
    

    private int size;
    

    private String variety;
    

    private Double price;
    
   
    private String status;
    
    
    public ProductInput() {
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getSize() {
        return size;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    public String getVariety() {
        return variety;
    }
    
    public void setVariety(String variety) {
        this.variety = variety;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    
    public Product getProduct() {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setSize(size);
        product.setVariety(variety);
        product.setPrice(price);
        product.setStatus(status);
        return product;
    }
}
