package org.oa.vshalimov.restaurant.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table (name = "menu")
public class Menu {

    @Id
    @Column(name = "menuId")
    private int menuId;

    @ManyToOne
    @JoinColumn(name = "menuDishId")
    private Dish menuDish;

    @Column(name = "menuPrice")
    private BigDecimal menuPrice;

    public int getMenuId() {
        return menuId;
    }

    public Dish getMenuDish() {
        return menuDish;
    }

    public BigDecimal getMenuPrice() {
        return menuPrice;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public void setMenuDish(Dish dish) {
        this.menuDish = dish;
    }

    public void setMenuPrice(BigDecimal menuPrice) {
        this.menuPrice = menuPrice;
    }

}
