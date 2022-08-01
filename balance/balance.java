package org.supermarket.store.main.balance;

public class balance {
	
	private int id;
	private int customer_id;
	private double customer_total_balance;
	private double customer_paid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public double getCustomer_total_balance() {
		return customer_total_balance;
	}
	public void setCustomer_total_balance(double customer_total_balance) {
		this.customer_total_balance = customer_total_balance;
	}
	public double getCustomer_paid() {
		return customer_paid;
	}
	public void setCustomer_paid(double customer_paid) {
		this.customer_paid = customer_paid;
	}
}
