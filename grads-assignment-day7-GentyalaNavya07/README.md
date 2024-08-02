# Grads_assignment_Day7_set1  Day 7 (1st Aug 2024)





(Note:- Please use employee.txt file for solving the below problems)

  1.	Create an implementation class StorageFileImpl implementing Storage interface given in Day 5 assignment. 
  2.	Create an array of type Employee like Employee[] employees.
  3.	Initialize the array in StorageFileImpl class constructor with size as the number of lines in employee.txt.
  4.	Implement the unimplemented methods of Storage interface as given below.
     
            a.	void addEmployee(Employee e) throws EmployeeAlreadyExistsException : 
		            Read each line from employee.txt file and create an Employee object with each line and add to employees array.
    	
       	    b.   Employee getEmployee(int empno) throws EmployeeNotFoundException : 
		             Check if an employee is present or not. Return employee if present else throw an EmployeeNotFoundException.
    	
 6.	Add new method in StorageFileImpl class to return an array of all employees.
 7.	Test all methods by calling from main menu.	
