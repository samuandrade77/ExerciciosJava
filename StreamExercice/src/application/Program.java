package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		List<Employee> listEmployee = new ArrayList<>();
		
		System.out.print("Enter full file path: ");
		File sourceFile = new File(sc.nextLine());
		
		try(BufferedReader br = new BufferedReader(new FileReader(sourceFile))){
			
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				String email = fields[1];
				double salary = Double.parseDouble(fields[2]);
				listEmployee.add(new Employee(name, email, salary));
				line = br.readLine();
			}
			
			System.out.print("Enter salary: ");
			double salary = sc.nextDouble();
			
			List<String> highestSalary = listEmployee.stream().filter(e -> e.getSalary() > 2000)
					.map(e -> e.getEmail())
					.sorted((e1, e2) -> e1.toUpperCase().compareTo(e2.toUpperCase()))
					.collect(Collectors.toList());
			
			System.out.printf("Email of people whose salary is more than: %.2f%n", salary);
			
			for(String s : highestSalary) {
				System.out.println(s);
			}
			
			double salaryM = listEmployee.stream()
					.filter(e -> e.getName().charAt(0) == 'M')
					.map(e -> e.getSalary())
					.reduce(0.0, (e1, e2) -> e1+e2);
			
			System.out.printf("Sum of salary of people whose name starts with 'M': %.2f%n", salaryM);
					
		}
		
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		finally {
			sc.close();
		}
	}

}
