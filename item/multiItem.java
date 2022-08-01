package org.supermarket.store.main.item;

public class multiItem {
	private String item_name;
	private int quantity;
	private int price;
	//private int order;

	
	public multiItem(){
		
	}
	//item(int item,int order){
	//	this.item = item;
	//	this.order = order;
	//}
	multiItem(String item_name, int quantity, int price){
		//System.out.println("Hello");
		this.item_name = item_name;
		this.quantity = quantity;
		this.price = price;
	}
/*	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}*/
	
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
