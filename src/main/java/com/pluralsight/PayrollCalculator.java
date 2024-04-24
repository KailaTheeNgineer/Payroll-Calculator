package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;

public class PayrollCalculator {
    public static void main(String[] args) {

        try {

            FileReader fileReader = new FileReader("src/main/resources/DataFiles/employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);


            String input;
            bufReader.readLine();
            while ((input = bufReader.readLine()) != null) {
                        String[] split = input.split("\\|");
                        int id = Integer.parseInt(split[0]);
                        String name = split[1];
                        double hoursWorked = Double.parseDouble(split[2]);
                        double payRate = Double.parseDouble(split[3]);
                        Employee employee = new Employee(id, name, hoursWorked, payRate);

                        System.out.printf("Employee ID: %d \nName: %s \nGross Pay: $%.2f\n",
                                employee.getEmployeeID(), employee.getName(), employee.getGrossPay());


            }
            bufReader.close();


        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}