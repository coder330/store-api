package org.supermarket.store.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.supermarket.store.main.bill.bill;
import org.supermarket.store.main.customer.customer;
import org.supermarket.store.main.invoices.invoice;
import org.supermarket.store.main.item.item;
import org.supermarket.store.main.item.multiItem;
//import org.supermarket.store.main.shopping.shopping;

public class database {
	List<item> itemList = new ArrayList<item>();
	Connection con;
	public database(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_market","root","Sameonu07@");
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	public void load_items(item i) {
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("insert into items (item_name, item_quantity, item_price) values (?,?,?)");
			
			statement.setString(1, i.getItem_name());
			statement.setInt(2, i.getQuantity());
			statement.setInt(3,i.getPrice());
			statement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	} 
	
	public void load_multi_items(List<item> itemList){
		PreparedStatement statement,statementUpdate = null;
		
		try {
			statement = con.prepareStatement("insert into items (item_name, item_quantity, item_price) values(?,?,?)");
			
			for(int i =0;i<itemList.size();i++) {
				
				statement.setString(1, itemList.get(i).getItem_name());
				statement.setInt(2, itemList.get(i).getQuantity());
				statement.setInt(3, itemList.get(i).getPrice());
				statement.execute();
			}
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public List<item> item_display() {
		PreparedStatement statement;
		
		try {
			statement  = con.prepareStatement("select item_id, item_name, item_quantity, item_price from items");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				item item = new item();
				item.setItem(rs.getInt(1));
				item.setItem_name(rs.getString(2));
				item.setPrice(rs.getInt(3));
				item.setQuantity(rs.getInt(4));
				
				itemList.add(item);
			}
		}catch(SQLException e) {
				e.printStackTrace();
				return null;
		}
		return itemList;
	}
	

	public item item_display(int id) {
		Statement statement;
		item i = new item();
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from items where item_id = "+id);
			rs.next();
			
			i.setItem(rs.getInt(1));
			i.setItem_name(rs.getString(2));
			i.setQuantity(rs.getInt(3));
			i.setPrice(rs.getInt(4));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public int search(int id) {
		int item_id = 0;
		//int info = 0;
		Statement statement =null; 
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from items where item_id ="+id);
			rs.next();
			
			if(rs!=null) {
				item_id = rs.getInt(1);
			}
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return item_id;

		
	}
	
	public void updateItem(item i) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("update items set item_name = ?, item_quantity = ?, item_price = ? where item_id = ?");
			statement.setString(1,i.getItem_name());
			statement.setInt(2, i.getQuantity());
			statement.setInt(3, i.getPrice());
			statement.setInt(4,i.getItem());
			statement.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete(int id,String query) {
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(query);
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<customer> displaycustomer(){
		PreparedStatement statement;
		List<customer> customerList = new ArrayList<customer>();
		try {
			statement  = con.prepareStatement("select * from customer");
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				customer cus = new customer();
				cus.setCustomer_id(rs.getInt(1));
				cus.setCustomer_name(rs.getString(2));
				cus.setPhone_no(rs.getString(3));
				customerList.add(cus);
			}
		}catch(SQLException e) {
				e.printStackTrace();
				return null;
		}
		return customerList;
	}
	
	public void addCustomer(customer c) {
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("insert into customer (customer_id, customer_name, customer_phone) values (?,?,?)");
			
			statement.setInt(1, c.getCustomer_id());
			statement.setString(2, c.getCustomer_name());
			statement.setString(3,c.getPhone_no());
			statement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public customer search_C(int id) {
		customer cus = new customer();
		Statement statement =null; 
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from customer where customer_id ="+id);
			rs.next();
			cus = null;
			if(rs!=null) {
				cus.setCustomer_id(rs.getInt(1));
				cus.setCustomer_name(rs.getString(2));
				cus.setPhone_no(rs.getString(3));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cus;
	}
	
	public void edit_C(customer c){
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("update customer set customer_name = ?, customer_phone = ? where customer_id = ?");
			statement.setString(1, c.getCustomer_name());
			statement.setString(2, c.getPhone_no());
			statement.setInt(3, c.getCustomer_id());
			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public customer get_C(int id){
		Statement statement = null;
		customer cus = new customer();
		
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = "+id);
			rs.next();
			
			cus.setCustomer_id(rs.getInt(1));
			cus.setCustomer_name(rs.getString(2));
			cus.setPhone_no(rs.getString(3));
		}catch(SQLException e){
			e.printStackTrace();
		}
		return cus;
	}
	public List<invoice> displayinvoice() {
		// TODO Auto-generated method stub
		
		List<invoice> list = new ArrayList<invoice>();
		Statement statement = null;
		try {
			statement  = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from invoice");
			while(rs.next()) {
				invoice voice = new invoice();
				voice.setInvoice_id(rs.getInt(1));
				voice.setCustomer_id(rs.getInt(2));
				list.add(voice);
			}
		}catch(SQLException e) {
			e.printStackTrace();		}
		return list;
	}
	public void addInvoice(invoice i) {
		// TODO Auto-generated method stub
		
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("insert into invoice(customer_id) values(?)");
			statement.setInt(1, i.getCustomer_id());
			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void edit_In(invoice i) {
		invoice in = new invoice();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("update invoice set customer_id = ? where invoice_id = ?");
			statement.setInt(1,i.getCustomer_id());
			statement.setInt(2, i.getInvoice_id());
			statement.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public invoice search_In(int id) {
		Statement statement =null;
		invoice in = new invoice();
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from invoice where invoice_id ="+id); 
			rs.next();
			in = null;
			if(rs!=null) {
				
				in.setInvoice_id(rs.getInt(1));
				in.setCustomer_id(rs.getInt(2));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return in;
	}
	
	public invoice get_I(int id) {
		invoice i = new invoice();
		Statement statement;
		customer customer = new customer();
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from invoice where invoice_id = "+id);
			rs.next();
			i.setInvoice_id(rs.getInt(1));
			i.setCustomer_id(rs.getInt(2));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int getInvoices(int id){
		Statement state;
		int invoice = 0;
		try {
			state = con.createStatement();
			ResultSet rs = state.executeQuery("select invoice_id from invoice where customer_id="+id);
			while(rs.next()) {
				invoice = rs.getInt(1);
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return invoice;
	}
	public void generateBill(bill bill) {
		PreparedStatement prestatement;
		PreparedStatement statement;
		Statement state;
		customer customer = new customer();
		invoice invoice = new invoice();
		
		try {
			prestatement = con.prepareStatement("insert into sales (invoice_id, item_id,quantity,price) values(?,?,?,?)");
			addCustomer(bill.getCustomer());
			//add invoice
			int total=0;
			customer = bill.getCustomer();
			state = con.createStatement();
			invoice.setCustomer_id(customer.getCustomer_id());
			addInvoice(invoice);
			//get invoice
			itemList = bill.getItemList();
			int invoice_id = getInvoices(customer.getCustomer_id());
			for(item i : itemList) {
				int id = i.getItem();
				ResultSet rs = state.executeQuery("select item_quantity,item_price from items where item_id = "+id);
				rs.next();
				prestatement.setInt(1, invoice_id);
				prestatement.setInt(2, id);
				prestatement.setInt(3, i.getQuantity());
				prestatement.setInt(4, rs.getInt(2)*i.getQuantity());
				total=total+rs.getInt(1)*i.getQuantity();
				prestatement.execute();
				statement = con.prepareStatement("update item set item_quantity = ? where item_id = ?");
				statement.setInt(1, rs.getInt(1)-i.getQuantity() );
				statement.execute();
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public bill getBilling(int id) {
		
		List<Integer> item_no =new ArrayList<Integer>();
		Statement statement;
		customer customer = new customer();
		bill billList = new bill();
		try {
			statement = con.createStatement();
			billList.setInvoice_id(id);
			
			ResultSet rs = statement.executeQuery("select item_id, quantity,price from sales where invoice_id="+id);
			while(rs.next()) {
				item item = new item();
				item.setItem(rs.getInt(1));
				item_no.add(rs.getInt(1));
				item.setQuantity(rs.getInt(2));
				item.setPrice(rs.getInt(3));
				itemList.add(item);
			}
			rs.close();
			for(int i = 0;i<item_no.size();i++) {
				ResultSet rs1 = statement.executeQuery("select item_name from items where item_id = "+item_no.get(i));
				rs1.next();
				itemList.get(i).setItem_name(rs1.getString(1));
				rs1.close();
			}
			
			billList.setItemList(itemList);
			
			ResultSet rs3 = statement.executeQuery("select customer.customer_id,customer_name, customer_phone from customer inner join invoice on invoice_id = "+id);
			rs3.next();
			customer.setCustomer_id(rs3.getInt(1));;
			customer.setCustomer_name(rs3.getString(2));
			customer.setPhone_no(rs3.getString(3));
			billList.setCustomer(customer);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return billList;
		
	}
	
}
