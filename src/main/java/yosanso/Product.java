package yosanso;

public class Product {
	private int productNo;
	private String productName;
	private char category;
	private int price;
	private int stock;
	private String productDate;
	private int sellRate;

	public Product() {}
	
	public Product(int productNo, String productName, char category, int price, int stock, String productDate,
			int sellRate) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.productDate = productDate;
		this.sellRate = sellRate;
	}
	
	public Product(int productNo, String productName, char category, int price) {
		this.productNo = productNo;
		this.productName = productName;
		this.category = category;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", productName=" + productName + ", category=" + category
				+ ", price=" + price + ", stock=" + stock + ", productDate=" + productDate + ", sellRate=" + sellRate
				+ "]";
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public char getCategory() {
		return category;
	}
	public void setCategory(char category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getProductDate() {
		return productDate;
	}
	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}
	public int getSellRate() {
		return sellRate;
	}
	public void setSellRate(int sellRate) {
		this.sellRate = sellRate;
	}
	
	

	
}
