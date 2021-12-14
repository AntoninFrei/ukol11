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
            String prikaz = "INSERT INTO item (id, price) VALUES (7, 50.95);";
            Statement statement = connection.createStatement();
            statement.executeUpdate(prikaz);
            //ResultSet resultSet = statement.executeQuery(prikaz);
            //while(resultSet.next()) {
            //    System.out.println("ID: " + resultSet.getInt("id") + ", price: " + resultSet.getBigDecimal("price"));
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("xxx");
        try (
                //Connection connection = DriverManager.getConnection("jdbc:mysql://loacalhost:3306/lekce11", "root", "Tisnov1/" );) {
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/item", "root", "Tisnov1/"); ) {
            String prikaz = "SELECT * FROM item";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(prikaz);
            while(resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", price: " + resultSet.getBigDecimal("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
