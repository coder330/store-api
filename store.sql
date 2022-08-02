use super_market;
show tables;
create table items(
item_id int primary key auto_increment,
item_name varchar(20) ,
item_quantity int,
item_price int);

create table customer(
customer_id int primary key,
customer_name varchar(20),
customer_phone varchar(10)
);

create table invoice(
invoice_id int primary key,
customer_id int,
foreign key (customer_id) references customer(customer_id));

alter table invoice
auto_increment=100;

create table sales(
id int primary key,
item_id int,
item_quantity int,
invoice_id int, 
customer_id int,
price int,
foreign key (item_id) references items(item_id),
foreign key (invoice_id) references invoice(invoice_id),
foreign key (customer_id) references customer(customer_id)
);
