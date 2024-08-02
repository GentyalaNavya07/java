package com.hsbc.controller;

import com.hsbc.bean.Employee;
import com.hsbc.exception.EmployeeAlreadyExistsException;
import com.hsbc.exception.EmployeeNotFoundException;
import com.hsbc.service.Storage;
import com.hsbc.service.StorageFileImpl;
import com.hsbc.utility.StorageFactory;

import java.io.*;
import java.util.Scanner;

public class UserUI {
    static Scanner scanner = new Scanner(System.in);

    public static void acceptEmpDetailsAndStore() throws EmployeeAlreadyExistsException{
        String contents="";

        try(FileReader fileReader=new FileReader("employee.txt"); BufferedReader bufferedReader=new BufferedReader(fileReader))
        {
            while((contents=bufferedReader.readLine())!=null) {
                String contentsArray[] = contents.split(",");
                int empNo = Integer.parseInt(contentsArray[0]);
                String firstName = contentsArray[1];
                String lastName = contentsArray[2];
                String city = contentsArray[3];
                double salary = Double.parseDouble(contentsArray[4]);
                Employee employee = new Employee(empNo, firstName, lastName, city, salary);
                Storage storage = StorageFactory.getStorage();
                storage.addEmployee(employee);
            }
        }
        catch (Exception e)
        {
             e.printStackTrace();
        }

    }

    public static Employee displayEmpByEmpno() throws EmployeeNotFoundException {
        System.out.println("Enter empNo");
        int empNo = scanner.nextInt();
        Storage storage = StorageFactory.getStorage();
        Employee employee= storage.getEmployee(empNo);
        return employee;

    }

    public static void main(String[] args) {
        int option=0;

        do{
            System.out.println("enter 1:storage 2:retrive -1:exit");
            option=scanner.nextInt();
            switch (option) {
                case 1:
                    try {
                        acceptEmpDetailsAndStore();
                    }
                    catch (EmployeeAlreadyExistsException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try{
                        Employee employee = displayEmpByEmpno();
                        if (employee != null) {
                            System.out.println(employee);
                        }
                    }
                    catch (EmployeeNotFoundException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    Employee[] employees= StorageFileImpl.findEmployees();
                    for(Employee employee:employees)
                    {
                        if(employee!=null)
                            System.out.println(employee);
                    }

            }

        }while (option!=-1);


    }
}

