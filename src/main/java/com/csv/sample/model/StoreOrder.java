package com.csv.sample.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "STORE_ORDER")
public class StoreOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "ORDER_ID", unique = true, length = 20, nullable = false)
    private String orderId;

    @Temporal(TemporalType.DATE)
    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "SHIP_DATE")
    private Date shipDate;

    @Column(name = "SHIP_MODE", length = 20)
    private String shipMode;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @Column(name = "DISCOUNT")
    private BigDecimal discount;

    @Column(name = "PROFIT", nullable = false)
    private BigDecimal profit;

    @Column(name = "PRODUCT_ID", length = 20, nullable = false)
    private String productId;

    @Column(name = "CUSTOMER_NAME", length = 255, nullable = false)
    private String customerName;

    @Column(name = "CATEGORY", length = 255, nullable = false)
    private String category;

    @Column(name = "CUSTOMER_ID", length = 20, nullable = false)
    private String customerId;

    @Column(name = "PRODUCT_NAME", length = 255, nullable = false)
    private String productName;


    public Long getId() {
        return id;
    }

    public StoreOrder setId(Long id) {
        this.id = id;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public StoreOrder setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public StoreOrder setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public StoreOrder setShipDate(Date shipDate) {
        this.shipDate = shipDate;
        return this;
    }

    public String getShipMode() {
        return shipMode;
    }

    public StoreOrder setShipMode(String shipMode) {
        this.shipMode = shipMode;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public StoreOrder setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public StoreOrder setDiscount(BigDecimal discount) {
        this.discount = discount;
        return this;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public StoreOrder setProfit(BigDecimal profit) {
        this.profit = profit;
        return this;
    }

    public String getProductId() {
        return productId;
    }

    public StoreOrder setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public StoreOrder setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public StoreOrder setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getCustomerId() {
        return customerId;
    }

    public StoreOrder setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public StoreOrder setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    @Override
    public String toString() {
        return "StoreOrder{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", shipDate=" + shipDate +
                ", shipMode='" + shipMode + '\'' +
                ", quantity=" + quantity +
                ", discount=" + discount +
                ", profit=" + profit +
                ", productId='" + productId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", category='" + category + '\'' +
                ", customerId='" + customerId + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}