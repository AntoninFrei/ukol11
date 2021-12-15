import com.engeto.ukol11.Item;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        System.out.println("xxx");

        try (
                //Connection connection = DriverManager.getConnection("jdbc:mysql://loacalhost:3306/lekce11", "root", "Tisnov1/" );) {
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item", "root", "Tisnov1/"); ) {
            //String prikaz = "INSERT INTO item (id, partNo, serialNo, name, description, numberInStock, price) VALUES " +
            //        "(9, \"XL-1586\", \"X-1555\", \"XL\" \"XL neco\", 0, 50.95);";
            String prikaz = "DELETE FROM item";

            Statement statement = connection.createStatement();
            statement.executeUpdate(prikaz);
            prikaz = "INSERT INTO item (id, partNo, serialNO, name, description, numberInStock, price) VALUES " +
                    "(1, 'XL1', 'serie1', 'name-XL1', 'description XL1', 10, 150.95);";
            statement.executeUpdate(prikaz);
            prikaz = "INSERT INTO item (id, partNo, serialNO, name, description, numberInStock, price) VALUES " +
                    "(2, 'XL2', 'serie2', 'name-XL2', 'description XL2', 0, 250.95);";
            statement.executeUpdate(prikaz);
            prikaz = "INSERT INTO item (id, partNo, serialNO, name, description, numberInStock, price) VALUES " +
                    "(3, 'XL3', 'serie3', 'name-XL3', 'description XL3', 20, 350.95);";
            statement.executeUpdate(prikaz);
            prikaz = "INSERT INTO item (id, partNo, serialNO, name, description, numberInStock, price) VALUES " +
                    "(4, 'XL4', 'serie4', 'name-XL4', 'description XL4', 0, 450.95);";
            statement.executeUpdate(prikaz);
            prikaz = "INSERT INTO item (id, partNo, serialNO, name, description, numberInStock, price) VALUES " +
                    "(5, 'XL5', 'serie5', 'name-XL5', 'description XL5', 100, 550.95);";
            statement.executeUpdate(prikaz);
            //ResultSet resultSet = statement.executeQuery(prikaz);
            //while(resultSet.next()) {
            //    System.out.println("ID: " + resultSet.getInt("id") + ", price: " + resultSet.getBigDecimal("price"));
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }
        BigDecimal newPrice = new BigDecimal(152.5);
        updatePrice(4, newPrice);

        printOutOfStockItems();
        printOnfStockItems();
        deleteAllOutOfStockItems();
        System.out.println("xxx");
        try (
                //Connection connection = DriverManager.getConnection("jdbc:mysql://loacalhost:3306/lekce11", "root", "Tisnov1/" );) {
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item", "root", "Tisnov1/"); ) {
            String prikaz = "SELECT * FROM item";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(prikaz);
            while(resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id")
                        + ", cena: " + resultSet.getBigDecimal("price")
                        + ", skladem: " + resultSet.getInt("numberInStock"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    Item getId(int id) {
        System.out.println("xxx");
        Item item = new Item();
        return item;
    }

    static
    void updatePrice(Integer id, BigDecimal newPrice) {
        try (

                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item",
                        "root", "Tisnov1/"); ) {
            String prikaz = "UPDATE item SET price = " + newPrice + " WHERE id = " + id + ";";
            Statement statement = connection.createStatement();
            statement.executeUpdate(prikaz);
        } catch (Exception e) {
            e.printStackTrace();
        }

    };

    static
    void deleteAllOutOfStockItems() {
        try (

                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item",
                        "root", "Tisnov1/"); ) {
            String prikaz = "DELETE FROM item WHERE numberInStock = 0;";
            Statement statement = connection.createStatement();
            statement.executeUpdate(prikaz);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    static void printOutOfStockItems() {
        try (
                //Connection connection = DriverManager.getConnection("jdbc:mysql://loacalhost:3306/lekce11", "root", "Tisnov1/" );) {
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item", "root", "Tisnov1/"); ) {
            String prikaz = "SELECT * FROM item WHERE numberInStock = 0";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(prikaz);
            System.out.println("Nulové položky:");
            while(resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id")
                        + ", cena: " + resultSet.getBigDecimal("price")
                        + ", skladem: " + resultSet.getInt("numberInStock"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void printOnfStockItems() {
        try (
                //Connection connection = DriverManager.getConnection("jdbc:mysql://loacalhost:3306/lekce11", "root", "Tisnov1/" );) {
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item", "root", "Tisnov1/"); ) {
            String prikaz = "SELECT * FROM item WHERE numberInStock > 0";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(prikaz);
            System.out.println("Nenulové položky:");
            while(resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id")
                        + ", cena: " + resultSet.getBigDecimal("price")
                        + ", skladem: " + resultSet.getInt("numberInStock"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
