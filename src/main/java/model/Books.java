package model;

public class Books {
	
	String ID;
	String name;
	String price;
	String author;
	String publishedYear;
	String discount;
	String status;
	
	
	
	public Books(String id2, String name, String price, String author, String publishedYear, String discount, String status) {
		super();
		id2 = id2;
		this.name = name;
		this.price = price;
		this.author = author;
		this.publishedYear = publishedYear;
		this.discount = discount;
		this.status = status;
	}
	public Books() {
		// TODO Auto-generated constructor stub
	}
	public String getID() {
		return ID;
	}
	public void setID(String id2) {
		ID = id2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishedYear() {
		return publishedYear;
	}
	public void setPublishedYear(String publishedYear) {
		this.publishedYear = publishedYear;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
