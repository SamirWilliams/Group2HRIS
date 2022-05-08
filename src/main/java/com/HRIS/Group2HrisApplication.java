package com.HRIS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeSet;

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
			ResultSet resultSetEmployee = statement.executeQuery("select * from employee");
			stream.readEmployee(resultSetEmployee);

			//grabs payroll data
			ResultSet resultSetPayroll = statement.executeQuery("select * from payroll");
			stream.readPayroll(resultSetPayroll);

			//Grabs benefits data
			ResultSet resultSetBenefits = statement.executeQuery("select * from benefits");
			stream.readBenefits(resultSetBenefits);

			//Grabs performance values data
			ResultSet resultSetPerformanceVal = statement.executeQuery("select * from allowed_performance_values");
			stream.readPerformanceValues(resultSetPerformanceVal);

			//Grabs company levels data
			ResultSet resultSetCompanyLev = statement.executeQuery("select * from allowed_company_levels");
			stream.readCompanyLevels(resultSetCompanyLev);

			//Grab health_levels data
			ResultSet resultSetHealthLev = statement.executeQuery("select * from allowed_health_levels");
			stream.readHealthLevels(resultSetHealthLev);

			stream.computeSalary();

		} catch (Exception e){
			e.printStackTrace();
		}

		Scanner input = new Scanner(System.in);

		int empID = -1;
		boolean empIDCheck = false;

		do {
			System.out.print("Enter Employee ID or Enter 0 to Exit Program: ");
			try {
				empID = Integer.parseInt(input.nextLine());
				if (empID == 0){
					System.exit(0);
				}
				empIDCheck = employeeValidation(stream, empID);
				if (empID < 1 || !empIDCheck) {
					System.out.println("Invalid ID");
				}
			} catch (Exception e) {
				System.out.println("Invalid Choice");
			}
		} while (!empIDCheck);

		int menuChoice = -1;
		boolean managementCheck = managementCheck(stream, empID);

		//TODO Menu System
		if (managementCheck == true){
			//TODO Management Menu
			managementMenu(stream, connection);
		} else {
			//TODO Employee Menu
			employeeMenu(stream);
		}

		System.out.println("End of Program");

	}

	//Trims string input after "=" Character
	public static String trimString(String stringToTrim){
		stringToTrim = stringToTrim.substring(stringToTrim.indexOf("=") + 1);
		stringToTrim = stringToTrim.trim();
		return stringToTrim;
	}

	//Check if given empID is in the employee database
	public static boolean employeeValidation(Employee employeeList, int empID) {
		try {
			if (employeeList.getEmpID().contains(empID)){
				return true;
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	//Checks if given empID is in management
	public static boolean managementCheck(Employee employeeList, int empID) {
		try {
			if(employeeList.getInManagement(empID) == 1){
				return true;
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	//Entire Management Menu System
	public static void managementMenu(Employee stream, Connection connection) throws Exception {
		int menuChoice = -1;
		int empID = -1;
		boolean empIDCheck = false;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Make a Selection: ");
			System.out.println("[1] List All Employees");
			System.out.println("[2] List Specific Role");
			System.out.println("[3] List Specific Employee");
			System.out.println("[4] Add Employee");
			System.out.println("[5] Generate Payroll");
			System.out.println("[0] Exit");
			try {
				menuChoice = Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid Choice");
			}
			if (menuChoice < 0 || menuChoice > 5) {
				System.out.println("Invalid Choice");
			}
			switch (menuChoice){
				case 1:
					stream.outputAllEmployees();
					pressEnterKeyToContinue();
					break;
				case 2:
					stream.listSpecificRole();
					pressEnterKeyToContinue();
					break;
				case 3:
					do {
						System.out.print("Enter Employee ID or Enter 0 to go back: ");
						try {
							empID = Integer.parseInt(input.nextLine());
							if (empID == 0){
								break;
							}
							empIDCheck = employeeValidation(stream, empID);
							if (empID < 1 || !empIDCheck) {
								System.out.println("Invalid ID");
							}
						} catch (Exception e) {
							System.out.println("Invalid Choice");
						}
					} while (!empIDCheck);
					if (empID != 0){
						stream.outputSingleEmployee(empID);
						pressEnterKeyToContinue();
					}
					break;
				case 4:
					stream.addEmployee(connection);
					Statement statement = connection.createStatement();

					//grabs employee data
					ResultSet resultSetEmployee = statement.executeQuery("select * from employee");
					stream.readEmployee(resultSetEmployee);

					//grabs payroll data
					ResultSet resultSetPayroll = statement.executeQuery("select * from payroll");
					stream.readPayroll(resultSetPayroll);

					//Grabs benefits data
					ResultSet resultSetBenefits = statement.executeQuery("select * from benefits");
					stream.readBenefits(resultSetBenefits);

					stream.computeSalary();
					pressEnterKeyToContinue();
					break;
				case 5:
					stream.generatePayroll();
					pressEnterKeyToContinue();
					break;
			}
		} while (menuChoice != 0);
	}

	//Entire Normal Employee Menu System
	public static void employeeMenu(Employee stream){
		int menuChoice = -1;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Make a Selection: ");
			System.out.println("[1] List PTO");
			System.out.println("[2] List Current Salary");
			System.out.println("[3] List Your Information");
			System.out.println("[0] Exit");
			try {
				menuChoice = Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid Choice");
			}
			if (menuChoice < 0 || menuChoice > 3) {
				System.out.println("Invalid Choice");
			}
			switch(menuChoice){
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
			}

		} while (menuChoice != 0);
	}

	//Pauses program to get user input to continue
	private static void pressEnterKeyToContinue() {
		System.out.println("Press Enter key to continue...");
		Scanner input = new Scanner(System.in);
		input.nextLine();
	}

}

