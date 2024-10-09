package entity;

public class product {
	public static void main(String[] args) {
		System.out.println("code is right");
	}
    private int productId;
    private String productName;
    private String description;
    private double price;
    private int quantityInStock;
    private String type;

    public product() {}

    public product(int productId, String productName, String description, double price, int quantityInStock, String type) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.type = type;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        if (quantityInStock >= 0) { 
            this.quantityInStock = quantityInStock;
        } else {
            throw new IllegalArgumentException("Quantity in stock cannot be negative.");
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.equals("Electronics") || type.equals("Clothing")) { 
            this.type = type;
        } else {
            throw new IllegalArgumentException("Type must be 'Electronics' or 'Clothing'.");
        }
 
    }
}

