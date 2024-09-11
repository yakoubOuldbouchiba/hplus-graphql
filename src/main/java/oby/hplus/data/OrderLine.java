package oby.hplus.data;

import jakarta.persistence.*;

@Entity
@Table(name = "ORDER_LINES")
public class OrderLine {
    
    /***
     * CREATE TABLE ORDER_LINES(
     *     ORDER_LINE_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
     *     ORDER_ID VARCHAR(16),
     *     PRODUCT_ID VARCHAR(32),
     *     QUANTITY INT
     * );
     */
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_LINE_ID")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order  order;
    
    
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    
    @Column(name = "QUANTITY")
    private int quantity;
    
    
    public OrderLine() {
    }
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Order getOrder() {
        return order;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
