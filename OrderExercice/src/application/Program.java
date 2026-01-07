package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("BirthDate (DD/MM/YYYY): ");
		LocalDate birthDate = LocalDate.parse(sc.nextLine(),DateTimeFormatter.ofPattern("dd/MM/yyy"));
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.nextLine());
		
		Order order = new Order(LocalDateTime.now(), status, client);
				
		System.out.print("How many items to this order? ");
		int nItems = sc.nextInt();
		sc.nextLine();
		
		for(int i=1; i<=nItems; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			
			OrderItem orderItem = new OrderItem(quantity, price, new Product(productName, price));
			order.addItem(orderItem);	
		}
		
		System.out.println(" ");
		
		System.out.println(order);
		
		sc.close();
	}

}
