package org.supermarket.store.main;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.ArrayList;

import org.supermarket.store.*;
import org.supermarket.store.main.bill.bill;
import org.supermarket.store.main.customer.customer;
import org.supermarket.store.main.invoices.invoice;
import org.supermarket.store.main.item.item;
import org.supermarket.store.main.item.multiItem;
//import org.supermarket.store.main.shopping.shopping;

@Path("/AmbatturBranch")
public class store {

	List<item> item_list = new ArrayList<item>();
	database database = new database();
	List<item> itemList = new ArrayList<item>();
	//CRUD for items
	@GET
	@Path("/item")
	@Produces(MediaType.APPLICATION_JSON)
	public List<item> display() {
		item item;
		itemList = database.item_display();
		return itemList;
		
	}
	//tested
	@Path("/item")
	@POST
	
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(item i) {
		database datebase = new database();
		datebase.load_items(i);
		return "Successfully added";
	}
	
	@POST
	@Path("/items")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertMultitem(List<item> itemList){
		database database = new database();
		database.load_multi_items(itemList);
		return "Successfully added";
	}
	
	
	@PUT
	@Path("/item")
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(item i) {
		database database = new database();
		if(database.search(i.getItem())!=0) {
			database.updateItem(i);
			return "Successfully Updated";
		}
		else {
			database.load_items(i);
			return "New entry is inserted";
		}
		
	}
	
	@Path("/item/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteItem(@PathParam("id") int id) {
		database database = new database();
		String query = "delete from items where item_id = "+String.valueOf(id);
		database.delete(id,query);
		String report = "ID"+String.valueOf(id)+" deleted";
		return report;
	}
	@GET
	@Path("/item/{id}")
	
	@Produces(MediaType.APPLICATION_JSON)
	public item getItem(@PathParam("id") int id) {
		return database.item_display(id);
	}
	
	
	
	
	
	//CRUD for customer
	
	@GET
	@Path("/customer")
	@Produces(MediaType.APPLICATION_JSON)
	public List<customer> display_C() {
		
		return database.displaycustomer();
		
	}
	@POST
	@Path("/customer")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(customer i) {
		database datebase = new database();
		datebase.addCustomer(i);
		return "Successfully added";
	}
	
	
	@PUT
	@Path("/customer")
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(customer i) {
		database database = new database();
		if(database.search_C(i.getCustomer_id())!=null) {
			database.edit_C(i);
			return "Successfully Updated";
		}
		else {
			database.addCustomer(i);
			return "New entry is inserted";
		}
		
	}
	
	@Path("/customer/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public customer getCustomer(@PathParam("id") int id){
		database database = new database();
		return database.get_C(id);
	}
	@Path("/customer/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteCustomer(@PathParam("id") int id) {
		database database = new database();
		String query = "delete from customer where customer_id = "+String.valueOf(id);
		database.delete(id,query);
		String report = "ID "+String.valueOf(id)+" deleted";
		return report;
	}
	
	
	//invoice
	
	@Path("/invoice")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String create(invoice in) {
		database database = new database();
		database.addInvoice(in);
		return "Add successfully";
	}
	
	@Path("/invoice")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<invoice> display_I(){
		database database = new database();
		return database.displayinvoice();
	}
	
	@Path("/invoice")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(invoice in) {
		database database = new database();
		if(database.search_In(in.getCustomer_id())!=null) {
			database.edit_In(in);
			return "Successfully Updated";
		}
		else {
			database.addInvoice(in);
			return "New entry is inserted";
		}
	}
	
	@Path("/invoice/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public invoice getInvoice(@PathParam("id") int id) {
		database database = new database();
		return database.get_I(id);
	}
	
	@Path("/invoice/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteInvoice(@PathParam("id")int id) {
		database database = new database();
		String query = "delete from invoice1 where invoice_id = "+String.valueOf(id);
		database.delete(id,query);
		String report = "ID "+String.valueOf(id)+" deleted";
		return report;
	}
	
	@Path("/bill")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String order(bill bill) {
		
		database database  = new database();
		database.generateBill(bill);
		return "List is received successfully";
		
	}
	
	@Path("/bill/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public bill getBill(@PathParam("id") int id) {
		database database = new database();
		return database.getBilling(id);
	}
	
}





