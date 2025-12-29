package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Account acc;
		
		System.out.print("Enter account number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter account holder: ");
		String name = sc.nextLine();
		System.out.print("Is there a initial deposit (y/n): ");
		char initialDeposit = sc.next().charAt(0);
		
		if (initialDeposit == 'y') {
			System.out.print("Enter initial deposit value: ");
			double value = sc.nextDouble();
			acc = new Account(number, name, value);
		}
		
		else {
			acc = new Account(number, name);
		}
		
		System.out.println();
		System.out.println("Account Data: ");
		System.out.println(acc);
		System.out.println();
		
		System.out.print("Enter a deposit value: ");
		double depositValue = sc.nextDouble();
		acc.deposit(depositValue);
		System.out.println("Updated account data: ");
		System.out.println(acc);
		System.out.println();
		
		System.out.print("Enter a withdraw value: ");
		double whitDrawValue = sc.nextDouble();
		acc.withdraw(whitDrawValue);
		System.out.println("Updated account data: ");
		System.out.println(acc);
		System.out.println();
		
		sc.close();
	}

}
