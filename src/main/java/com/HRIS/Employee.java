package com.HRIS;

import org.springframework.data.relational.core.sql.In;

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
    private ArrayList<Integer> inTraining = new ArrayList<Integer>();
    private ArrayList<Integer> performance = new ArrayList<Integer>();

    //allowed_health_levels table
    private ArrayList<Integer> healthLevels = new ArrayList<Integer>();
    private ArrayList<Double> healthInsuranceCost = new ArrayList<Double>();
    private ArrayList<String> providerName = new ArrayList<String>();

    //allowed_performance_values table
    private ArrayList<Integer> performanceRank = new ArrayList<Integer>();

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
            inTraining.add(resultSet.getInt("in_training"));
            performance.add(resultSet.getInt("performance"));
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
            performanceRank.add(resultSet.getInt("performance_rank"));
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

    //checks emp_id list for given id, returns index of id in the ArrayList, returns -1 if not found
    public int getIndexOfEmpID(int idToCheck){
        return this.empId.indexOf(idToCheck);
    }

    //getters
    //employee table getters
    //gets entire emp_id list
    public ArrayList<Integer> getEmpID() {
        return empId;
    }

    //gets single element from emp_id based on given empID's index
    public int getEmpID(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.empId.get(index);
    }

    //gets entire first_name list
    public ArrayList<String> getFirstName() {
        return firstName;
    }

    //gets single element from first_name based on given empID's index
    public String getFirstName(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.firstName.get(index);
    }

    //gets entire last_name list
    public ArrayList<String> getLastName() {
        return lastName;
    }

    //gets single element from last_name based on given empID's index
    public String getLastName(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.lastName.get(index);
    }

    //gets entire email list
    public ArrayList<String> getEmail() {
        return email;
    }

    //gets single element from email based on given empID's index
    public String getEmail(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.email.get(index);
    }

    //gets entire date_of_birth list
    public ArrayList<String> getDateOfBirth() {
        return dateOfBirth;
    }

    //gets single element from date_of_birth based on given empID's index
    public String getDateOfBirth(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.dateOfBirth.get(index);
    }

    //gets entire role list
    public ArrayList<String> getRole() {
        return role;
    }

    //gets single element from role based on given empID's index
    public String getRole(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.role.get(index);
    }

    //gets entire address list
    public ArrayList<String> getAddress() {
        return address;
    }

    //gets single element from address based on given empID's index
    public String getAddress(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.address.get(index);
    }

    //gets entire state list
    public ArrayList<String> getState() {
        return state;
    }

    //gets single element from state based on given empID's index
    public String getState(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.state.get(index);
    }

    //gets entire in_training list
    public ArrayList<Integer> getInTraining() {
        return inTraining;
    }

    //gets single element from in_training based on given empID's index
    public int getInTraining(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.inTraining.get(index);
    }

    //gets entire performance list
    public ArrayList<Integer> getPerformance() {
        return performance;
    }

    //gets single element from performance based on given empID's index
    public int getPerformance(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.performance.get(index);
    }

    //allowed_health_levels table getters
    //gets entire health_levels list
    public ArrayList<Integer> getHealthLevels() {
        return healthLevels;
    }

    //gets entire insurance_cost list
    public ArrayList<Double> getInsuranceCost() {
        return healthInsuranceCost;
    }

    //gets entire provider_name list
    public ArrayList<String> getProviderName() {
        return providerName;
    }

    //allowed_performance_values table getters
    //gets entire performance_rank list
    public ArrayList<Integer> getPerformanceRank() {
        return performanceRank;
    }

    //allowed_company_levels table getters
    //gets entire company_levels list
    public ArrayList<Integer> getCompanyLevels() {
        return companyLevels;
    }

    //payroll table getters
    //gets entire payroll_emp_id list
    public ArrayList<Integer> getPayrollEmpID() {
        return payrollEmpId;
    }

    //gets single element from payroll_emp_id based on given empID's index
    public int getPayrollEmpID(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.payrollEmpId.get(index);
    }

    //gets entire salary list
    public ArrayList<Double> getSalary() {
        return salary;
    }

    //gets single element from salary based on given empID's index
    public double getSalary(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.salary.get(index);
    }

    //benefits table getters
    //gets entire benefits_emp_id list
    public ArrayList<Integer> getBenefitsEmpID() {
        return benefitsEmpId;
    }

    //gets single element from benefits_emp_id based on given empID's index
    public int getBenefitsEmpID(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.benefitsEmpId.get(index);
    }

    //gets entire vacation_leave list
    public ArrayList<Integer> getVacationLeave() {
        return vacationLeave;
    }

    //gets single element from vacation_leave based on given empID's index
    public int getVacationLeave(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.vacationLeave.get(index);
    }

    //gets entire sick_leave list
    public ArrayList<Integer> getSickLeave() {
        return sickLeave;
    }

    //gets single element from sick_leave based on given empID's index
    public int getSickLeave(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.sickLeave.get(index);
    }

    //gets entire paid_leave list
    public ArrayList<Integer> getPaidLeave() {
        return paidLeave;
    }

    //gets single element from paid_leave based on given empID's index
    public int getPaidLeave(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.paidLeave.get(index);
    }

    //gets entire health_insurance list
    public ArrayList<Integer> getHealthInsurance() {
        return healthInsurance;
    }

    //gets single element from health_insurance based on given empID's index
    public int getHealthInsurance(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.healthInsurance.get(index);
    }

    //setters
    //Employee View Setters
    public void setFirstName(int empID, String firstName) {
        int index = getIndexOfEmpID(empID);
        if (index == -1){
            System.out.println("Employee Not Found");
        } else {
            this.firstName.set(index, firstName);
            System.out.println("Name Change Successful");
        }
    }

    public void setLastName(int empID, String lastName) {
        int index = getIndexOfEmpID(empID);
        if (index == -1){
            System.out.println("Employee Not Found");
        } else {
            this.lastName.set(index, lastName);
            System.out.println("Name Change Successful");
        }
    }

    public void setEmail(int empID, String email) {
        int index = getIndexOfEmpID(empID);
        if (index == -1) {
            System.out.println("Employee Not Found");
        } else {
            this.email.set(index, email);
            System.out.println("Email Change Successful");
        }
    }

    public void setState(int empID, String state) {
        int index = getIndexOfEmpID(empID);
        if (index == -1){
            System.out.println("Employee Not Found");
        } else {
            this.state.set(index, state);
            System.out.println("State Change Successful");
        }
    }

    public void setAddress(int empID, String address) {
        int index = getIndexOfEmpID(empID);
        if (index == -1){
            System.out.println("Employee Not Found");
        } else {
            this.address.set(index, address);
            System.out.println("Address Change Successful");
        }
    }

    //Manager View Setters
    public void setRole(int empID, String role) {
        int index = getIndexOfEmpID(empID);
        if (index == -1){
            System.out.println("Employee Not Found");
        } else {
            this.role.set(index, role);
            System.out.println("Role Change Successful");
        }
    }

    public void setInTraining(int empID, int in_training) {
        int index = getIndexOfEmpID(empID);
        if (index == -1){
            System.out.println("Employee Not Found");
        } else {
            this.inTraining.set(index, in_training);
            System.out.println("Training Change Successful");
        }
    }

    public void setPerformance(int empID, int performance) {
        int index = getIndexOfEmpID(empID);
        if (index == -1){
            System.out.println("Employee Not Found");
        } else {
            this.performance.set(index, performance);
            System.out.println("Performance Change Successful");
        }
    }

    public void setSalary(int empID, double salary) {
        int index = getIndexOfEmpID(empID);
        if (index == -1){
            System.out.println("Employee Not Found");
        } else {
            this.salary.set(index, salary);
            System.out.println("Salary Change Successful");
        }
    }

    public void setVacationLeave(int empID, int vacationLeave) {
        int index = getIndexOfEmpID(empID);
        if (index == -1){
            System.out.println("Employee Not Found");
        } else {
            this.vacationLeave.set(index, vacationLeave);
            System.out.println("Vacation Leave Change Successful");
        }
    }

    public void setSickLeave(int empID, int sickLeave) {
        int index = getIndexOfEmpID(empID);
        if (index == -1){
            System.out.println("Employee Not Found");
        } else {
            this.sickLeave.set(index, sickLeave);
            System.out.println("Sick Leave Change Successful");
        }
    }

    public void setPaidLeave(int empID, int paidLeave) {
        int index = getIndexOfEmpID(empID);
        if (index == -1){
            System.out.println("Employee Not Found");
        } else {
            this.paidLeave.set(index, paidLeave);
            System.out.println("Paid Leave Change Successful");
        }
    }

    //Returns the data for a single employee based on the given employee ID
    public String getSingleEmployee(int empID) {
        String finalString = "";
        int index = getIndexOfEmpID(empID);
        if (index == -1){
            finalString = "Employee Not Found!";
        } else {
            finalString = "Employee ID: " + empId.get(index) + "\n";
            finalString += "Name: " + firstName.get(index) + " " + lastName.get(index) + "\n";
            finalString += "Role: " + role.get(index) + "\n";
            finalString += "Email: " + email.get(index) + "\n";
            finalString += "Performance: " + performance.get(index) + "\n";
            if (inTraining.get(index) == 1) {
                finalString += "Currently in Training: Yes";
            } else {
                finalString += "Currently in Training: No";
            }
        }

        return finalString;
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
