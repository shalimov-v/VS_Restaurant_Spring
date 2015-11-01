package org.oa.vshalimov.restaurant.model;

import javax.persistence.*;

@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @Column(name = "dishId")
    private int dishId;

    @Column(name = "dishName")
    private String dishName;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "dishTypeId")
    private DishType dishType;

    @Column(name = "dishDescription")
    private String dishDescription;

    public int getDishId() {
        return dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public DishType getDishType() {
        return dishType;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

}
