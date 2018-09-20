package data;

public class User {
    private String username;
    private String password;
    private int balance;
    
    public User() {
        this.balance = 0;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 0;
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
        if(balance >= price){
            this.balance -= price;
            return true;
        }
        return false;
    }
    
    
}
