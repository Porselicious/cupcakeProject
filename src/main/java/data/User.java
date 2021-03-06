package data;

public class User {

    private String username;
    private String password;

   
    private String email;
    private int balance;
    private ShoppingBasket basket;

    public User() {
        this.balance = 0;
        this.username = null;
        this.basket = new ShoppingBasket();

    }
    public ShoppingBasket getBasket() {
        return basket;
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.balance = 0;
        this.basket = new ShoppingBasket();
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", email=" + email + ", balance=" + balance + '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean withdraw(int price) {
        if (balance >= price) {
            this.balance -= price;
            return true;
        }
        return false;
    }
    
    

}
