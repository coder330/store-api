package org.supermarket.store.main.bill;

import java.util.List;

import org.supermarket.store.main.customer.customer;
import org.supermarket.store.main.item.item;
public class bill {
	private int invoice_id;
	private List<item> itemList;
	private customer customer;
	public bill(){
		
	}
	bill(List<item> itemList,customer customer){
		this.itemList = itemList;
		this.customer = customer;
	}
	
	
	public int getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}
	public customer getCustomer() {
		return customer;
	}
	public void setCustomer(customer customer) {
		this.customer = customer;
	}
	public List<item> getItemList() {
		return itemList;
	}
	public void setItemList(List<item> itemList) {
		this.itemList = itemList;
	}
	
}
	

