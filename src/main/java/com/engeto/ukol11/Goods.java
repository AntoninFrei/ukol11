package com.engeto.ukol11;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Goods implements GoodsMethods  {
    @Override
    public Item loadItemById(Integer id) {
        System.out.println("Načtení položky " + id);
        Item item = new Item();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item", "root", "Tisnov1/"); ) {
            Statement statement = connection.createStatement();

            String prikaz = "SELECT * FROM item WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(prikaz);
            while(resultSet.next()) {
                item.setFromDB(resultSet);
                System.out.println("cena " + item.getPrice());


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void deleteAllOutOfStockItems() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item",
                        "root", "Tisnov1/"); ) {
            Statement statement = connection.createStatement();
            String prikaz = "DELETE FROM item WHERE numberInStock = 0;";
            statement.executeUpdate(prikaz);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Item> loadAllAvailableItems() {
        List items = new ArrayList();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item", "root", "Tisnov1/"); ) {
            Statement statement = connection.createStatement();
            String prikaz = "SELECT * FROM item WHERE numberInStock > 0";
            ResultSet resultSet = statement.executeQuery(prikaz);

            while(resultSet.next()) {
                Item item = new Item();
                item.setFromDB(resultSet);
                items.add(item);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public void saveItem(Item item) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item",
                "root", "Tisnov1/"); ) {
            String prikaz = "INSERT INTO item (id, partNo, serialNO, name, description, numberInStock, price) VALUES " +
                    "(" + item.getId()
                    + ", '" + item.getPartNo()
                    + "', '" + item.getSerialNo()
                    + "', '" + item.getName()
                    + "', '" + item.getDescription()
                    + "', "  + item.getNumberInStock()
                    + ", " + item.getPrice() + ");";
            Statement statement = connection.createStatement();
            statement.executeUpdate(prikaz);
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    static public Statement setConnection() throws Exception {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item", "root", "Tisnov1/");) {
            return  connection.createStatement();

        }

    }

}
