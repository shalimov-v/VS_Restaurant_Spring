package org.oa.vshalimov.restaurant.model;

import javax.persistence.*;

@Entity
@Table(name = "desk")
public class Desk {

    @Id
    @Column(name = "deskId")
    private int deskId;

    @Column(name = "deskName")
    private String deskName;

    @Column(name = "deskMaxPersons")
    private int deskMaxPersons;

    public int getDeskId() {
        return deskId;
    }

    public String getDeskName() {
        return deskName;
    }

    public int getDeskMaxPersons() {
        return deskMaxPersons;
    }

    public void setDeskId(int deskId) {
        this.deskId = deskId;
    }

    public void setDeskName(String deskName) {
        this.deskName = deskName;
    }

    public void setDeskMaxPersons(int deskMaxPersons) {
        this.deskMaxPersons = deskMaxPersons;
    }
}