package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public OnlinePaymentService getOnlinePaymentService() {
		return onlinePaymentService;
	}

	public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {		
		
		double initialInstallment = contract.getTotalValue()/months;
		
		for(int i=1; i<=months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			double interest = onlinePaymentService.interest(initialInstallment, i);
			double paymentFee = onlinePaymentService.paymentFee(initialInstallment + interest);
			double totalInstallment = initialInstallment + interest + paymentFee;
			
			contract.getListOfInstallment().add(new Installment(dueDate, totalInstallment));
		}
		
		}
	}
		
		
	

