package org.oa.vshalimov.restaurant.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {

    @EmbeddedId
    private OrdersPrimaryKey ordersPrimaryKey;

    @Column(name = "ordersQuantity")
    private int ordersQuantity;

    public OrdersPrimaryKey getOrdersPrimaryKey() {
        return ordersPrimaryKey;
    }

    public int getOrdersQuantity() {
        return ordersQuantity;
    }

    public void setOrdersPrimaryKey(OrdersPrimaryKey ordersPrimaryKey) {
        this.ordersPrimaryKey = ordersPrimaryKey;
    }

    public void setOrdersQuantity(int ordersQuantity) {
        this.ordersQuantity = ordersQuantity;
    }
}
