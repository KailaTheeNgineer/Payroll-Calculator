package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.Scanner;

public class PayrollCalculator {

    public static void main(String[] args) {

        System.out.println("Enter the name of a csv file to enter new employee information: ");
        System.out.println("(Hint: it must end with an extension)");
        Scanner myScanner = new Scanner(System.in);
        String employeeFile = myScanner.nextLine();

        try {

            FileReader fileReader = new FileReader("src/main/resources/DataFiles/employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            FileWriter employeeWriter = new FileWriter(employeeFile, true);
            employeeWriter.write("ID | Name | Gross Pay\n");
            employeeWriter.write("111 | Cameron Tay | $3277.65\n");
            employeeWriter.write("222 | James Tee | $2150.00\n");
            employeeWriter.close();

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


            } bufReader.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}