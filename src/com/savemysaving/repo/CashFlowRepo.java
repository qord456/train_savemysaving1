package com.savemysaving.repo;

import com.savemysaving.model.CashFLow;
import com.savemysaving.model.Customer;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CashFlowRepo {
    Connection connection;
    Scanner scanner = new Scanner(System.in);
    public CashFlowRepo(Connection connection) {
        this.connection = connection;
    }

    public List<CashFLow> getAllCashFlow() throws SQLException {
        Statement statement = connection.createStatement();
        String qry = "SELECT * FROM money_flow";

        List <CashFLow> arrCashFlow = new ArrayList<>();

        ResultSet result = statement.executeQuery(qry);
        while(result.next()){
            Integer id = result.getInt("id");
            Integer customer_id = result.getInt("customer_id");
            Integer save = result.getInt("save");
            String category = result.getString("category");
            String detail = result.getString("detail");
            Date date = result.getDate("date");
            Date created_at = result.getDate("created_at");
            Date updated_at = result.getDate("updated_at");
            arrCashFlow.add(new CashFLow(id, customer_id, save, category, detail, date, created_at, updated_at));

        }
        statement.close();
        return arrCashFlow;
    }

    public List<CashFLow> getCashFlowByCustomerId() throws SQLException {
        System.out.print("Insert Customer Id: ");
        Integer customerId = scanner.nextInt();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM money_flow WHERE id=?");
        List <CashFLow> arrCashFlow = new ArrayList<>();
        preparedStatement.setInt(1, customerId);
        ResultSet result = preparedStatement.executeQuery();
        while(result.next()){
            Integer id = result.getInt("id");
            Integer customer_id = result.getInt("customer_id");
            Integer save = result.getInt("save");
            String category = result.getString("category");
            String detail = result.getString("detail");
            Date date = result.getDate("date");
            Date created_at = result.getDate("created_at");
            Date updated_at = result.getDate("updated_at");
            arrCashFlow.add(new CashFLow(id, customer_id, save, category, detail, date, created_at, updated_at));
        }
        preparedStatement.close();
        return arrCashFlow;
    }

    public List<CashFLow> getTotalCash() throws SQLException {
        System.out.print("Insert Customer Id: ");
        Integer customerId = scanner.nextInt();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM money_flow WHERE id=?");
        List <CashFLow> arrCashFlow = new ArrayList<>();
        preparedStatement.setInt(1, customerId);
        ResultSet result = preparedStatement.executeQuery();
        while(result.next()){
            Integer customer_id = result.getInt("customer_id");
            Integer save = result.getInt("save");
            arrCashFlow.add(new CashFLow(null, customer_id, save, null, null, null, null, null));
        }
        preparedStatement.close();
        return arrCashFlow;
    }

    public void insertIncrease() throws SQLException {
        System.out.print("Customer_id :");
        String customer_id = scanner.nextLine();
        System.out.print("Total Saving :");
        String save = scanner.nextLine();
        System.out.print("Category :");
        String category= scanner.nextLine();
        System.out.print("Detail");
        String detail=scanner.nextLine();
        System.out.print("Saving Date: ");
        Date date = Date.valueOf(scanner.nextLine());
        LocalDate created_at  = LocalDate.now();
        LocalDate updated_at = LocalDate.now();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customer (custome_id,save,category, detail, date, created_at, updated_at) VALUES (?,?,?,?,?,?,?) ");
        preparedStatement.setString(1, customer_id);
        preparedStatement.setString(2, save);
        preparedStatement.setString(3, category);
        preparedStatement.setString(4, detail);
        preparedStatement.setString(5, String.valueOf(date));
        preparedStatement.setDate(6, Date.valueOf(created_at));
        preparedStatement.setDate(7, Date.valueOf(updated_at));

    }

    public void insertDecrase() throws SQLException {
        System.out.print("Customer_id :");
        String customer_id = scanner.nextLine();
        System.out.print("Total Saving :");
        String save = scanner.nextLine();
        System.out.print("Category :");
        String category= scanner.nextLine();
        System.out.print("Detail");
        String detail=scanner.nextLine();
        System.out.print("Saving Date: ");
        Date date = Date.valueOf(scanner.nextLine());
        LocalDate created_at  = LocalDate.now();
        LocalDate updated_at = LocalDate.now();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customer (custome_id,save*(-1),category, detail, date, created_at, updated_at) VALUES (?,?,?,?,?,?,?) ");
        preparedStatement.setString(1, customer_id);
        preparedStatement.setString(2, save);
        preparedStatement.setString(3, category);
        preparedStatement.setString(4, detail);
        preparedStatement.setString(5, String.valueOf(date));
        preparedStatement.setDate(6, Date.valueOf(created_at));
        preparedStatement.setDate(7, Date.valueOf(updated_at));

    }


}
