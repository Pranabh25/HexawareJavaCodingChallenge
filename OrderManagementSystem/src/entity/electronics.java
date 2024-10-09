package entity;

public class electronics extends product {
	public static void main(String[] args) {
		System.out.println("code is asdf");
	}
    private String brand;          
    private int warrantyPeriod;    

    public electronics() {
        super(); 
    }
    
    public electronics(int productId, String productName, String description, double price, int quantityInStock, 
                       String type, String brand, int warrantyPeriod) {
        super(productId, productName, description, price, quantityInStock, type);  
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        if (warrantyPeriod >= 0) { 
            this.warrantyPeriod = warrantyPeriod;
        } else {
            throw new IllegalArgumentException("Warranty period cannot be negative.");
        }
    }

}
