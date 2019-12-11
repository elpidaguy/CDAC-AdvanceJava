package pojos;

public class Book {
	private int id;
	private String title,author,category;
	private double price;
	public Book(int id, String title, String author, String category, double price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getCategory() {
		return category;
	}
	public double getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return title+" "+author+" "+price;
	}
	
	

}
