package com.example.tienda_emazon.domain.model;

public class SuppliedModel {

    private Long suppliedId;
    private String suppliedName;
    private int suppliedAmount;

    public SuppliedModel() {  /**/

    }

    public Long getSuppliedId() {
        return suppliedId;
    }

    public void setSuppliedId(Long suppliedId) {
        this.suppliedId = suppliedId;
    }

    public String getSuppliedName() {
        return suppliedName;
    }

    public void setSuppliedName(String suppliedName) {
        this.suppliedName = suppliedName;
    }

    public int getSuppliedAmount() {
        return suppliedAmount;
    }

    public void setSuppliedAmount(int suppliedAmount) {
        this.suppliedAmount = suppliedAmount;
    }
}
