package data;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsersDAO {

    private DBConnector con;
    private User user;

    public UsersDAO() {

        try {
            this.con = new DBConnector();
        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Couldn't connect to DB");
        }

    }

    public void createUser(User user) {
        ResultSet rs = null;

        try {
            Statement stmt = con.getConnection().createStatement();
            String query = "insert into usersDB.user\n"
                    + "values ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getEmail() + "');";

            stmt.executeUpdate(query);
//            System.out.println(rs);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public User getUser(String userName) {
        ResultSet rs = null;
        User user = new User();
        try {
            Statement stmt = con.getConnection().createStatement();
            String query = "SELECT * FROM usersDB.user natural join usersDB.balance\n"
                    + "where usersDB.user.username = '" + userName + "';";

            rs = stmt.executeQuery(query);

            if (rs.next()) {
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setBalance(rs.getInt("amount"));
                user.setEmail(rs.getString("email"));

            }
//            return user;
        } catch (Exception e) {
            System.out.println(e);
        }
        if (user.getUsername().isEmpty()) {
            return null;
        }
        return user;
    }
}
