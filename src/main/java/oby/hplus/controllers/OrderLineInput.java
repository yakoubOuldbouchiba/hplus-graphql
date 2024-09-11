package oby.hplus.controllers;

import oby.hplus.data.OrderLine;

public class OrderLineInput {
    
    private String orderInputId;
    private String productInputId;
    private int quantity;
    
    public OrderLineInput() {
    }
    
    public String getOrderInputId() {
        return orderInputId;
    }
    
    public void setOrderInputId(String orderInputId) {
        this.orderInputId = orderInputId;
    }
    
    public String getProductInputId() {
        return productInputId;
    }
    
    public void setProductInputId(String productInputId) {
        this.productInputId = productInputId;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
