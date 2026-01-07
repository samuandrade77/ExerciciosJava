package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private LocalDateTime moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> items= new ArrayList<>();
	
	public Order() {
	}

	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		double sum = 0.0;
		for(OrderItem item : items) {
			sum+= item.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(moment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		sb.append("\nOrder status: " + status);
		sb.append("\nClient: " + client.getName());
		sb.append(" (" + client.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		sb.append(") - " + client.getEmail());
		sb.append("\nOrder items: \n");
		for(OrderItem item : items) {
			sb.append(item.getProduct().getName() + ", $" + String.format("%.2f", item.getPrice()));
			sb.append(", Quantity: " + item.getQuantity() + ", ");
			sb.append("Subtotal: $" + String.format("%.2f", item.subTotal()) + "\n");
		}
		sb.append("Total price: $" + String.format("%.2f", total()));
		return sb.toString();
	}
}
