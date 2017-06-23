package com.acadgild;
/*
 * Because Employee Class has 1 or more abstract methods, it's required to mark it abstract
 * 
 */
public abstract class Employee {
	//Default Employee ID
	protected int empId = 0000;
	//Default name for Employees.
	protected String empName = "John Doe";
	//Every employee can avail at least 5 leave days.
	protected int total_leaves = 5;
	//Every Employee will be paid at least $2000.
	protected double total_salary = 2000;

	//Constructor needed to set Employee's name and ID
	Employee(int empId, String empName){
		this.empId = empId;
		this.empName = empName;
	}
	
	/*
	 *These methods have been set as abstract because the different employees types
	 *will require different behaviors. They will be overridden in the child classes
	 *with the appropriate behavior accordingly.
	 */
	abstract void calculate_balance_leaves();
	abstract boolean avail_leave(int no_of_leaves, char type_of_leave);
	abstract void calculate_salary();
}
