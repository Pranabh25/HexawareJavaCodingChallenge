package entity;

public class user {
	public static void main(String[] args) {
		System.out.println("code is zxv");
	}
    private int userId;           
    private String username;     
    private String password;     
    private String role;// Role of the user (Admin/User)

    public user() {}

    public user(int userId, String username, String password, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (role.equals("Admin") || role.equals("User")) { 
            this.role = role;
        } else {
            throw new IllegalArgumentException("Role must be 'Admin' or 'User'.");
        }
    }

}
