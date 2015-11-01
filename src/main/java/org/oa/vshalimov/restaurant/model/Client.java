package org.oa.vshalimov.restaurant.model;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "clientId")
    private int clientId;

    @Column(name = "clientFirstName")
    private String clientFirstName;

    @Column(name = "clientLastName")
    private String clientLastName;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "clientDiscountId")
    private Discount clientDiscount;

    public int getClientId() {
        return clientId;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public Discount getClientDiscount() {
        return clientDiscount;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public void setClientDiscount(Discount clientDiscount) {
        this.clientDiscount = clientDiscount;
    }

}