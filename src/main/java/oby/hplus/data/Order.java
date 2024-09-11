package oby.hplus.data;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {
    
    
    /***
     * CREATE TABLE ORDERS (
     *     ORDER_ID VARCHAR(16) PRIMARY KEY,
     *     CUSTOMER_ID BIGINT,
     *     SALESPERSON_ID BIGINT
     * );
     */
    
    @Id
    @Column(name = "ORDER_ID")
    private String id;
    
    
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    
    @ManyToOne
    @JoinColumn(name = "SALESPERSON_ID")
    private  SalesPeople salesPeople;
    
    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;
    
    
    public Order() {
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public SalesPeople getSalesPeople() {
        return salesPeople;
    }
    
    public void setSalesPeople(SalesPeople salesPeople) {
        this.salesPeople = salesPeople;
    }
    
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }
    
    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
