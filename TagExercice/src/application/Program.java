package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.ImportedProduct;
import model.entities.Product;
import model.entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		List<Product> productsList = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");	
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char option = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(option == 'c') {
				productsList.add(new Product(name, price));
			}
			
			else if(option == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				sc.nextLine();
				LocalDate manufactureDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				productsList.add(new UsedProduct(name, price, manufactureDate));
			}
			
			else {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				productsList.add(new ImportedProduct(name, price, customsFee));
			}
		}
		
		System.out.println(" ");
		System.out.println("PRICE TAGS: ");
		
		for(Product product : productsList) {
			System.out.println(product.priceTag());
		} 
		
		sc.close();
	}

}
