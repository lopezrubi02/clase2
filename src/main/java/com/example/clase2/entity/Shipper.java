package com.example.clase2.entity;

import javax.persistence.*;

@Entity
@Table(name="shippers") //error de ide
public class Shipper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shipperid;
    @Column(nullable=false)
    private String companyname; //companyName lo convierte a -> company_name
    private String phone;

    public int getShipperid() {
        return shipperid;
    }

    public void setShipperid(int shipperid) {
        this.shipperid = shipperid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
