package com.savemysaving.repo;

import com.savemysaving.config.ConnectDb;
import com.savemysaving.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRepo {
    Connection connection;
    Scanner scanner = new Scanner(System.in);
    public UserRepo(Connection connection) {
        this.connection = connection;
    }
    public List<User> getAllUser() throws SQLException {
        Statement statement = connection.createStatement();
        String qry = "SELECT * FROM user_cred";

        List <User> arrUser = new ArrayList<>();

        ResultSet result = statement.executeQuery(qry);
        while(result.next()){
            Integer id = result.getInt("id");
            String userName = result.getString("username");
            String userPassword = result.getString("password");
            arrUser.add(new User(id, userName, userPassword));

        }
        statement.close();
        return arrUser;
    }

    public List<User> getUserById() throws SQLException {
        System.out.print("Insert User Id: ");
        Integer userId = scanner.nextInt();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user_cred WHERE id=?");
        List <User> arrUser = new ArrayList<>();
        preparedStatement.setInt(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            Integer id = resultSet.getInt("id");
            String userName = resultSet.getString("username");
            String userPassword = resultSet.getString("password");
            arrUser.add(new User(id, userName, userPassword));
        }
        preparedStatement.close();
        return arrUser;
        }

        public void insertUser() throws SQLException {
            System.out.print("username :");
            String username = scanner.nextLine();
            System.out.print("password :");
            String password = scanner.nextLine();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user_cred (username, password) VALUES (?,?) ");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

        }

    public void updateUser() throws SQLException {
        System.out.print("Id :");
        Integer usrId = scanner.nextInt();
        System.out.print("username :");
        String username = scanner.nextLine();
        System.out.print("password :");
        String password = scanner.nextLine();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user_cred SET username=?, password=? WHERE id=?");
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        preparedStatement.setInt(3, usrId);

    }

        public void deleteUser() throws SQLException {
            System.out.print("Insert User Id: ");
            Integer userId = scanner.nextInt();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user_cred WHERE id=?");
            preparedStatement.setInt(1, userId);
        }

    }
