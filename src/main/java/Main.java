import com.engeto.ukol11.Goods;
import com.engeto.ukol11.Item;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("xxx");

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item", "root", "Tisnov1/"); ) {

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

        } catch (Exception e) {
            e.printStackTrace();
        }
        Goods good = new Goods();
        BigDecimal newPrice = new BigDecimal(1052.5);
        good.updatePrice(4, newPrice);


        List items = new ArrayList();
        items = good.loadAllAvailableItems();
        printOutOfStockItems();
        printOnfStockItems();
        good.deleteAllOutOfStockItems();
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
        //Item item = getItem(1);
        Item item2 = new Item();
        item2.loadItemById(3);




    }

//    static Item getItem(int id) {
//        System.out.println("Načtení položky " + id);
//
//        Item item = new Item();
//        try (
//
//                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item", "root", "Tisnov1/"); ) {
//            String prikaz = "SELECT * FROM item WHERE id = " + id;
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(prikaz);
//
//            while(resultSet.next()) {
//                item.setId(resultSet.getInt("id"));
//                item.setPartNo(resultSet.getString("partNo"));
//                item.setSerialNo(resultSet.getString("serialNo"));
//                item.setName(resultSet.getString("name"));
//                item.setDescription(resultSet.getString("description"));
//                item.setNumberInStock(resultSet.getInt("numberInStock"));
//                item.setPrice(resultSet.getBigDecimal("price"));
//                System.out.println("xxx");
//
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return item;
//    }



//    static void updatePrice(Integer id, BigDecimal newPrice) {
//        try (
//
//                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item",
//                        "root", "Tisnov1/"); ) {
//            String prikaz = "UPDATE item SET price = " + newPrice + " WHERE id = " + id + ";";
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(prikaz);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    };

//    static
//    void deleteAllOutOfStockItems() {
//        try (
//
//                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item",
//                        "root", "Tisnov1/"); ) {
//            String prikaz = "DELETE FROM item WHERE numberInStock = 0;";
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(prikaz);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }


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

//    static List<Item> loadAllAvailableItems() {
//     List items = new ArrayList();
//        try (
//
//                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item", "root", "Tisnov1/"); ) {
//            String prikaz = "SELECT * FROM item WHERE numberInStock > 0";
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(prikaz);
//
//            while(resultSet.next()) {
//                Item item = new Item();
//                item.setId(resultSet.getInt("id"));
//                System.out.println("Zpracovávám id: " + item.getId());
//                item.setPartNo(resultSet.getString("partNo"));
//                item.setSerialNo(resultSet.getString("serialNo"));
//                item.setName(resultSet.getString("name"));
//                item.setDescription(resultSet.getString("description"));
//                item.setNumberInStock(resultSet.getInt("numberInStock"));
//                item.setPrice(resultSet.getBigDecimal("price"));
//                items.add(item);
//                System.out.println("xxx");
//
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//     return items;
//    }

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
