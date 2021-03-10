package com.uniyaz.dao;

import com.uniyaz.db.DbOperations;
import com.uniyaz.domain.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    static final String driverName="com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/vaadinJDBC?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    static final String userName="root";
    static final String password="12345";

    public void addCategory(String categoryName) {
        try {
            connection = DbOperations.getConnection();
            String sql = "Insert into Category(categoryName) values(?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, categoryName);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Category> findAllCategory() {
        List<Category> categoryList = new ArrayList<>();
        String sql = "select * from category";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection conn = DriverManager.getConnection(url, userName, password);
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("categoryName");

                Category category = new Category();
                category.setId(id);
                category.setCategoryName(name);
                categoryList.add(category);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoryList;


        //        List<Category> categoryList = new ArrayList<>();
//        try {
//            connection = DbOperations.getConnection();
//            String sql = "select * from category";
//            ResultSet resultSet = preparedStatement.executeQuery(sql);
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("categoryName");
//
//                Category category = new Category();
//                category.setId(id);
//                category.setCategoryName(name);
//                categoryList.add(category);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException exception) {
//            exception.printStackTrace();
//        }
//        return categoryList;
//    }
    }


    public void deleteCategory(int id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "DELETE FROM Category WHERE id ="+id;
        sql = String.format(sql, id);

        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/vaadinJDBC?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "12345");
                PreparedStatement preparedStatement = con.prepareStatement(sql);
        )
        {
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}

//    public List<Category> kategoriGetir()
//    {
//
//        List<Category> rehberList = new ArrayList<>();
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        String sql = "SELECT * FROM Category";
//
//        try (
//                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaadinJDBC?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false", "root", "12345");
//                PreparedStatement preparedStatement = con.prepareStatement(sql);
//        ) {
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                //   int id = resultSet.getInt(1);
//                String isim = resultSet.getString("categoryName");
//                Category rehber = new Category(isim);
//                rehberList.add(rehber);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return rehberList;
//    }
//}