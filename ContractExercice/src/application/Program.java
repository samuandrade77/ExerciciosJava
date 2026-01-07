package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the contract details: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.print("Contract value: ");
		double contractValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, contractValue);
		
		ContractService service = new ContractService(new PaypalService());
		
		System.out.print("Enter the number of installments: ");
		int numberOfInstallments = sc.nextInt();
		
		service.processContract(contract, numberOfInstallments);
		
		for(Installment installment : contract.getListOfInstallment()) {
			System.out.println(installment);
		}
		
		sc.close();
	}

}
