package com.HRIS;

import org.springframework.boot.SpringApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;

public class Employee {

    //employee table
    private ArrayList<Integer> empId = new ArrayList<Integer>();
    private ArrayList<String> firstName = new ArrayList<String>();
    private ArrayList<String> lastName = new ArrayList<String>();
    private ArrayList<String> email = new ArrayList<String>();
    private ArrayList<String> dateOfBirth = new ArrayList<String>();
    private ArrayList<String> role = new ArrayList<String>();
    private ArrayList<String> address = new ArrayList<String>();
    private ArrayList<String> state= new ArrayList<String>();
    private ArrayList<Boolean> inTraining = new ArrayList<Boolean>();
    private ArrayList<Integer> performace = new ArrayList<Integer>();

    //allowed_health_levels table
    private ArrayList<Integer> healthLevels = new ArrayList<Integer>();
    private ArrayList<Double> healthInsuranceCost = new ArrayList<Double>();
    private ArrayList<String> providerName = new ArrayList<String>();

    //allowed_performance_values table
    private ArrayList<Integer> performaceRank = new ArrayList<Integer>();

    //allowed_company_levels table
    private ArrayList<Integer> companyLevels = new ArrayList<Integer>();

    //payroll table
    private ArrayList<Integer> payrollEmpId = new ArrayList<Integer>();
    private ArrayList<Double> salary = new ArrayList<Double>();
    private ArrayList<Double> updatedSalary = new ArrayList<>();
    //benefits table
    private ArrayList<Integer> benefitsEmpId = new ArrayList<Integer>();
    private ArrayList<Integer> vacationLeave  = new ArrayList<Integer>();
    private ArrayList<Integer> sickLeave  = new ArrayList<Integer>();
    private ArrayList<Integer> paidLeave  = new ArrayList<Integer>();
    private ArrayList<Integer> healthInsurance  = new ArrayList<Integer>();

    public static void main(String[] args) {
    }

    public void readPayroll(ResultSet resultSet) throws SQLException {
        //grab emp_id and salary columns from payroll table, adds them to their respective arraylists
        while (resultSet.next()){
            payrollEmpId.add(resultSet.getInt("emp_id"));
            salary.add(resultSet.getDouble("salary"));

        }

    }
    public void readEmployee(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            empId.add(resultSet.getInt("emp_id"));
            firstName.add(resultSet.getString("first_name"));
            lastName.add(resultSet.getString("last_name"));
            email.add(resultSet.getString("email"));
            dateOfBirth.add(resultSet.getString("date_of_birth"));
            role.add(resultSet.getString("role"));
            address.add(resultSet.getString("state"));
            state.add(resultSet.getString("state"));
            inTraining.add(resultSet.getBoolean("in_training"));
            performace.add(resultSet.getInt("performance"));
        }

    }
    public void readBenefits(ResultSet resultSet) throws SQLException {
        while(resultSet.next()) {
            benefitsEmpId.add(resultSet.getInt("emp_id"));
            vacationLeave.add(resultSet.getInt("vacation_leave"));
            sickLeave.add(resultSet.getInt("sick_leave"));
            paidLeave.add(resultSet.getInt("paid_leave"));
            healthInsurance.add(resultSet.getInt("health_insurance"));
        }
    }

    public void readPerformanceValues(ResultSet resultSet) throws SQLException {
        while(resultSet.next()) {
            performaceRank.add(resultSet.getInt("performance_rank"));
        }
    }

    public void readCompanyLevels(ResultSet resultSet) throws SQLException {
        while(resultSet.next()) {
            companyLevels.add(resultSet.getInt("company_levels"));
        }
    }
    public void readHealthLevels(ResultSet resultSet) throws SQLException {
        while(resultSet.next()) {
            // ! update when sql names are changed or table is updated in actual database.
            healthLevels.add(resultSet.getInt("health_levels"));
            //healthInsuranceCost.add(resultSet.getDouble("insurance_copay"));

        }
    }

    // ! Uncommented when SQL columns are added
    /* public void computeSalary() {
        // Calculates the correct salary by subtracting the cost of health insurance from it.
        try {
            for (int salaryLoop = 0; salaryLoop < salary.size(); salaryLoop++) {
                double calculatedSalary = salary.get(salaryLoop) - healthInsuranceCost.get(salaryLoop);
                updatedSalary.add(calculatedSalary);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("ERROR! Salary column and health insurance cost column have two different sizes");
            }
    }
     */
}
