package com.acadgild;
/*
 * Write a program that will compute an Employee's salary and manage their leave details.
 */
public class Inheritance_Override {

	public static void main(String[] args) {
		/*
		 *  TODO This is a Test to verify the accuracy of the program.
		 *  
		 *  
		 *  There are 2 Employees; one permanent (Paul Webb) and the other temporary (Jane Beck).
		 *  Paul makes $83,920 before benefits. Jane makes $48,040 total.
		 */
		PermanentEmp Paul_Webb = new PermanentEmp(100023, "Paul Webb", 83920);
		TemporaryEmp Jane_Beck = new TemporaryEmp(100024, "Jane Beck", 48040);
		
		//Paul and Jane decide to take a 3-day ski trip. They both request for paid leave.
		if(Paul_Webb.avail_leave(3, 'p')){
			System.out.println("Paul can go to the Ski trip.\n");		//Print this if the leave request is approved
		}
		else System.out.println("Paul has been rejected.\n");			//Print this if the leave request is rejected
		
		if(Jane_Beck.avail_leave(3, 'p')){
			System.out.println("Jane can go to the Ski trip.\n");		//Print this if the leave request is approved
		}
		else System.out.println("Jane has been rejected.\n");			//Print this if the leave request is rejected
		
		/*
		 * They both decide again to take a 10 day vacation during the summer, which requires 7 leave
		 * days. They both request paid leave, however, Jane won't be approved for her leave, because
		 * as a temporary employee she only has a balance of 2 leave days.
		 */
		if(Paul_Webb.avail_leave(7, 'p')){
			System.out.println("Paul can take a 10-day vacation.\n");		//Print this if the leave request is approved
		}
		else System.out.println("Paul has been rejected.\n");				//Print this if the leave request is rejected
		
		if(Jane_Beck.avail_leave(7, 'p')){
			System.out.println("Jane can take a 10-day vacation.\n");		//Print this if the leave request is approved
		}
		else System.out.println("Jane has been rejected.\n");				//Print this if the leave request is rejected
		
		/*
		 * Paul is required to attend a funeral and Jane decides to go along with him. Because Paul has
		 * no more paid leave available, he decides to request a casual leave. Jane however requests a
		 * paid leave.
		 */

		if(Paul_Webb.avail_leave(2, 'c')){
			System.out.println("Paul can go to the funeral.\n");		//Print this if the leave request is approved
		}
		else System.out.println("Paul has been rejected.\n");			//Print this if the leave request is rejected
		
		if(Jane_Beck.avail_leave(2, 'p')){
			System.out.println("Jane can go to the funeral.\n");		//Print this if the leave request is approved
		}
		else System.out.println("Jane has been rejected.\n");			//Print this if the leave request is rejected
		
		/*
		 * It comes time for Paul and Jane decide to get married and move to a preferred city. Since they want
		 * to compare their compensation package to their next opportunities, they decide to request their total
		 * salary information.
		 */
		Paul_Webb.calculate_salary();
		Jane_Beck.calculate_salary();

	}

}