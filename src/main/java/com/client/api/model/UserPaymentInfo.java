package com.client.api.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "user_payment_info")
public class UserPaymentInfo implements Serializable {

    @Id
    @Column(name = "user_payment_info_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_expiration_month")
    private Long cardExpirationMonth;

    @Column(name = "cart_expiration_year")
    private Long cartExpirationYear;

    @Column(name = "user_payment_info_id")
    private String cardSecurityCode;

    private BigDecimal price;

    @Column(name = "user_payment_info_id")
    private LocalDate dtPayment;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public UserPaymentInfo() {
    }

    public UserPaymentInfo(Long id, String cardNumber, Long cardExpirationMonth, Long cartExpirationYear, String cardSecurityCode, BigDecimal price, LocalDate dtPayment, User user) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardExpirationMonth = cardExpirationMonth;
        this.cartExpirationYear = cartExpirationYear;
        this.cardSecurityCode = cardSecurityCode;
        this.price = price;
        this.dtPayment = dtPayment;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getCardExpirationMonth() {
        return cardExpirationMonth;
    }

    public void setCardExpirationMonth(Long cardExpirationMonth) {
        this.cardExpirationMonth = cardExpirationMonth;
    }

    public Long getCartExpirationYear() {
        return cartExpirationYear;
    }

    public void setCartExpirationYear(Long cartExpirationYear) {
        this.cartExpirationYear = cartExpirationYear;
    }

    public String getCardSecurityCode() {
        return cardSecurityCode;
    }

    public void setCardSecurityCode(String cardSecurityCode) {
        this.cardSecurityCode = cardSecurityCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getDtPayment() {
        return dtPayment;
    }

    public void setDtPayment(LocalDate dtPayment) {
        this.dtPayment = dtPayment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserPaymentInfo{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardExpirationMonth=" + cardExpirationMonth +
                ", cartExpirationYear=" + cartExpirationYear +
                ", cardSecurityCode='" + cardSecurityCode + '\'' +
                ", price=" + price +
                ", dtPayment=" + dtPayment +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserPaymentInfo that = (UserPaymentInfo) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCardNumber(), that.getCardNumber()) && Objects.equals(getCardExpirationMonth(), that.getCardExpirationMonth()) && Objects.equals(getCartExpirationYear(), that.getCartExpirationYear()) && Objects.equals(getCardSecurityCode(), that.getCardSecurityCode()) && Objects.equals(getPrice(), that.getPrice()) && Objects.equals(getDtPayment(), that.getDtPayment()) && Objects.equals(getUser(), that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCardNumber(), getCardExpirationMonth(), getCartExpirationYear(), getCardSecurityCode(), getPrice(), getDtPayment(), getUser());
    }
}
