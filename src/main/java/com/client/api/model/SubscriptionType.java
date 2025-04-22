package com.client.api.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Table(name = "subscriptions_type")
@Entity
public class SubscriptionType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name = "access_month")
    private Long accessMonth;

    private BigDecimal price;

    @Column(name = "product_key")
    private String productKey;

    public SubscriptionType() {
    }

    public SubscriptionType(Long id, String name, Long accessMonth, BigDecimal price, String productKey) {
        this.id = id;
        this.name = name;
        this.accessMonth = accessMonth;
        this.price = price;
        this.productKey = productKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAccessMonth() {
        return accessMonth;
    }

    public void setAccessMonth(Long accessMonth) {
        this.accessMonth = accessMonth;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    @Override
    public String toString() {
        return "SubscriptionType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accessMonth=" + accessMonth +
                ", price=" + price +
                ", productKey='" + productKey + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionType that = (SubscriptionType) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getAccessMonth(), that.getAccessMonth()) && Objects.equals(getPrice(), that.getPrice()) && Objects.equals(getProductKey(), that.getProductKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAccessMonth(), getPrice(), getProductKey());
    }
}
