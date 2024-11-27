package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="category_Id")
int cid;
@Column(name="C_name")
String cname;

@OneToMany(mappedBy="category",cascade=CascadeType.ALL,orphanRemoval=true)
@JsonManagedReference
List<Product>products=new ArrayList<>();


public Category(int cid, String cname, List<Product> products) {
	
	this.cid = cid;
	this.cname = cname;
	this.products = products;
}



public Category() {
}



public int getCid() {
	return cid;
}



public void setCid(int cid) {
	this.cid = cid;
}



public String getCname() {
	return cname;
}



public void setCname(String cname) {
	this.cname = cname;
}



public List<Product> getProducts() {
	return products;
}



public void setProducts(List<Product> products) {
	this.products = products;
}





}











