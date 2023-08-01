package com.savemysaving.repo;

import com.savemysaving.model.Customer;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerRepo {
    Connection connection;
    Scanner scanner = new Scanner(System.in);
    public CustomerRepo(Connection connection) {
        this.connection = connection;
    }

    public List<Customer> getAllCustomer() throws SQLException {
        Statement statement = connection.createStatement();
        String qry = "SELECT * FROM customer";

        List <Customer> arrCustomer = new ArrayList<>();

        ResultSet result = statement.executeQuery(qry);
        while(result.next()){
            Integer id = result.getInt("id");
            Integer user_id = result.getInt("user_id");
            String email = result.getString("email");
            String name = result.getString("name");
            String phone = result.getString("phone");
            String gender = result.getString("gender");
            Date created_at = result.getDate("created_at");
            Date updated_at = result.getDate("updated_at");
            arrCustomer.add(new Customer(id, user_id, email, name, phone, gender, created_at, updated_at));

        }
        statement.close();
        return arrCustomer;
    }

    public List<Customer> getCustomerById() throws SQLException {
        System.out.print("Insert Customer Id: ");
        Integer customerId = scanner.nextInt();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE id=?");
        List <Customer> arrCustomer = new ArrayList<>();
        preparedStatement.setInt(1, customerId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            Integer id = resultSet.getInt("id");
            Integer user_id = resultSet.getInt("user_id");
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");
            String phone = resultSet.getString("phone");
            String gender = resultSet.getString("gender");
            Date created_at = resultSet.getDate("created_at");
            Date updated_at = resultSet.getDate("updated_at");
            arrCustomer.add(new Customer(id, user_id, email, name, phone, gender, created_at, updated_at));
        }
        preparedStatement.close();
        return arrCustomer;
        }

        public void insertCustomer() throws SQLException {
            System.out.print("Email :");
            String email = scanner.nextLine();
            System.out.print("Name :");
            String name = scanner.nextLine();
            System.out.print("Phone Number :");
            String phone= scanner.nextLine();
            System.out.print("Gender (F/M)");
            String gender=scanner.nextLine();
            LocalDate created_at  = LocalDate.now();
            LocalDate updated_at = LocalDate.now();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customer (email, name, phone, gender, created_at, updated_at) VALUES (?,?,?,?,?,?) ");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, gender);
            preparedStatement.setDate(5, Date.valueOf(created_at));
            preparedStatement.setDate(6, Date.valueOf(updated_at));

        }

    public void updateCustomer() throws SQLException {
        System.out.print("Your Id");
        Integer id = scanner.nextInt();
        System.out.print("Email :");
        String email = scanner.nextLine();
        System.out.print("Name :");
        String name = scanner.nextLine();
        System.out.print("Phone Number :");
        String phone= scanner.nextLine();
        System.out.print("Gender (F/M)");
        String gender=scanner.nextLine();
        LocalDate updated_at  = LocalDate.now();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customer SET email=?, name=?, phone=?,gender=?, updated_at=? WHERE id=?");
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, phone);
        preparedStatement.setString(4, gender);
        preparedStatement.setDate(5, Date.valueOf(updated_at));
        preparedStatement.setInt(6, id);

    }

        public void deleteCustomer() throws SQLException {
            System.out.print("Insert Customer Id: ");
            Integer id = scanner.nextInt();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE id=?");
            preparedStatement.setInt(1, id);
        }

    }
