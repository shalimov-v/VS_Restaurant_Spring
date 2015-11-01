package org.oa.vshalimov.restaurant.model;

import javax.persistence.*;

@Entity
@Table(name = "discount")
public class Discount {

    @Id
    @Column(name = "discountId")
    private int discountId;

    @Column(name = "discountName")
    private String discountName;

    @Column(name = "discountValue")
    private int discountValue;

    public int getDiscountId() {
        return discountId;
    }

    public String getDiscountName() {
        return discountName;
    }

    public int getDiscountValue() {
        return discountValue;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public void setDiscountValue(int discountValue) {
        this.discountValue = discountValue;
    }

}