package com.HRIS;

import org.springframework.boot.SpringApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;

public class Employee {

    //employee table
    private ArrayList<Integer> emp_id = new ArrayList<Integer>();
    private ArrayList<String> first_name = new ArrayList<String>();
    private ArrayList<String> last_name = new ArrayList<String>();
    private ArrayList<String> email = new ArrayList<String>();
    private ArrayList<String> date_of_birth = new ArrayList<String>();
    private ArrayList<String> role = new ArrayList<String>();
    private ArrayList<String> address = new ArrayList<String>();
    private ArrayList<String> state= new ArrayList<String>();
    private ArrayList<Boolean> in_training = new ArrayList<Boolean>();
    private ArrayList<Integer> performace = new ArrayList<Integer>();

    //allowed_health_levels table
    //add method when columns are created
    private ArrayList<Integer> health_levels = new ArrayList<Integer>();
    private ArrayList<Double> insurance_cost = new ArrayList<Double>();
    private ArrayList<Double> provider_name = new ArrayList<Double>();

    //allowed_performance_values table
    private ArrayList<Integer> performace_rank = new ArrayList<Integer>();

    //allowed_company_levels table
    private ArrayList<Integer> company_levels = new ArrayList<Integer>();

    //payroll table
    private ArrayList<Integer> payroll_emp_id = new ArrayList<Integer>();
    private ArrayList<Double> salary = new ArrayList<Double>();

    //benefits table
    private ArrayList<Integer> benefits_emp_id = new ArrayList<Integer>();
    private ArrayList<Integer> vacation_leave  = new ArrayList<Integer>();
    private ArrayList<Integer> sick_leave  = new ArrayList<Integer>();
    private ArrayList<Integer> paid_leave  = new ArrayList<Integer>();
    private ArrayList<Integer> health_insurance  = new ArrayList<Integer>();

    public static void main(String[] args) {

    }

    public void readPayroll(ResultSet resultSet) throws SQLException {
        //grab emp_id and salary columns from payroll table, adds them to their respective arraylists
        while (resultSet.next()){
            payroll_emp_id.add(resultSet.getInt("emp_id"));
            salary.add(resultSet.getDouble("salary"));
        }
    }
    public void readEmployee(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            emp_id.add(resultSet.getInt("emp_id"));
            first_name.add(resultSet.getString("first_name"));
            last_name.add(resultSet.getString("last_name"));
            email.add(resultSet.getString("email"));
            date_of_birth.add(resultSet.getString("date_of_birth"));
            role.add(resultSet.getString("role"));
            address.add(resultSet.getString("state"));
            state.add(resultSet.getString("state"));
            in_training.add(resultSet.getBoolean("in_training"));
            performace.add(resultSet.getInt("performance"));
        }
    }
    public void readBenefits(ResultSet resultSet) throws SQLException {
        while(resultSet.next()) {
            benefits_emp_id.add(resultSet.getInt("benefits_emp_id"));
            vacation_leave.add(resultSet.getInt("vacation_leave"));
            sick_leave.add(resultSet.getInt("sick_leave"));
            paid_leave.add(resultSet.getInt("paid_leave"));
            health_insurance.add(resultSet.getInt("health_insurance"));
        }
    }

    public void readPerformanceValues(ResultSet resultSet) throws SQLException {
        while(resultSet.next()) {
            performace_rank.add(resultSet.getInt("performance_rank"));
        }
    }

    public void readCompanyLevels(ResultSet resultSet) throws SQLException {
        while(resultSet.next()) {
            company_levels.add(resultSet.getInt("company_levels"));
        }
    }

    public void computeSalary() {
        //add when tables are populated
    }
}
