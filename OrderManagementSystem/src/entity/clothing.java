package entity;

public class clothing extends product {
	public static void main(String[] args) {
		System.out.println("code is good");
	}
    private String size;     
    private String color;  

    public clothing() {
        super();  
    }

    public clothing(int productId, String productName, String description, double price, int quantityInStock, 
                    String type, String size, String color) {
        super(productId, productName, description, price, quantityInStock, type);
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
