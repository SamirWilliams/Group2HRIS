package com.HRIS;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;

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
        return updatedSalary;
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
            System.out.println("Start Date Change Successful");
        }
    }

    //adds a new employee to the database
    public void addEmployee(Connection connection) throws Exception{
        Scanner input = new Scanner(System.in);

        //Employee Table Input
        //Gets user input for new employee first name
        System.out.print("Please enter employees first name: ");
        String firstName = input.nextLine();

        //Gets user input for new employee last name
        System.out.print("Please enter employees last name: ");
        String lastName = input.nextLine();

        //Gets user input for new employee email
        System.out.print("Please enter employees email: ");
        String email = input.nextLine();

        //Gets user input for new employee date of birth
        System.out.println("Please enter employees date of birth: ");
        int month = -1;
        //input validation for month
        do{
            try {
                System.out.print("Month: ");
                month = Integer.parseInt(input.nextLine());
                if (month < 1 || month > 12){
                    System.out.println("Please enter a number from 1-12.");
                }
            } catch (Exception e){
                System.out.println("Invalid Choice");
            }
        } while (month < 1 || month > 12);

        int day = -1;
        //input validation for day
        do{
            try {
                System.out.print("Day: ");
                day = Integer.parseInt(input.nextLine());
                if (day < 1 || day > 31){
                    System.out.println("Please enter a number from 1-31.");
                }
            } catch (Exception e){
                System.out.println("Invalid Choice");
            }
        } while (day < 1 || day > 31);

        int year = -1;
        //input validation for year
        do{
            try {
                System.out.print("Year: ");
                year = Integer.parseInt(input.nextLine());
                if (year < 1800 || year > Calendar.getInstance().get(Calendar.YEAR)){
                    System.out.println("Please enter a number from 1800-" + Calendar.getInstance().get(Calendar.YEAR) + ".");
                }
            } catch (Exception e){
                System.out.println("Invalid Choice");
            }
        } while (year < 1800 || year > Calendar.getInstance().get(Calendar.YEAR));

        String dateOfBirth = "";
        if (day < 10 && month < 10){
            dateOfBirth = year + "-0" + month + "-0" + day;
        } else if (day < 10 && month > 10){
            dateOfBirth = year + "-" + month + "-0" + day;
        } else if (day > 10 && month < 10){
            dateOfBirth = year + "-0" + month + "-" + day;
        } else {
            dateOfBirth = year + "-" + month + "-" + day;
        }

        //Gets user input for new employee role
        System.out.print("Please enter employees role: ");
        String role = input.nextLine();

        //Gets user input for new employee address
        System.out.print("Please enter employees address: ");
        String address = input.nextLine();

        //Gets user input for new employee state
        String state = "";
        //input validation for state
        do {
            try {
                System.out.print("Please enter employees state ex.\"NC\", \"TX\", \"CA\": ");
                state = input.next("[A-Za-z][A-Za-z]");
                if (state.length() != 2){
                    System.out.println("Please use the states 2 character abbreviation.");
                }
            } catch (Exception e){
                System.out.println("Please use the states 2 character abbreviation.");
                input.nextLine();
            }
        } while (state.length() != 2);
        state = state.toUpperCase();
        //catches extra newline character from previous user input
        input.nextLine();

        //Gets user input for new employee training status
        String inTrainingChoice;
        int inTraining;
        //input validation for training status
        do {
            System.out.print("Are they in training? [Yes]/[No]: ");
            inTrainingChoice = input.nextLine().trim().toLowerCase();
            if (inTrainingChoice.equalsIgnoreCase("yes")){
                inTraining = 1;
                break;
            } else if (inTrainingChoice.equalsIgnoreCase("no")){
                inTraining = 0;
                break;
            } else {
                System.out.println("Please enter Yes or No.");
            }
        } while (true);

        //Gets user input for new employee performance rating
        int performance = -1;
        //input validation for performance ranking
        do{
            try {
                System.out.print("Please choose performance ranking [1-10]: ");
                performance = Integer.parseInt(input.nextLine());
                if (performance < 1 || performance > 10){
                    System.out.println("Please enter a number from 1-10.");
                }
            } catch (Exception e){
                System.out.println("Invalid Choice");
            }
        } while (performance < 1 || performance > 10);

        //Gets user input for new employee company level
        int levelInCompany = -1;
        //input validation for company level
        do{
            try {
                System.out.print("Please choose level in company [1-5]: ");
                levelInCompany = Integer.parseInt(input.nextLine());
                if (levelInCompany < 1 || levelInCompany > 5){
                    System.out.println("Please enter a number from 1-5.");
                }
            } catch (Exception e){
                System.out.println("Invalid Choice");
            }
        } while (levelInCompany < 1 || levelInCompany > 5);

        //Gets user input for new employee management status
        String inManagementChoice;
        int inManagement;
        //input validation for management status
        do {
            System.out.print("Are they in management? [Yes]/[No]: ");
            inManagementChoice = input.nextLine().trim().toLowerCase();
            if (inManagementChoice.equalsIgnoreCase("yes")){
                inManagement = 1;
                break;
            } else if (inManagementChoice.equalsIgnoreCase("no")){
                inManagement = 0;
                break;
            } else {
                System.out.println("Please enter Yes or No.");
            }
        } while (true);

        //Payroll Table Input
        /*Asks user whether they want to enter new employees Yearly Salary or Hourly Rate then
        Automatically generates information for the other option based on users choice and input */
        int salaryChoice = -1;
        do{
            System.out.println("Would you like to enter Yearly Salary or Hourly Rate?");
            System.out.println("[1] Yearly Salary");
            System.out.println("[2] Hourly Rate");
            try {
                salaryChoice = Integer.parseInt(input.nextLine());
                if (salaryChoice < 1|| salaryChoice > 2){
                    System.out.println("Please enter 1 or 2.");
                }
            } catch (Exception e){
                System.out.println("Invalid Choice");
            }
        } while (salaryChoice < 1|| salaryChoice > 2);

        double salary = -1;
        double rate = -1;

        if (salaryChoice == 1){
            /*Gets user input for new employee yearly salary
            input validation for yearly salary*/
            do{
                try {
                    System.out.print("Please enter employees yearly salary: ");
                    salary = Double.parseDouble(input.nextLine());
                    if (salary < 15080|| salary > 9999999.99){
                        System.out.println("Please enter a number from at least 15080.");
                    }
                } catch (Exception e){
                    System.out.println("Invalid Choice");
                }
            } while (salary < 15080 || salary > 9999999.99);

            rate = salary / (40 * 52);
            DecimalFormat df = new DecimalFormat("#.00");
            rate = Double.parseDouble(df.format(rate));

        } else {
            /*Gets user input for new employee hourly rate
            input validation for hourly rate*/
            do{
                try {
                    System.out.print("Please enter employees hourly rate: ");
                    rate = Double.parseDouble(input.nextLine());
                    if (rate < 7.25 || rate > 999.99){
                        System.out.println("Please enter a number from at least 7.25.");
                    }
                } catch (Exception e){
                    System.out.println("Invalid Choice");
                }
            } while (rate < 7.25 || rate > 999.99);

            salary = rate * (40 * 52);
            DecimalFormat df = new DecimalFormat("#.00");
            salary = Double.parseDouble(df.format(salary));

        }

        //Gets user input for new employee hours worked
        int hoursWorked = -1;
        //input validation for hours worked
        do{
            try {
                System.out.print("Please enter employees weekly hours worked: ");
                hoursWorked = Integer.parseInt(input.nextLine());
                if (hoursWorked < 1 || hoursWorked > 80){
                    System.out.println("Please enter a number from 1-80.");
                }
            } catch (Exception e){
                System.out.println("Invalid Choice");
            }
        } while (hoursWorked < 1 || hoursWorked > 80);

        //Benefits Table Input
        //Gets user input for new employee vacation leave
        int vacationLeave = -1;
        //input validation for vacation leave
        do{
            try {
                System.out.print("Please enter vacation leave amount [0-25]: ");
                vacationLeave = Integer.parseInt(input.nextLine());
                if (vacationLeave < 0 || vacationLeave > 25){
                    System.out.println("Please enter a number from 0-25.");
                }
            } catch (Exception e){
                System.out.println("Invalid Choice");
            }
        } while (vacationLeave < 0 || vacationLeave > 25);

        //Gets user input for new employee sick leave
        int sickLeave = -1;
        //input validation for sick leave
        do{
            try {
                System.out.print("Please enter sick leave amount [0-20]: ");
                sickLeave = Integer.parseInt(input.nextLine());
                if (sickLeave < 0 || sickLeave > 20){
                    System.out.println("Please enter a number from 0-20.");
                }
            } catch (Exception e){
                System.out.println("Invalid Choice");
            }
        } while (sickLeave < 0 || sickLeave > 20);

        //Gets user input for new employee paid leave
        int paidLeave = -1;
        //input validation for paid leave
        do{
            try {
                System.out.print("Please enter paid leave amount [0-10]: ");
                paidLeave = Integer.parseInt(input.nextLine());
                if (paidLeave < 0 || paidLeave > 10){
                    System.out.println("Please enter a number from 0-10.");
                }
            } catch (Exception e){
                System.out.println("Invalid Choice");
            }
        } while (paidLeave < 0 || paidLeave > 10);

        //Gets user input for new employee health insurance level
        int healthInsurance = -1;
        //input validation for health insurance level
        do{
            try {
                System.out.print("Please enter health insurance level [0-5]: ");
                healthInsurance = Integer.parseInt(input.nextLine());
                if (healthInsurance < 0 || healthInsurance > 5){
                    System.out.println("Please enter a number from 0-5.");
                }
            } catch (Exception e){
                System.out.println("Invalid Choice");
            }
        } while (healthInsurance < 0 || healthInsurance > 5);

        //adds new employee data to the employee table
        boolean addEmployeeCheck;
        String addEmployeeString = "INSERT INTO employee(emp_id, first_name, last_name, email, date_of_birth, role, " +
                "address, state, in_training, performance, level_in_company, in_management) " +
                "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement addEmployee = connection.prepareStatement(addEmployeeString);
            addEmployee.setInt(1, this.empId.size() + 1);
            addEmployee.setString(2, firstName);
            addEmployee.setString(3, lastName);
            addEmployee.setString(4, email);
            addEmployee.setString(5, dateOfBirth);
            addEmployee.setString(6, role);
            addEmployee.setString(7, address);
            addEmployee.setString(8, state);
            addEmployee.setInt(9, inTraining);
            addEmployee.setInt(10, performance);
            addEmployee.setInt(11, levelInCompany);
            addEmployee.setInt(12, inManagement);
            addEmployee.executeUpdate();
            addEmployeeCheck = true;
        }catch (Exception e){
            e.printStackTrace();
            addEmployeeCheck = false;
        }

        //adds new employee data to the payroll table
        boolean addPayrollCheck;
        String addPayrollString = "INSERT INTO payroll(emp_id, salary, hours_worked, rate) VALUES (?, ?, ?, ?);";

        try {
            PreparedStatement addPayroll = connection.prepareStatement(addPayrollString);
            addPayroll.setInt(1, this.empId.size() + 1);
            addPayroll.setDouble(2, salary);
            addPayroll.setInt(3, hoursWorked);
            addPayroll.setDouble(4, rate);
            addPayroll.executeUpdate();
            addPayrollCheck = true;
        }catch (Exception e){
            e.printStackTrace();
            addPayrollCheck = false;
        }

        //adds new employee data to the benefits table
        boolean addBenefitsCheck;
        String addBenefitsString = "INSERT INTO benefits(emp_id, vacation_leave, sick_leave, paid_leave, health_insurance) " +
                "VALUES (?, ?, ?, ?, ?);";

        try {
            PreparedStatement addBenefits = connection.prepareStatement(addBenefitsString);
            addBenefits.setInt(1, this.empId.size() + 1);
            addBenefits.setInt(2, vacationLeave);
            addBenefits.setInt(3, sickLeave);
            addBenefits.setInt(4, paidLeave);
            addBenefits.setInt(5, healthInsurance);
            addBenefits.executeUpdate();
            addBenefitsCheck = true;
        }catch (Exception e){
            e.printStackTrace();
            addBenefitsCheck = false;
        }

        if(addEmployeeCheck && addPayrollCheck && addBenefitsCheck){
            System.out.println("Employee Successfully Added");
        }
        //clears current ArrayLists, so they can be populated with the updated data
        //clears Employee Table ArrayLists
        this.empId.clear();
        this.firstName.clear();
        this.lastName.clear();
        this.email.clear();
        this.dateOfBirth.clear();
        this.role.clear();
        this.address.clear();
        this.state.clear();
        this.inTraining.clear();
        this.performance.clear();
        this.levelInCompany.clear();
        this.inManagement.clear();
        this.startDate.clear();

        //clears Payroll Table ArrayLists
        this.payrollEmpId.clear();
        this.salary.clear();
        this.hoursWorked.clear();
        this.rate.clear();
        this.updatedSalary.clear();

        //clears Benefit Table ArrayLists
        this.benefitsEmpId.clear();
        this.vacationLeave.clear();
        this.sickLeave.clear();
        this.paidLeave.clear();
        this.healthInsurance.clear();

    }

    //Gets user input to select role to be shown
    public void listSpecificRole(){
        int roleChoice = -1;
        Scanner input = new Scanner(System.in);
        //fills roleSet with all unique role titles
        TreeSet<String> roleSet = new TreeSet<>(this.getRole());
        ArrayList<String> roleList = new ArrayList<>(roleSet);
        do {
            //iterates through ArrayList to give user options
            System.out.println("Please Choose a Role: ");
            for (int i = 0; i < roleList.size(); i++){
                System.out.println("[" + (i + 1) + "]" + " " + roleList.get(i));
            }
            System.out.println("[0] Exit");
            //Gets user input
            try {
                roleChoice = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid Choice");
            }if (roleChoice == 0){
                break;
            } else if (roleChoice < 0 || roleChoice > roleList.size()) {
                System.out.println("Invalid Choice");
            }else {
                //outputs employee data based on previous role choice
                String inTraining;
                String roleToGet = roleList.get(roleChoice - 1);
                ArrayList<Integer> employeesToGet = new ArrayList<>();
                //fills employeesToGet with employees that have the same given role
                for (int i = 0; i < this.role.size(); i++){
                    if (this.role.get(i).equalsIgnoreCase(roleToGet)){
                        employeesToGet.add(i);
                    }
                }
                //output table for employee data
                System.out.format("%-12s %-24s %-18s %-30s %-20s %-24s \n", "Employee ID", "Name", "Role",
                        "Email", "Performance Rating", "Currently in Training");
                for (int index : employeesToGet) {
                    inTraining = "";
                    if (this.inTraining.get(index) == 1) {
                        inTraining = "Yes";
                    } else {
                        inTraining = "No";
                    }
                    System.out.format("%-12s %-24s %-18s %-30s %-20s %-24s \n", empId.get(index), firstName.get(index) + " " + lastName.get(index),
                            role.get(index), email.get(index), performance.get(index), inTraining);
                }
                break;
            }
        } while (true);
    }

    //outputs the data for all employees
    public void outputAllEmployees(){
        String inTraining;
        System.out.format("%-12s %-24s %-18s %-30s %-20s %-24s \n", "Employee ID", "Name", "Role",
                "Email", "Performance Rating", "Currently in Training");
        for (int index : empId){
            index -= 1;
            inTraining = "";
            if (this.inTraining.get(index) == 1) {
                inTraining = "Yes";
            } else {
                inTraining = "No";
            }
            System.out.format("%-12s %-24s %-18s %-30s %-20s %-24s \n", empId.get(index), firstName.get(index) + " " + lastName.get(index),
                    role.get(index), email.get(index), performance.get(index), inTraining);
        }
    }

    //outputs the data for a single employee based on the given employee ID
    public void outputSingleEmployee(int empID) {
        String finalString = "";
        int index = getIndexOfEmpID(empID);
        if (index == -1){
            System.out.println("Employee Not Found!");
        } else {
            finalString = "Employee ID: " + empId.get(index) + "\n";
            finalString += "Name: " + firstName.get(index) + " " + lastName.get(index) + "\n";
            finalString += "Role: " + role.get(index) + "\n";
            finalString += "Email: " + email.get(index) + "\n";
            finalString += "Performance Rating: " + performance.get(index) + "\n";
            if (inTraining.get(index) == 1) {
                finalString += "Currently in Training: Yes";
            } else {
                finalString += "Currently in Training: No";
            }
        }
        System.out.println(finalString);
    }
    
    //Outputs salary data for all employees
    public void generatePayroll(){
        System.out.format("%-12s %-24s %-24s %-24s %-12s %-12s \n", "Employee ID", "Name", "Salary Before Expenses",
                "Salary After Expenses", "Hourly Rate", "Hours Worked");
        for (int index : empId){
            index -= 1;
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.format("%-12s %-24s $%-24s $%-24s $%-12s %-12s \n", empId.get(index), firstName.get(index) + " " + lastName.get(index),
                    df.format(salary.get(index)), df.format(updatedSalary.get(index)), df.format(rate.get(index)), hoursWorked.get(index));
        }
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
