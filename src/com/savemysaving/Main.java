package com.savemysaving;

import com.savemysaving.config.ConnectDb;
import com.savemysaving.model.CashFLow;
import com.savemysaving.model.Customer;
import com.savemysaving.model.User;
import com.savemysaving.repo.CashFlowRepo;
import com.savemysaving.repo.CustomerRepo;
import com.savemysaving.repo.UserRepo;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Menu\n1. User\n2. Customer\n3. Cash Flow\n Choose one on above: ");
        Integer input = scanner.nextInt();
        if (input == 1){
            userFunc();
        } else if (input == 2) {
            customerFunc();
        } else if (input ==3) {
            cashFlow();
        } else {
            System.out.println("Mohon masukan angka sesuai menu");
        }
    }


    public static void userFunc() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        ConnectDb connectDb = new ConnectDb();
        Connection connection = connectDb.startConnect();
        UserRepo userRepo = new UserRepo(connection);
        System.out.print("USER MENU\n1. View All\n2. View By Id\n3. Add\n4. Update\n5. Delete\nChoose a menu : ");
        Integer input = scanner.nextInt();


        if (input == 1) {

            List<User> result = userRepo.getAllUser();
            for (User r : result){
                System.out.println(r);
            }
        } else if (input == 2) {
            List<User> result = userRepo.getUserById();
            for (User r : result){
                System.out.println(r);
            }
        } else if (input == 3) {
            userRepo.insertUser();

        } else if (input == 4) {
            userRepo.updateUser();

        } else if (input == 5) {
            userRepo.deleteUser();
        } else {
            System.out.println("Mohon masukan angka yang sesuai dengan menu");
        }
    }
    public static void customerFunc() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        ConnectDb connectDb = new ConnectDb();
        Connection connection = connectDb.startConnect();
        CustomerRepo customerRepo = new CustomerRepo(connection);
        System.out.print("CUSTOMER MENU\n1. View All\n2. View By Id\n3. Add\n4. Update\n5. Delete\nChoose a menu : ");
        Integer input = scanner.nextInt();

        if (input == 1) {
            List<Customer> result = customerRepo.getAllCustomer();
            for (Customer r : result){
                System.out.println(r);
            }
        } else if (input == 2) {
            List<Customer> result = customerRepo.getCustomerById();
            for (Customer r : result){
                System.out.println(r);
            }
        } else if (input == 3) {
            customerRepo.insertCustomer();
        } else if (input == 4) {
            customerRepo.updateCustomer();
        } else if (input == 5) {
            customerRepo.deleteCustomer();
        } else {
            System.out.println("Mohon masukan angka yang sesuai dengan menu");
        }
    }

    public static void cashFlow() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        ConnectDb connectDb = new ConnectDb();
        Connection connection = connectDb.startConnect();
        CashFlowRepo cashFlowRepo = new CashFlowRepo(connection);
        System.out.print("CASHFLOW MENU\n1. View All\n2. View By Customer ID\n3. View Total Cash\n4. Add Saving\n5. Descrease Saving\nChoose a menu : ");
        Integer input = scanner.nextInt();

        if (input == 1) {
            List<CashFLow> result = cashFlowRepo.getAllCashFlow();
            for (CashFLow r : result){
                System.out.println(r);
            }
        } else if (input == 2) {
            List<CashFLow> result = cashFlowRepo.getCashFlowByCustomerId();
            for (CashFLow r : result){
                System.out.println(r);
            }
        } else if (input == 3) {
            List<CashFLow> result = cashFlowRepo.getTotalCash();
            for (CashFLow r : result){
                System.out.println(r);
            }
        } else if (input == 4) {
            cashFlowRepo.insertIncrease();
        } else if (input == 5) {
            cashFlowRepo.insertDecrase();
        } else {
            System.out.println("Mohon masukan angka yang sesuai dengan menu");
        }
    }
}


