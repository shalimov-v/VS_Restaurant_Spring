package org.oa.vshalimov.restaurant.model;

import javax.persistence.*;

@Entity
@Table(name = "dishtype")
public class DishType {

    @Id
    @Column(name = "dishTypeId")
    private int dishTypeId;

    @Column(name = "dishTypeName")
    private String dishTypeName;

    public int getDishTypeId() {
        return dishTypeId;
    }

    public String getDishTypeName() {
        return dishTypeName;
    }

    public void setDishTypeId(int dishTypeId) {
        this.dishTypeId = dishTypeId;
    }

    public void setDishTypeName(String dishTypeName) {
        this.dishTypeName = dishTypeName;
    }

}
