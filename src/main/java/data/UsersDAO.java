package data;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        if (userName == null || userName.isEmpty())
            return null;
        ResultSet rs = null;
        User localUser = new User();
        try {
            Statement stmt = con.getConnection().createStatement();
            String query = "SELECT * FROM usersDB.user natural join usersDB.balance\n"
                    + "where usersDB.user.username = '" + userName + "';";

            rs = stmt.executeQuery(query);

            if (rs.next()) {
                localUser.setUsername(rs.getString("username"));
                localUser.setPassword(rs.getString("password"));
                localUser.setBalance(rs.getInt("amount"));
                localUser.setEmail(rs.getString("email"));
                return localUser;
            }
//            return user;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
