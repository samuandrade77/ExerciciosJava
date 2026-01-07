package aplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Product;

public class Program {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> productList = new ArrayList<>();
		
		System.out.print("Enter the file path: ");
		File sourceFile = new File(sc.nextLine());
		
		new File(sourceFile.getParent() + "\\out").mkdir();
		String summaryCsv = sourceFile.getParent() + "\\out\\summary.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(sourceFile))){
			String fileLine = br.readLine();
			
			while(fileLine != null) {
				String[] fields = fileLine.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
				
				productList.add(new Product(name, price, quantity));
				
				fileLine = br.readLine();
			}
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(summaryCsv))){
				for(Product product : productList) {
					bw.write(product.getName() + String.format("%.2f", product.total()));
					bw.newLine();
				}
			}
			catch(IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}
		} 
		catch(IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
		
		sc.close();
	} 

}
