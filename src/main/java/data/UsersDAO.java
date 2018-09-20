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
                    + "values ('"+ user.getUsername() +"', '"+ user.getPassword() +"', '"+ user.getEmail() +"');";

            stmt.executeUpdate(query);
//            System.out.println(rs);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
