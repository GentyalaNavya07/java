package com.hsbc.service;

import com.hsbc.bean.Employee;
import com.hsbc.exception.EmployeeAlreadyExistsException;
import com.hsbc.exception.EmployeeNotFoundException;

import java.io.*;

public class StorageFileImpl implements Storage{
    private static Employee[] employeeArray;
    private static int indexCounter=0;

    public StorageFileImpl()
    {try(FileReader fileReader=new FileReader("employee.txt"); BufferedReader bufferedReader=new BufferedReader(fileReader)){
            int counter=0;
            String data="";
            while((data=bufferedReader.readLine())!=null)
            {
                counter++;
            }
            employeeArray=new Employee[counter];

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void addEmployee(Employee employee)throws EmployeeAlreadyExistsException {
        try (FileInputStream fileInputStream = new FileInputStream("employees.txt"); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);FileOutputStream fileOutputStream=new FileOutputStream("employees.txt");ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream)) {

                for (Employee employees : employeeArray) {
                    if (employees != null && employees.getEmpNo() == employee.getEmpNo()) {
                        throw new EmployeeAlreadyExistsException("Employee Already Exists");
                    }
                }
                employeeArray[indexCounter++]=employee;
                objectOutputStream.writeObject(employeeArray);
                if(indexCounter==employeeArray.length)
                    indexCounter=0;
            }

         catch (Exception e) {
             e.printStackTrace();
         }
    }

    @Override
    public Employee getEmployee(int empNo) throws EmployeeNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream("employees.txt"); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
           Employee[] employees=(Employee[]) objectInputStream.readObject();
            for (Employee employee : employees) {
                if (employee != null) {
                    if (employee.getEmpNo() == empNo)
                        return employee;
                }
            }

        }
        catch (IOException |ClassNotFoundException e)
        {
         e.printStackTrace();
        }
        throw new EmployeeNotFoundException("Employee not Exists");
    }
    public  static Employee[] findEmployees()
    {
        Employee[] employees=null;
        try(FileInputStream fileInputStream=new FileInputStream("employees.txt");ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream))
        {
            employees=(Employee[]) objectInputStream.readObject();

        }
        catch (IOException |ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return  employees;
    }



}


