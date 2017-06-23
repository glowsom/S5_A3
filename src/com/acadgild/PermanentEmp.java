package com.acadgild;
/*
 * PermanentEmp is a child class of Employee, and inherits all its properties
 * Because Employee has abstract methods, PermanentEmp will override them.
 */
public class PermanentEmp extends Employee{
	/*
	 * Every permanent employee gets 10 days of Paid leave, 5 days of
	 * sick leave and 5 days of casual leave every calendar year.
	 */
	private int paid_leave = 10;
	private int sick_leave = 5;
	private int casual_leave = 5;

	/*
	 * The default basic salary for a permanent employee is $15,000
	 * 'hra' and 'pra' have been set according to project requirements.
	 */
	private double basic = 2000;
	private double hra = 0.5*basic;
	private double pfa = 0.12*basic;
	
	/*
	 * When creating an instance of PermanentEmp, parent constructor must be called first
	 * followed by anything else required for PermanentEmp specific properties.
	 */
	PermanentEmp(int empId, String empName, double basic){
		super(empId, empName);
		//Setting Basic salary.
		this.basic = basic;
	}

	/*
	 * This method is specific to PermanentEmp. It shows everything needed to be known about
	 * each employee's leave availability.
	 */
	void print_leave_details(){
		
		//This will show the total leave information first...
		calculate_balance_leaves();

		//...followed by specific leave types and their subsequent balance.
		System.out.println(empName+ ", here are the details of your leave balance.\n"
				+ "Paid Leave: \t" +paid_leave+ " days remaining.\n"
				+ "Sick Leave: \t" +sick_leave+ " days remaining.\n"
				+ "Casual Leave: \t" +casual_leave+ " days remaining.");
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.acadgild.Employee#calculate_balance_leaves()
	 * 
	 * Must be overriden because it's an abstract method, and will be used differently 
	 * sompared to other child classes of the common parent class (Employee).
	 * Sums up the balances of all the different leave types, and prints out the total.
	 */
	@Override
	void calculate_balance_leaves(){
		total_leaves = paid_leave + sick_leave + casual_leave;
		System.out.println(empName+ " has a leave balance of "+total_leaves+" days.");
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.acadgild.Employee#avail_leave(int, char)
	 * 
	 * Must be overriden because it's an abstract method, and will be used differently 
	 * sompared to other child classes of the common parent class (Employee).
	 * It approves/rejects leave requests (with a boolean output), while updating leave balance based on leave type. 
	 * Then prints the currently updated leave balance to screen.
	 * 
	 */
	@Override 
	boolean avail_leave(int no_of_leaves, char type_of_leave){
		
		switch(type_of_leave) {  //This helps the program to know what leave type is in question.
		
		    case 'p':
		    	
		    	/*
		    	 * all if-statements update respective leave balance if there is enough balance to approve
				 * the request of that leave type.
				 * else-statements execute if the leave balance isn't sufficient to approve the request.
				 */
		        if(paid_leave >= no_of_leaves){
		        	paid_leave -= no_of_leaves;
		        	break;
		        }
		        else{								
		        	System.out.println(empName+ " has only " +paid_leave+ " days remaining; therefore " +empName+ " may not avail Paid Leave requested.");
		        	return false;
		        }
		        
		    case 's':
		    	if(sick_leave >= no_of_leaves){
		        	sick_leave -= no_of_leaves;
		        	break;
		        }
		        else{
		        	System.out.println(empName+ " has only " +sick_leave+ " days remainin; therefore " +empName+ " may not avail Sick Leave requested.");
		        	return false;
		        }
		    	
		    case 'c':
		    	if(casual_leave >= no_of_leaves){
		        	casual_leave -= no_of_leaves;
		        	break;
		        }
		        else{
		        	System.out.println(empName+ " has only " +casual_leave+ " days remaining; therefore " +empName+ " may not avail Casual Leave requested.");
		        	return false;
		        }
		    //if the leave type is unknown, this message will help the user to understand what type of input the program requires.
		    default:
		    	System.out.println("Please input the correct character for the leave requested: use the following as a guide.\n"
		    			+ "p for Paid Leave\n"
		    			+ "s for Sick Leave, and\n"
		    			+ "c for Casual Leave.");
		        return false;
		}
		//After updating the leave balance, this method will print out the update to screen.
		print_leave_details();
		return true;
	}
	/*
	 * (non-Javadoc)
	 * @see com.acadgild.Employee#calculate_salary()
	 * 
	 * This method calculates the salary based on the project requirement (Employee benefits),
	 * and prints out the sum to screen.
	 */
	@Override
	void calculate_salary(){
		total_salary = basic + hra - pfa;
		System.out.println(empName+ " has a total salary of $" +total_salary+ ".00.");
	}
}