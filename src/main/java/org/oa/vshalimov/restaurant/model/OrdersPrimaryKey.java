package org.oa.vshalimov.restaurant.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class OrdersPrimaryKey implements Serializable {

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ordersBillId")
    private Bill ordersBill;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ordersMenuId")
    private Menu ordersMenu;

    public Bill getOrdersBill() {
        return ordersBill;
    }

    public Menu getOrdersMenu() {
        return ordersMenu;
    }

    public void setOrdersBill(Bill ordersBill) {
        this.ordersBill = ordersBill;
    }

    public void setOrdersMenu(Menu ordersMenu) {
        this.ordersMenu = ordersMenu;
    }

}
