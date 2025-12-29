package util;

public class CurrencyConverter {

	public static double converter(double price, double quantity) {
		price += price * 0.06;
		return price * quantity;
	}
}
