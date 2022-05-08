package com.HRIS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.Scanner;

@SpringBootApplication
public class Group2HrisApplication {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(Group2HrisApplication.class, args);

		//read SQL connection/login details from application file
		BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/application.properties"));

		String url = bufferedReader.readLine();
		url = trimString(url);

		String user = bufferedReader.readLine();
		user = trimString(user);

		String password = bufferedReader.readLine();
		password = trimString(password);

		bufferedReader.close();

		Connection connection = null;
		Employee stream = new Employee();

		try {

			//Create connection to mySQL server

			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(url, user, password);

			System.out.println("Connection Successful");

			Statement statement = connection.createStatement();

			//grabs employee data
			stream.readEmployee(statement);

			//grabs payroll data
			stream.readPayroll(statement);

			//Grabs benefits data
			stream.readBenefits(statement);

			//Grabs performance values data
			stream.readPerformanceValues(statement);

			//Grabs company levels data
			stream.readCompanyLevels(statement);

			//Grab health_levels data
			stream.readHealthLevels(statement);

		} catch (Exception e){
			e.printStackTrace();
		}

		Scanner input = new Scanner(System.in);

		int empID = -1;
		boolean empIDCheck;

		do {
			System.out.print("Enter Employee ID or Enter 0 to Exit Program: ");
			try {
				empID = input.nextInt();
			} catch (Exception e) {
				System.out.println("Invalid Choice");
			}
			if (empID == 0){
				System.exit(0);
			}
			empIDCheck = employeeValidation(stream, empID);
			if (empID < 1 || !empIDCheck) {
				System.out.println("Invalid ID");
			}
		} while (!empIDCheck);

		int menuChoice = -1;

		//TODO Menu System
		if (managementCheck(connection, empID)){
			//TODO Management Menu
			do {
				System.out.println("Make a Selection: ");
				System.out.println("[1] List All Employees");
				System.out.println("[2] List Specific Role");
				System.out.println("[3] List Specific Employee");
				System.out.println("[4] Add Employee");
				System.out.println("[5] Generate Payroll");
				System.out.println("[0] Exit");
				try {
					menuChoice = input.nextInt();
				} catch (Exception e) {
					System.out.println("Invalid Choice");
				}
				if (menuChoice < 0 || menuChoice > 5) {
					System.out.println("Invalid Choice");
				}
			} while (menuChoice != 0);
		} else {
			//TODO Employee Menu
			do {
				System.out.println("Make a Selection: ");
				System.out.println("[1] List PTO");
				System.out.println("[2] List Current Salary");
				System.out.println("[3] List Your Information");
				System.out.println("[0] Exit");
				try {
					menuChoice = input.nextInt();
				} catch (Exception e) {
					System.out.println("Invalid Choice");
				}
				if (menuChoice < 0 || menuChoice > 3) {
					System.out.println("Invalid Choice");
				}
			} while (menuChoice != 0);
		}

		System.out.println("pass");

	}
	//Trims string input after "=" Character
	public static String trimString(String stringToTrim){
		stringToTrim = stringToTrim.substring(stringToTrim.indexOf("=") + 1);
		stringToTrim = stringToTrim.trim();
		return stringToTrim;
	}

	//Check if given empID is in the employee database
	public static boolean employeeValidation(Employee employeeList, int empID) throws Exception {
		try {
			if (employeeList.getEmpID().contains(empID)){
				return true;
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	//TODO Replace with new management check method that uses employee class
	//Checks if given empID is in management
	public static boolean managementCheck(Connection connection, int empID){
		String selectString = "select in_management from employee where emp_id = " + empID;
		try{
			PreparedStatement selectStatement = connection.prepareStatement(selectString);
			ResultSet resultSet = selectStatement.executeQuery();
			//If resultSet is empty returns false
			if (!resultSet.isBeforeFirst()){
				return false;
			}else {
				if (resultSet.getInt("in_management") == 1){
					return true;
				} else {
					return false;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

