package com.HRIS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
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

		bufferedReader.close();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection(url, user, password);

			System.out.println("Successful");

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("select * from actor");

			while (resultSet.next()){
				System.out.println(resultSet.getString("first_name"));
			}

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
