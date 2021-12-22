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

        List items = new ArrayList();
        items = good.loadAllAvailableItems();


        BigDecimal newPrice = new BigDecimal(1052.5);
        good.updatePrice(3, newPrice);



        good.deleteAllOutOfStockItems();


        Item item = new Item();
        item = good.loadItemById(3);

        System.out.println("Vrácená položka:\n" + item.totalDescrition());


        item.setId(6);
        item.setPartNo("XXL");
        item.setSerialNo("XXL-1");
        item.setName("Nove zbozi");
        item.setDescription("popis noveho zbozi");
        item.setNumberInStock(1500);
        item.setPrice(new BigDecimal(1490));

        good.saveItem(item);

        Item itemBack = good.loadItemById(6);
        System.out.println("Vrácená položka:\n" + itemBack.totalDescrition());

        itemBack = good.loadItemById(3);
        System.out.println("Vrácená položka:\n" + itemBack.totalDescrition());





    }









}
