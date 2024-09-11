package oby.hplus.controllers;

import oby.hplus.data.Order;

public class OrderInput {
    
    private Long customerId;
    private  Long salesPersonId;
    
    public OrderInput() {
    }
    
    public Long getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    
    public Long getSalesPersonId() {
        return salesPersonId;
    }
    
    public void setSalesPersonId(Long salesPersonId) {
        this.salesPersonId = salesPersonId;
    }
}
