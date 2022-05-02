package com.HRIS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class Group2HrisApplication {

	public static void main(String[] args) throws Exception{


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

		try {

			//Create connection to mySQL server

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection(url, user, password);

			System.out.println("Successful");

			Statement statement = connection.createStatement();

			Employee stream = new Employee();

			//Grabs employee data from SQL table after connection has been created

			//Grabs payroll data
			ResultSet resultSetPayroll = statement.executeQuery("select * from payroll");

			stream.readPayroll(resultSetPayroll);

			//Grabs employee data
			ResultSet resultSetEmployee = statement.executeQuery("select * from employee");
			stream.readEmployee(resultSetEmployee);

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

			//stream.computeSalary();

		} catch (Exception e){
			e.printStackTrace();
		}

	}

	public static String trimString(String stringToTrim){
		stringToTrim = stringToTrim.substring(stringToTrim.indexOf("=") + 1);
		stringToTrim = stringToTrim.trim();
		return stringToTrim;
	}

}

