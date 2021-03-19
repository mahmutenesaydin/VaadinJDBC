 package com.uniyaz.dao;

import com.uniyaz.db.DbOperations;
import com.uniyaz.domain.Category;
import com.uniyaz.domain.Icerik;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IcerikDao
{
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resultSet = null;

    static final String driverName = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/vaadinJDBC?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    static final String userName = "root";
    static final String password = "12345";

    public void addIcerik(Icerik icerik) {
        try {
            connection = DbOperations.getConnection();
            String sql = "Insert into Icerik(ICERIK_BASLIK, DETAY, CATEGORY_ID) values(?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, icerik.getBaslik());
            preparedStatement.setString(2, icerik.getDetay());
            preparedStatement.setInt(3, icerik.getCategoryID());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateIcerik(Icerik icerik) {
        try {
            connection = DbOperations.getConnection();
            String sql = "UPDATE ICERIK SET ICERIK_BASLIK = ?, DETAY = ?, CATEGORY_ID = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, icerik.getBaslik());
            preparedStatement.setString(2, icerik.getDetay());
            preparedStatement.setInt(3, icerik.getCategoryID());
            preparedStatement.setInt(4,icerik.getId());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteIcerik(Icerik icerik) {
        try {
//            connection = DbOperations.getConnection();
//            String sql = "DELETE FROM ICERIK WHERE ID= ?";
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, String.valueOf(icerik.getId()));
//            preparedStatement.execute();


            Statement statement = connection.createStatement();
            String sql = "Delete from ICERIK where id = " + icerik.getId() + ";";
            statement.executeUpdate(sql);
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }

//    public List<Icerik> findAllIcerik() {
//        List<Icerik> icerikList = new ArrayList<>();
//        try {
//            connection = DbOperations.getConnection();
//            String sql = "select * from Icerik";
//            ResultSet resultSet = preparedStatement.executeQuery(sql);
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String baslik = resultSet.getString("IcerikBaslik");
//                String detay = resultSet.getString("Detay");
//                int categoryID = resultSet.getInt("CategoryID");
//
//                Icerik icerik = new Icerik();
//                icerik.setBaslik(baslik);
//                icerik.setDetay(detay);
//                icerik.setCategoryID(categoryID);
//                icerikList.add(icerik);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException exception) {
//            exception.printStackTrace();
//        }
//        return icerikList;
//    }

    public List<Icerik> listIcerik() {
        List<Icerik> icerikList = new ArrayList<Icerik>();
        try {
            connection = DbOperations.getConnection();
            String sql = "SELECT * FROM ICERIK";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                icerikList.add(new Icerik(
                        resultSet.getInt("id"),
                        resultSet.getString("ICERIK_BASLIK"),
                        resultSet.getString("DETAY"),
                        resultSet.getInt("CATEGORY_ID")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return icerikList;
    }
}

