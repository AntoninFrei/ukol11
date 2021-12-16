package com.engeto.ukol11;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Item  {
        public Item(){

    }


        private Integer id;

        private String partNo;

        private String serialNo;

        private String name;

        private String description;

        private Integer numberInStock;

        private BigDecimal price;

        public Integer getId () {
            return id;
        }

        public void setId (Integer id){
            this.id = id;
        }

        public String getPartNo () {
            return partNo;
        }

        public void setPartNo (String partNo){
            this.partNo = partNo;
        }

        public String getSerialNo () {
            return serialNo;
        }

        public void setSerialNo (String serialNo){
            this.serialNo = serialNo;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

        public String getDescription () {
            return description;
        }

        public void setDescription (String description){
            this.description = description;
        }

        public Integer getNumberInStock () {
            return numberInStock;
        }

        public void setNumberInStock (Integer numberInStock){
            this.numberInStock = numberInStock;
        }

        public BigDecimal getPrice () {
            return price;
        }

        public void setPrice (BigDecimal price){
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

        public List<Item> loadAllAvailableItems () {
            List items = new ArrayList();
            try (

                    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item", "root", "Tisnov1/");) {
                String prikaz = "SELECT * FROM item WHERE numberInStock > 0";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(prikaz);

                while (resultSet.next()) {

                    System.out.println("xxx");


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return items;
        }


    public Item loadItemById(int id) {
        System.out.println("Načtení položky " + id);
    Item item = new Item();
        try (

    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item", "root", "Tisnov1/"); ) {
        String prikaz = "SELECT * FROM item WHERE id = " + id;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(prikaz);

        while(resultSet.next()) {
            this.setId(resultSet.getInt("id"));
            this.setPartNo(resultSet.getString("partNo"));
            this.setSerialNo(resultSet.getString("serialNo"));
            this.setName(resultSet.getString("name"));
            this.setDescription(resultSet.getString("description"));
            this.setNumberInStock(resultSet.getInt("numberInStock"));
            this.setPrice(resultSet.getBigDecimal("price"));
            System.out.println("cena " + this.price);


        }
    } catch (Exception e) {
        e.printStackTrace();
    }

        return item;
}
    public void deleteAllOutOfStockItems(){
        System.out.println("xxx");
    }



    /**
     * This method saves the given item
     * @param item - item to be saved
     */
    public void saveItem(Item item) {
        System.out.println("xxx");
    }

    /**
     * This method updates a price of an item
     * @param id - id of an item which price is to be updated
     * @param newPrice - new price
     */
    public void updatePrice(Integer id, BigDecimal newPrice){
        System.out.println("xxx");
    }



    static public void test (ResultSet resultSet) throws SQLException {
        Item item = new Item();
        item.setId(resultSet.getInt("id"));
        System.out.println("Zpracovávám id: " + item.getId());
        item.setPartNo(resultSet.getString("partNo"));
        item.setSerialNo(resultSet.getString("serialNo"));
        item.setName(resultSet.getString("name"));
        item.setDescription(resultSet.getString("description"));
        item.setNumberInStock(resultSet.getInt("numberInStock"));
        item.setPrice(resultSet.getBigDecimal("price"));

    }



}
