package oby.hplus.data;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PRODUCTS")
public class Product {
    /***
     * CREATE TABLE PRODUCTS (
     *     PRODUCT_ID VARCHAR(32) PRIMARY KEY,
     *     NAME VARCHAR(128),
     *     SIZE INT,
     *     VARIETY VARCHAR(32),
     *     PRICE NUMERIC(4,2),
     *     STATUS VARCHAR(16)
     * );
     */
    
    @Id
    @Column(name = "PRODUCT_ID")
    private String id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "size")
    private int size;
    
    @Column(name = "variety")
    private String variety;
    
    @Column(name = "price")
    private Double price;
    
    @Column(name = "status")
    private String status;
    
    
    @OneToMany(mappedBy = "product")
    private List<OrderLine> orderLines;
    
    
    public Product() {
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
    
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }
    
    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
