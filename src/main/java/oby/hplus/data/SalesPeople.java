package oby.hplus.data;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "SALESPEOPLE")
public class SalesPeople {
    
    /***
     * CREATE TABLE SALESPEOPLE (
     *     SALESPERSON_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
     *     FIRST_NAME VARCHAR(64),
     *     LAST_NAME VARCHAR(64),
     *     EMAIL VARCHAR(128) UNIQUE,
     *     PHONE VARCHAR(32),
     *     ADDRESS VARCHAR(256),
     *     CITY VARCHAR(64),
     *     STATE CHAR(2),
     *     ZIPCODE VARCHAR(12)
     * );
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SALESPERSON_ID")
    private Long id;
    
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    @Column(name = "LAST_NAME")
    private String lastName;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "PHONE")
    private String phone;
    
    @Column(name = "ADDRESS")
    private String address;
    
    @Column(name = "CITY")
    private String city;
    
    @Column(name = "STATE")
    private String state;
    
    @Column(name = "ZIPCODE")
    private String zipCode;
    
    
    @OneToMany(mappedBy = "salesPeople")
    private List<Order> orders;
    
    public SalesPeople() {
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getZipCode() {
        return zipCode;
    }
    
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    
    public List<Order> getOrders() {
        return orders;
    }
    
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
