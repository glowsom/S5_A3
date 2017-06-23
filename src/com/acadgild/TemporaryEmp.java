package com.acadgild;
/*
 * TemporaryEmp is a child class of Employee, and will implement all abstract methods of
 * Employee.
 * Assumptions:	Paid leave is the only type of leave available to this class.
 * 				Total Salary doesn't include any benefits.
 */
public class TemporaryEmp extends Employee{
	
	//Constructor for TemporaryEmp
	TemporaryEmp(int empId, String empName, double total_salary){
		//Call to parent class constructor
		super(empId, empName);
		/*
		 * Total salary is assigned directly. Because the total salary of temporary employees
		 * doesn't include benefits there's no specific calculation needed.
		 */
		super.total_salary = total_salary;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see com.acadgild.Employee#calculate_balance_leaves()
	 * 
	 * There's nothing to calculate for total leaves since paid leave is the only type available
	 * for Temporary Employees. This method only prints out the leave balance to screen.
	 */
	@Override
	void calculate_balance_leaves(){
		System.out.println(empName+ " has a leave balance of "+total_leaves+" days.");
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.acadgild.Employee#avail_leave(int, char)
	 * 
	 * This method will return true if the leave request is granted, and false if the leave request
	 * isn't granted.
	 */
	@Override
	boolean avail_leave(int no_of_leaves, char type_of_leavel){
		//Checking to see of there is enough leave balance to grant request
		if(total_leaves>=no_of_leaves){
			total_leaves -= no_of_leaves;//Updates leave balance

			calculate_balance_leaves();//this method will be executed to show leave balance.
			return true;
		}
		//If the total leaves is insufficient, this message will be printed to screen.
		System.out.println(empName+ " has only " +total_leaves+ " days remaining; therefore " +empName+ " may not avail requested Leave.");
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see com.acadgild.Employee#calculate_salary()
	 * 
	 * Total salary doesn't include benefits, so this just prints out the same salary given to
	 * constructor.
	 */
	@Override
	void calculate_salary(){
		System.out.println(empName+ " has a total salary of $" +total_salary+ ".00.");
	}

}