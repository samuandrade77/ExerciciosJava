package model.entities;

public abstract class TaxPayer {
	
	private String name;
	private double annualIncome;
	
	public abstract Double tax();

	public TaxPayer() {
	}
	
	public TaxPayer(String name, double annualIncome) {
		this.name = name;
		this.annualIncome = annualIncome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}
	
	
}
