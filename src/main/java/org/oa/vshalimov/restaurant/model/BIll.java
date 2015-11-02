package org.oa.vshalimov.restaurant.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @Column(name = "billId")
    private int billId;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "billEmployeeId")
    private Employee billEmployee;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "billDeskId")
    private Desk billDesk;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "billClientId")
    private Client billClient;

    public int getBillId() {
        return billId;
    }

    public Employee getBillEmployee() {
        return billEmployee;
    }

    public Desk getBillDesk() {
        return billDesk;
    }

    public Client getBillClient() {
        return billClient;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public void setBillEmployee(Employee billEmployee) {
        this.billEmployee = billEmployee;
    }

    public void setBillDesk(Desk billDesk) {
        this.billDesk = billDesk;
    }

    public void setBillClient(Client billClient) {
        this.billClient = billClient;
    }

}
