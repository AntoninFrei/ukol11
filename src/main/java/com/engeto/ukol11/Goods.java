package com.engeto.ukol11;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Goods implements GoodsMethods  {
    @Override
    public Item loadItemById(Integer id) {
        return null;
    }

    @Override
    public void deleteAllOutOfStockItems() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item",
                        "root", "Tisnov1/"); ) {
            String prikaz = "DELETE FROM item WHERE numberInStock = 0;";
            Statement statement = connection.createStatement();
            statement.executeUpdate(prikaz);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Item> loadAllAvailableItems() {
        List items = new ArrayList();
        try (

                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item", "root", "Tisnov1/"); ) {
            String prikaz = "SELECT * FROM item WHERE numberInStock > 0";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(prikaz);

            while(resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt("id"));
                System.out.println("Zpracovávám id: " + item.getId());
                item.setPartNo(resultSet.getString("partNo"));
                item.setSerialNo(resultSet.getString("serialNo"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setNumberInStock(resultSet.getInt("numberInStock"));
                item.setPrice(resultSet.getBigDecimal("price"));
                items.add(item);
                System.out.println("xxx");


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public void saveItem(Item item) {

    }

    @Override
    public void updatePrice(Integer id, BigDecimal newPrice) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item",
                        "root", "Tisnov1/"); ) {
            String prikaz = "UPDATE item SET price = " + newPrice + " WHERE id = " + id + ";";
            Statement statement = connection.createStatement();
            statement.executeUpdate(prikaz);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
