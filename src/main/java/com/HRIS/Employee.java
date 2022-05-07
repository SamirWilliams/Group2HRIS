package com.HRIS;

import org.springframework.data.relational.core.sql.In;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

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
    private ArrayList<Integer> levelInCompany = new ArrayList<Integer>();
    private ArrayList<Integer> inManagement = new ArrayList<Integer>();
    private ArrayList<String> startDate = new ArrayList<String>();

    //allowed_health_levels table
    private ArrayList<Integer> healthLevels = new ArrayList<Integer>();
    private ArrayList<Double> cost = new ArrayList<Double>();


    //allowed_performance_values table
    private ArrayList<Integer> performanceRank = new ArrayList<Integer>();

    //allowed_company_levels table
    private ArrayList<Integer> companyLevels = new ArrayList<Integer>();

    //payroll table
    private ArrayList<Integer> payrollEmpId = new ArrayList<Integer>();
    private ArrayList<Double> salary = new ArrayList<Double>();
    private ArrayList<Integer> hoursWorked = new ArrayList<Integer>();
    private ArrayList<Double> rate = new ArrayList<Double>();
    private ArrayList<Double> updatedSalary = new ArrayList<Double>();

    //benefits table
    private ArrayList<Integer> benefitsEmpId = new ArrayList<Integer>();
    private ArrayList<Integer> vacationLeave  = new ArrayList<Integer>();
    private ArrayList<Integer> sickLeave  = new ArrayList<Integer>();
    private ArrayList<Integer> paidLeave  = new ArrayList<Integer>();
    private ArrayList<Integer> healthInsurance  = new ArrayList<Integer>();

    public void readPayroll(Statement statement) throws SQLException {
        // ! Passed statement instead of resultSet

        //grab emp_id and salary columns from payroll table, adds them to their respective arraylists
        ResultSet resultSetPayroll = statement.executeQuery("select * from payroll");

        while (resultSetPayroll.next()){
            payrollEmpId.add(resultSetPayroll.getInt("emp_id"));
            salary.add(resultSetPayroll.getDouble("salary"));
            hoursWorked.add(resultSetPayroll.getInt("hours_worked"));
            rate.add(resultSetPayroll.getDouble("rate"));

        }
    }

    public void clearPayroll() {
        payrollEmpId.clear();
        salary.clear();
        hoursWorked.clear();
        rate.clear();
    }

    public void readEmployee(Statement statement) throws SQLException {

        ResultSet resultSetEmployee = statement.executeQuery("select * from employee");

        while (resultSetEmployee.next()) {
            empId.add(resultSetEmployee.getInt("emp_id"));
            firstName.add(resultSetEmployee.getString("first_name"));
            lastName.add(resultSetEmployee.getString("last_name"));
            email.add(resultSetEmployee.getString("email"));
            dateOfBirth.add(resultSetEmployee.getString("date_of_birth"));
            role.add(resultSetEmployee.getString("role"));
            address.add(resultSetEmployee.getString("state"));
            state.add(resultSetEmployee.getString("state"));
            inTraining.add(resultSetEmployee.getInt("in_training"));
            performance.add(resultSetEmployee.getInt("performance"));
            levelInCompany.add(resultSetEmployee.getInt("level_in_company"));
            inManagement.add(resultSetEmployee.getInt("in_management"));
            startDate.add(resultSetEmployee.getString("start_date"));
        }

    }
    public void clearEmployees() {
        empId.clear();
        firstName.clear();
        lastName.clear();
        email.clear();
        dateOfBirth.clear();
        role.clear();
        address.clear();
        state.clear();
        inTraining.clear();
        performance.clear();
        levelInCompany.clear();
        inManagement.clear();
        startDate.clear();
    }

    public void readBenefits(Statement statement) throws SQLException {
        ResultSet resultSetBenefits = statement.executeQuery("select * from benefits");

        while(resultSetBenefits.next()) {
            benefitsEmpId.add(resultSetBenefits.getInt("emp_id"));
            vacationLeave.add(resultSetBenefits.getInt("vacation_leave"));
            sickLeave.add(resultSetBenefits.getInt("sick_leave"));
            paidLeave.add(resultSetBenefits.getInt("paid_leave"));
            healthInsurance.add(resultSetBenefits.getInt("health_insurance"));
        }
    }

    public void clearBenefits() {
        benefitsEmpId.clear();
        vacationLeave.clear();
        sickLeave.clear();
        paidLeave.clear();
        healthInsurance.clear();
    }

    public void readPerformanceValues(Statement statement) throws SQLException {
        ResultSet resultSetPerformanceVal = statement.executeQuery("select * from allowed_performance_values");

        while(resultSetPerformanceVal.next()) {
            performanceRank.add(resultSetPerformanceVal.getInt("performance_rank"));
        }
    }

    public void clearPerformanceValues() {
        performanceRank.clear();
    }

    public void readCompanyLevels(Statement statement) throws SQLException {
        ResultSet resultSetCompanyLev = statement.executeQuery("select * from allowed_company_levels");

        while(resultSetCompanyLev.next()) {
            companyLevels.add(resultSetCompanyLev.getInt("company_levels"));
        }
    }

    public void clearCompanyLevels() {
        companyLevels.clear();
    }

    public void readHealthLevels(Statement statement) throws SQLException {
        ResultSet resultSetHealthLev = statement.executeQuery("select * from allowed_health_levels");

        while(resultSetHealthLev.next()) {
            healthLevels.add(resultSetHealthLev.getInt("health_levels"));
            cost.add(resultSetHealthLev.getDouble("cost"));

        }
    }

    public void clearHealthLevels() {
        healthLevels.clear();
        cost.clear();
    }

    public void clearAll() {
        clearPayroll();
        clearEmployees();
        clearBenefits();
        clearCompanyLevels();
        clearHealthLevels();
        clearPerformanceValues();
    }

    //checks empID list for given id, returns index of id in the ArrayList, returns -1 if not found
    public int getIndexOfEmpID(int idToCheck){
        return this.empId.indexOf(idToCheck);
    }

    //getters
    //employee table getters
    //gets entire emp_id list
    public ArrayList<Integer> getEmpID() {
        return empId;
    }

    //gets single element from empID based on given empID's index
    public int getEmpID(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.empId.get(index);
    }

    //gets entire firstName list
    public ArrayList<String> getFirstName() {
        return firstName;
    }

    //gets single element from firstName based on given empID's index
    public String getFirstName(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.firstName.get(index);
    }

    //gets entire lastName list
    public ArrayList<String> getLastName() {
        return lastName;
    }

    //gets single element from lastName based on given empID's index
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

    //gets entire dateOfBirth list
    public ArrayList<String> getDateOfBirth() {
        return dateOfBirth;
    }

    //gets single element from dateOfBirth based on given empID's index
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

    //gets entire inTraining list
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

    //gets entire levelInCompany list
    public ArrayList<Integer> getLevelInCompany() {
        return levelInCompany;
    }

    //gets single element from levelinCompany based on given levelInCompany index
    public int getLevelInCompany(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.levelInCompany.get(index);
    }

    //gets entire inManagement list
    public ArrayList<Integer> getInManagement() {
        return inManagement;
    }

    //gets single element from inManagement based on given inManagement index
    public int getInManagement(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.inManagement.get(index);
    }

    //gets entire startDate list
    public ArrayList<String> getStartDate() {
        return startDate;
    }

    //gets single element from startDate based on given startDate index
    public String getStartDate(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.startDate.get(index);
    }

    //allowed_health_levels table getters
    //gets entire health_levels list
    public ArrayList<Integer> getHealthLevels() {
        return healthLevels;
    }

    //gets entire cost list
    public ArrayList<Double> getCost() {
        return cost;
    }

    //allowed_performance_values table getters
    //gets entire performanceRank list
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

    //gets single element from payrollEmpId based on given empID's index
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

    //gets entire hoursWorked list
    public ArrayList<Integer> getHoursWorked() {
        return hoursWorked;
    }

    //gets single element from hoursWorked based on given empID's index
    public double getHoursWorked(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.hoursWorked.get(index);
    }

    //gets entire rate list
    public ArrayList<Double> getRate() {
        return rate;
    }

    //gets single element from rate based on given empID's index
    public double getRate(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.rate.get(index);
    }

    //gets entire updatedSalary list
    public ArrayList<Double> getUpdatedSalary() {
        return rate;
    }

    //gets single element from updatedSalary based on given empID's index
    public double getUpdatedSalary(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.updatedSalary.get(index);
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

    //gets entire sickLeave list
    public ArrayList<Integer> getSickLeave() {
        return sickLeave;
    }

    //gets single element from sickLeave based on given empID's index
    public int getSickLeave(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.sickLeave.get(index);
    }

    //gets entire paidLeave list
    public ArrayList<Integer> getPaidLeave() {
        return paidLeave;
    }

    //gets single element from paidLeave based on given empID's index
    public int getPaidLeave(int empID) {
        int index = getIndexOfEmpID(empID);
        return this.paidLeave.get(index);
    }

    //gets entire healthInsurance list
    public ArrayList<Integer> getHealthInsurance() {
        return healthInsurance;
    }

    //gets single element from healthInsurance based on given empID's index
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

    public void setLevelInCompany(int empID, int levelInCompany) {
        int index = getIndexOfEmpID(empID);
        if (index == -1){
            System.out.println("Employee Not Found");
        } else {
            this.levelInCompany.set(index, levelInCompany);
            System.out.println("Level in Company Change Successful");
        }
    }

    public void setStartDate(int empID, String startDate) {
        int index = getIndexOfEmpID(empID);
        if (index == -1){
            System.out.println("Employee Not Found");
        } else {
            this.startDate.set(index, startDate);
            System.out.println("Start date Change Successful");
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


    public void computeSalary() {
        // Calculates the correct salary by subtracting the cost of health insurance from it.

        for (int empIdLoop = 0; empIdLoop < empId.size(); empIdLoop++) {
            double indivSalary = 0;
            double indivInsuranceCost = 0;

            // ! check if salary is not null or this could cause an error
            indivSalary = salary.get(empIdLoop);

            //Find the cost of each employees health insurance
            for(int costFinder = 0; costFinder < healthLevels.size(); costFinder++) {
                //See if there is match in of the level of health insurance in the arrays/columns
                boolean match = healthLevels.get(costFinder).equals(healthInsurance.get(empIdLoop));
                if(match) {
                    indivInsuranceCost = cost.get(costFinder);
                };
            }
            //append the updated salary
            updatedSalary.add(indivSalary - indivInsuranceCost);
        }
    }
}
