package com.engeto.ukol11;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public class Goods implements GoodsMethods  {
    @Override
    public Item loadItemById(Integer id) {
        return null;
    }

    @Override
    public void deleteAllOutOfStockItems() {

    }

    @Override
    public List<Item> loadAllAvailableItems() {
        return null;
    }

    @Override
    public void saveItem(Item item) {

    }

    @Override
    public void updatePrice(Integer id, BigDecimal newPrice) {
        try (

                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item",
                        "root", "Tisnov1/"); ) {
            String prikaz = "UPDATE item SET price = " + newPrice + " WHERE id = " + id + ";";
            Statement statement = connection.createStatement();
            statement.executeUpdate(prikaz);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
