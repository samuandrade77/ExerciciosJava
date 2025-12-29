package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Company;
import model.entities.Individual;
import model.entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> taxPayerList = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int number = sc.nextInt();
		
		for(int i=1; i<=number; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char resp = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Annual income: ");
			double annualIncome = sc.nextDouble();
			
			if(resp == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				taxPayerList.add(new Individual(name, annualIncome, healthExpenditures));
			}
			
			else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				taxPayerList.add(new Company(name, annualIncome, numberOfEmployees));
			}
		}
		
		System.out.println(" ");
		System.out.println("TAXES PAID: ");
		for(TaxPayer tax : taxPayerList) {
			System.out.println(tax.getName() + ": $ " + String.format("%.2f", tax.tax()));
		}
		
		double sum = 0;
		
		for(TaxPayer tax : taxPayerList) {
			sum += tax.tax();
		}
		
		System.out.println();
		System.out.printf("TOTAL TAXES: %.2f%n", sum);
		sc.close();
	}

}
