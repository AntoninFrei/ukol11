package com.engeto.ukol11;

import java.math.BigDecimal;
import java.sql.ResultSet;

public class Item {

    private Integer id;

    private String partNo;

    private String serialNo;

    private String name;

    private String description;

    private Integer numberInStock;

    private BigDecimal price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(Integer numberInStock) {
        this.numberInStock = numberInStock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    /*
    public  void setItem(ResultSet resultSet) {
        this.setId(resultSet.getInt("id"));
        this.setPartNo(resultSet.getString("partNo"));
        this.setSerialNo(resultSet.getString("serialNo"));
        this.setName(resultSet.getString("name"));
        this.setDescription(resultSet.getString("description"));
        this.setNumberInStock(resultSet.getInt("numberInStock"));
        this.setPrice(resultSet.getBigDecimal("price"));

    }*/


}
