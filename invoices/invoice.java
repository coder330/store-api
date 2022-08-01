package org.supermarket.store.main.invoices;

import java.sql.Date;
public class invoice {

	private int invoice_id;
	private int customer_id;
	private int total;
	
	public int getTotal() {
		return total;
	}

	//private Date sales_date;
	/*public Date getSales_date() {
		return sales_date;
	}
	public void setSales_date(Date sales_date) {
		this.sales_date = sales_date;
	}*/
	public invoice(){
		
	}
	
	invoice(int invoice_id, int customer_id) {
		this.invoice_id = invoice_id;
		this.customer_id = customer_id;
		}
	public int getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	

}
