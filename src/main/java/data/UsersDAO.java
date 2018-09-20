package data;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UsersDAO {

    private DBConnector con;

    public UsersDAO() {

        try {
            this.con = new DBConnector();
        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Couldn't connect to DB");
        }
    }
}
