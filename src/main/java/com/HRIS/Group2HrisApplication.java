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

		BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/application.properties"));

		String url = bufferedReader.readLine();
		url = trimString(url);

		String user = bufferedReader.readLine();
		user = trimString(user);

		String password = bufferedReader.readLine();
		password = trimString(password);

		Employee myemployee = new Employee();


		bufferedReader.close();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection(url, user, password);

			System.out.println("Successful");

			Statement statement = connection.createStatement();
			//grabs employee data from SQL table after connection has been created

			//grabs payroll data
			ResultSet resultSetPayroll = statement.executeQuery("select * from payroll");

			Employee grabColumns = new Employee();
			grabColumns.readPayroll(resultSetPayroll);

			//grabs employee data
			ResultSet resultSetEmployee = statement.executeQuery("select * from employee");
			grabColumns.readEmployee(resultSetEmployee);

			//grabs benefits data
			ResultSet resultSetBenefits = statement.executeQuery("select * from benefits");
			grabColumns.readBenefits(resultSetBenefits);


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

