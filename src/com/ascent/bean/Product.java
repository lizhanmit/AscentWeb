package com.ascent.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable {

	private Integer id; 
	private String productnumber; 
	private String productname; 
	private String categoryno; 
	private String category;
	private String imagePath; 
	private String isnewproduct;
	private float price;
	private float vipprice;
	private String stock; 
	private String realstock;
	private String description; 
	private String weight;
	
	public Product() {

	}

	public Product(String productnumber, String productname, String categoryno, String category, String imagePath,
			String isnewproduct, float price, float vipprice, String stock, String realstock, String description,
			String weight) {
		super();
		this.productnumber = productnumber;
		this.productname = productname;
		this.categoryno = categoryno;
		this.category = category;
		this.imagePath = imagePath;
		this.isnewproduct = isnewproduct;
		this.price = price;
		this.vipprice = vipprice;
		this.stock = stock;
		this.realstock = realstock;
		this.description = description;
		this.weight = weight;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductnumber() {
		return productnumber;
	}

	public void setProductnumber(String productnumber) {
		this.productnumber = productnumber;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getCategoryno() {
		return categoryno;
	}

	public void setCategoryno(String categoryno) {
		this.categoryno = categoryno;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getIsnewproduct() {
		return isnewproduct;
	}

	public void setIsnewproduct(String isnewproduct) {
		this.isnewproduct = isnewproduct;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getVipprice() {
		return vipprice;
	}

	public void setVipprice(float vipprice) {
		this.vipprice = vipprice;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getRealstock() {
		return realstock;
	}

	public void setRealstock(String realstock) {
		this.realstock = realstock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	
}
