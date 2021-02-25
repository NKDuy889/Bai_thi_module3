package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private  String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private  String SERVER_NAME = "jdbc:mysql://localhost:6699/product";
    private  String MYSQL_ID = "root";
    private  String PASSWORD = "";

    public Connection getConnection()  {
        Connection connection = null;
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(SERVER_NAME, MYSQL_ID, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public List<Product> findAll() {
        List<Product> product = new ArrayList<>();
        ResultSet resultSet = null;
        Connection conn = getConnection();
        try (PreparedStatement preparedStatement = conn.prepareStatement("select * from products")){
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("descreption");
                String category = resultSet.getString("category");
                product.add(new Product(id, name, price, quantity, color, description, category));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return product;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        ResultSet resultSet = null;
        Connection conn = getConnection();
        try (PreparedStatement p = conn.prepareStatement("select * from products where id=?")) {
            p.setInt(1, id);
            resultSet = p.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String descreption = resultSet.getString("descreption");
                String category = resultSet.getString("category");
                product = new Product(id, name, price, quantity, color, descreption, category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return product;
    }

    @Override
    public void insert(Product product) {
        Connection conn = getConnection();
        try (PreparedStatement preparedStatement = conn.prepareStatement(
                "insert into products (name, price, quantity, color,descreption, category) values (?, ?, ?, ?,?,?)")) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescreption());
            preparedStatement.setString(6, product.getCategory());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Connection conn = getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("delete from products where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Product product) {

    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        ResultSet resultSet = null;
        Connection conn = getConnection();
        try (PreparedStatement preparedStatement = conn.prepareStatement("select * from products where name like ?")){
            name ="%" + name + "%";
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameS = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String descreption = resultSet.getString("descreption");
                String category = resultSet.getString("category");

                products.add(new Product(id, nameS, price, quantity, color,descreption, category ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return products;
    }

    @Override
    public void update(Product product) {
        Connection conn = getConnection();
        try (PreparedStatement preparedStatement = conn.prepareStatement
                ("update products set name = ?, price = ?, quantity = ?,color =? ,descreption=?, category=?  where id =?")){
            preparedStatement.setInt(7,product.getId());
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescreption());
            preparedStatement.setString(6, product.getCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
