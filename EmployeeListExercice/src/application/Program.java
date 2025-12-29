package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			System.out.println("Employee #" + (i+1) + ": ");
			System.out.print("Id: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			System.out.println(" ");
			list.add(new Employee(id, name, salary));
		}
		
		System.out.print("Enter the employee id that will have salary increase: ");
		int response = sc.nextInt();
		
		Employee emp = list.stream().filter(id -> id.getId() == response).findFirst().orElse(null);
		
		if(emp == null) {
			System.out.println("This ID doesn't exist!");
		}
		
		else{
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}
		
		System.out.println(" ");
		System.out.println("List of employees: ");
		for(Employee employee : list) {
			System.out.println(employee);
		}
		sc.close();
	}

}
